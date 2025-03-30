package com.seletivo.application.pessoaFoto.update;
import com.seletivo.application.arquivo.ArquivoDTO;
import com.seletivo.application.pessoaFoto.FotoPessoaOutput;
import com.seletivo.application.utils.FileUtils;
import com.seletivo.domain.arquivo.ArquivoStorageGateway;
import com.seletivo.domain.pessoa.*;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import static io.vavr.API.Left;

public class DefaultUpdatePessoaFotoUseCase extends UpdatePessoaFotoUseCase {

    private final FotoPessoaGateway fotoPessoaGateway;
    private final PessoaGateway pessoaGateway;
    private final ArquivoStorageGateway arquivoStorageGateway;

    public DefaultUpdatePessoaFotoUseCase(final FotoPessoaGateway fotoPessoaGateway,
                                          final PessoaGateway pessoaGateway, final ArquivoStorageGateway arquivoStorageGateway) {
        this.fotoPessoaGateway = Objects.requireNonNull(fotoPessoaGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
        this.arquivoStorageGateway = Objects.requireNonNull(arquivoStorageGateway);
    }

    @Override
    @Transactional
    public Either<Notification, FotoPessoaOutput> execute(final UpdateFotoPessoaCommand aCommand) {
        final var fotoId = aCommand.id();
        final var pessoaID = aCommand.pessoaID();
        final var arquivos = aCommand.arquivos();
        final var notification = Notification.create();

        final var fotoPessoa = fotoPessoaGateway.findById(FotoPessoaID.from(fotoId))
                .orElse(null);

        if (fotoPessoa == null) {
            return Left(Notification.create().append(new com.seletivo.domain.validation.Error("Foto não encontrada")));
        }

        Optional<Pessoa> pessoa = pessoaGateway.findById(PessoaID.from(pessoaID));
        if (pessoa.isEmpty()) {
            return Left(Notification.create().append(new com.seletivo.domain.validation.Error("Pessoa não encontrada")));
        }

        try {
            if (arquivos != null && !arquivos.isEmpty()) {
                ArquivoDTO arquivoDTO = arquivos.get(0);
                String bucketPath = "foto-" + FileUtils.generateRandomHash() + "." + FileUtils.getFileExtension(arquivoDTO.nomeArquivo());

                arquivoStorageGateway.deleteArquivo(fotoPessoa.getBucket());

                final var updatedFotoPessoa = fotoPessoa.update(PessoaID.from(pessoaID), LocalDate.now(), bucketPath, FileUtils.generateRandomHash());

                updatedFotoPessoa.validate(notification);

                if (notification.hasError()) {
                    return Left(notification);
                }
                FotoPessoa fotoSalva = this.fotoPessoaGateway.update(updatedFotoPessoa);

                arquivoStorageGateway.uploadArquivo(arquivoDTO.conteudo(), arquivoDTO.nomeArquivo(),
                        arquivoDTO.tipoConteudo(), bucketPath);

                return Either.right(FotoPessoaOutput.from(fotoSalva));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a foto: " + e.getMessage(), e);
        }

        return Either.right(FotoPessoaOutput.from(fotoPessoa));
    }

}