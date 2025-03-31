package com.seletivo.infra.api.controller.servidorEfetivo.presenters;

import com.seletivo.application.servidorEfetivo.ServidorEfetivoByUnidadeOutput;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoByUnidadeResponse;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoResponse;
import com.seletivo.infra.configuration.MinioConfig;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ServidorListByUnidadeApiPresenter {

    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient minioClient;

    public ServidorEfetivoByUnidadeResponse present(final ServidorEfetivoByUnidadeOutput output) {
        String presignedUrl = null;
        try {
            presignedUrl = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(minioConfig.getBucketName())
                            .object(output.bucketFoto())
                            .expiry(5, TimeUnit.MINUTES)
                            .build());
            if (presignedUrl != null) {
                presignedUrl = presignedUrl.replace("http://minio:9000", "http://localhost:9003");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ServidorEfetivoByUnidadeResponse(
                output.nome(),
                output.idade(),
                output.nomeUnidade(),
                presignedUrl
        );
    }
}