package com.xiaobawang.mtserver.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class UploadUtil {


    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "upload/imgs";

    public static File getImgDirFile(String id) throws FileNotFoundException {

        String path = ResourceUtils.getURL("classpath:").getPath()+"static/";

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = path + id + "/" + IMG_PATH_PREFIX;

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}

