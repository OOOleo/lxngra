package com.lxn.api.service.impl;

import cn.hutool.core.io.FileUtil;
import com.lxn.api.service.PythonRunService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
@Slf4j
public class PythonRunServiceImpl implements PythonRunService {

    @Value("${file-location}")
    String fileAddress;

    @Override
    public String getPyResult(String filepath) {
        log.info("执行python计算.....");
        String line = null;
        try {
            String[] args = new String[]{"python", "/lxn/test.py", filepath};
//            String[] args = new String[]{"python", "D:\\test.py", filepath};
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            log.info(sb.toString());
            in.close();
            proc.waitFor();
            FileUtil.del(filepath);
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
