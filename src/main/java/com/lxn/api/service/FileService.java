package com.lxn.api.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileService {

    /**
     * 将文件保存到固定路径
     */
    void uploadFile(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
