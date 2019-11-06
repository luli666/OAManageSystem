package com.offcn.commons;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class Load {

    public static String upload(MultipartFile multipart, String realPath) {
        File file = new File(realPath);
        /*判断文件夹是否存在，若不存在则创建文件夹*/
        if(!file.exists()){
            file.mkdirs();
        }
        /*生成文件名*/
        String filepath = UUID.randomUUID().toString().replace("-", "") + multipart.getOriginalFilename();
        String path = realPath + "\\" + filepath;
        try {
            multipart.transferTo(new File(path));
            return filepath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static ResponseEntity<byte[]> download(String realpath, String filepath) {
        try {
            //获取文件
            FileInputStream fis = new FileInputStream(realpath+ "\\" +filepath);
            //获取文件大小的字节数组
            byte[] bytes = new byte[fis.available()];
            if(filepath.length() > 32 ){
                filepath = filepath.substring(32);
            }
            filepath = new String(filepath.getBytes("gbk"),"iso8859-1");
            fis.read(bytes);
            /*获取响应头*/
            MultiValueMap<String,String> headers = new HttpHeaders();
            /*设置响应头信息*/
            headers.set("Content-Disposition", "attachment;filename="+filepath);

            return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
