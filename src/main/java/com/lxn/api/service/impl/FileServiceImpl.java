package com.lxn.api.service.impl;

import com.lxn.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file-location}")
    String fileAddress;


    @Override
    public void saveFile(File file) {

    }
}
