package com.seletivo.application.pessoaFoto;

import com.seletivo.application.arquivo.ArquivoDTO;
import com.seletivo.domain.arquivo.ArquivoStorageGateway;
import com.seletivo.domain.pessoa.*;
import com.seletivo.domain.validation.Error;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;

import static io.vavr.API.Left;

public class DefaultCreatePessoaFotoUseCase extends CreatePessoaFotoUseCase {
    private final FotoPessoaGateway fotoPessoaGateway;
    private final PessoaGateway pessoaGateway;
    private final ArquivoStorageGateway arquivoStorageGateway;

    public DefaultCreatePessoaFotoUseCase(final FotoPessoaGateway fotoPessoaGateway,
            final PessoaGateway pessoaGateway, final ArquivoStorageGateway arquivoStorageGateway) {
        this.fotoPessoaGateway = Objects.requireNonNull(fotoPessoaGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
        this.arquivoStorageGateway = Objects.requireNonNull(arquivoStorageGateway);
    }

    @Override
    @Transactional
    public Either<Notification, List<CreateFotoPessoaOutput>> execute(
            final CreateFotoPessoaCommand aCommand) {
        final var pessoaID = aCommand.pessoaID();
        final var arquivos = aCommand.arquivos();
        final var notification = Notification.create();
        final List<CreateFotoPessoaOutput> outputs = new ArrayList<>();
        final List<String> arquivosEnviados = new ArrayList<>();
        if (arquivos == null || arquivos.isEmpty()) {
            return Left(Notification.create().append(new Error("Files are required")));
        }

        Optional<Pessoa> pessoa = pessoaGateway.findById(PessoaID.from(pessoaID));
        if (pessoa.isEmpty()) {
            return Left(Notification.create().append(new Error("Pessoa não encontrada")));
        }
        try {
            for (ArquivoDTO arquivoDTO : arquivos) {
                String randomHash = generateRandomHash();
                String bucketPath =
                        "foto-" + randomHash + "." + getFileExtension(arquivoDTO.nomeArquivo());


                final var aFotoPessoa = FotoPessoa.newFotoPessoa(PessoaID.from(pessoaID),
                        LocalDate.now(), bucketPath, randomHash);
                aFotoPessoa.validate(notification);

                if (notification.hasError()) {
                    return Left(notification);
                }
                FotoPessoa fotoSalva = this.fotoPessoaGateway.create(aFotoPessoa);
                arquivoStorageGateway.uploadArquivo(arquivoDTO.conteudo(), arquivoDTO.nomeArquivo(),
                        arquivoDTO.tipoConteudo(), bucketPath);
                arquivosEnviados.add(bucketPath);

                outputs.add(CreateFotoPessoaOutput.from(fotoSalva));
            }
        } catch (Exception e) {

            try {

                arquivoStorageGateway.deleteArquivos(arquivosEnviados);
            } catch (Exception ex) {
                throw new RuntimeException("Erro  rolback foto: " + e.getMessage(), e);
            }

            throw new RuntimeException("Erro ao salvar a foto: " + e.getMessage(), e);
        }

        return Either.right(outputs);
    }


    private String generateRandomHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(
                    java.util.UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
            String base64Hash = Base64.getEncoder().encodeToString(hash);

            return base64Hash.substring(0, Math.min(30, base64Hash.length()))
                    .replaceAll("[^a-zA-Z0-9]", "");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }


    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(dotIndex + 1);
    }

}
