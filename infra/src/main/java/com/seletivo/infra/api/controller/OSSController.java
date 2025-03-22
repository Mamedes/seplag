package com.seletivo.infra.api.controller;


import com.seletivo.infra.configuration.MinioConfig;
import com.seletivo.infra.configuration.MinioUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
public class OSSController {

    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioUtils minioUtils;


    /**
     * file upload
     *
     * @param file
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            //file name
            String fileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
            //type
            String contentType = file.getContentType();
            minioUtils.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            return "upload success";
        } catch (Exception e) {
            e.printStackTrace();

            return "upload fail";
        }
    }

}
