package com.lxn.api.service;

import java.io.File;

public interface FileService {

    /**
     * 将文件保存到固定路径
     * @param file
     */
    void saveFile(File file);
}
