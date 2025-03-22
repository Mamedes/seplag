package com.seletivo.infra.api.controller.fotoPessoa.presenters;

import com.seletivo.application.pessoaFoto.FotoPessoaOutput;
import com.seletivo.infra.api.controller.fotoPessoa.FotoPessoaResponse;
import com.seletivo.infra.configuration.MinioConfig;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class FotoPessoaApiPresenter {

    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient minioClient;

    public FotoPessoaResponse present(final FotoPessoaOutput output) {
        String presignedUrl = null;
        try {
            presignedUrl = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(minioConfig.getBucketName())
                            .object(output.bucket())
                            .expiry(5, TimeUnit.MINUTES) // 5 minutos de expiração
                            .build());
        } catch (Exception e) {
            // Lidar com a exceção, por exemplo, logar o erro ou lançar uma exceção personalizada
            e.printStackTrace();
        }

        return new FotoPessoaResponse(
                output.id().getValue(),
                output.pessoaID().getValue(),
                output.data(),
                output.bucket(),
                presignedUrl,
                output.hash()
        );
    }
}