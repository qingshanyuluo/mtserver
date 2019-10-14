package com.xiaobawang.mtserver.controller;

import com.xiaobawang.mtserver.pojo.UploadImage;
import com.xiaobawang.mtserver.util.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class ImageController {
    private static final Logger log = LoggerFactory.getLogger(ImageController.class);
    @RequestMapping(value = "/upload")
    public UploadImage uploadImg(@RequestParam("img") MultipartFile file, @RequestParam("userId") String userId) {
        UploadImage u = new UploadImage();
        System.out.println("文件是："+ file);
        try {
            if (file.isEmpty()) {
                u.setOk(false);
                u.setUrl(null);
                return u;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            File fileDir = UploadUtil.getImgDirFile(userId);
            System.out.println("文件的相对路径"+fileDir.getAbsolutePath());
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName);
            System.out.println(newFile.getAbsolutePath());
            file.transferTo(newFile);// 文件写入
            u.setOk(true);
            u.setUrl("http://114.116.45.159:9001/movietravel/" + userId + "/" + "upload/imgs/" + fileName);
            return u;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        u.setOk(false);
        u.setUrl(null);
        return u;

    }

}
