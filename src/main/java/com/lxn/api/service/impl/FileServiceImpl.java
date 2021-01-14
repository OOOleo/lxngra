package com.lxn.api.service.impl;

import com.lxn.api.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${file-location}")
    String fileAddress;

    @Override
    public void uploadFile(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String filename = request.getParameter("filename");
        String path = fileAddress + "\\copy\\";
        String fullPath = path + filename;
        InputStream input = null;
        FileOutputStream fos = null;
        try {
            input = request.getInputStream();
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream(fullPath);
            int size = 0;
            byte[] buffer = new byte[1024];
            while ((size = input.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, size);
            }
            log.info("文件写入成功");
        }catch (IOException e){
            log.error("文件写入错误|msg={}",e.getMessage());
        }finally {
            if(input != null){
                input.close();
            }
            if(fos != null){
                fos.close();
            }
        }
    }
}
