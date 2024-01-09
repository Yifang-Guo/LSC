package com.fangit.controller;

import com.fangit.pojo.Result;
import com.fangit.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Yifang
 * @version 1.0
 **/
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private StorageService storageService;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("upload file : {}", image);


        String url = storageService.uploadFile(image);
        //image.transferTo(new File("/Users/charlize/Downloads/test/" + newFileName));
        return Result.success(url);
    }
}
