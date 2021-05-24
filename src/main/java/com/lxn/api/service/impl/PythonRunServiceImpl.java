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
        String result = null;
        try {
            String[] args = new String[]{"python", "/lxn/test.py", filepath};
//            String[] args = new String[]{"python", "D:\\test.py", filepath};
            log.info(args.toString());
            log.info("python "+"/lxn/test.py "+filepath);
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                //执行结果加上回车
                sb.append(line).append("\n");
            }
            result = sb.toString();
            log.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
