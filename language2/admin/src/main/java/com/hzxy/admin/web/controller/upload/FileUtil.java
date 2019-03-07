package com.hzxy.admin.web.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @Auther:lwq
 * @Date:2019/3/6
 * @Description:com.hzxy.admin.web.controller.upload
 * @version:1.0
 */
public class FileUtil {
    //文件上传工具类服务方法

    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception{


        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        fileName=UUID.randomUUID() + fileSuffix;

        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return  filePath+fileName;
    }

}
