package com.lxn.api.service.impl;

import com.lxn.api.service.PythonRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PythonRunServiceImpl implements PythonRunService {

    @Value("${file-location}")
    String fileAddress;


    @Override
    public double getPyResult(String filepath) {
        return 0;
    }
}
