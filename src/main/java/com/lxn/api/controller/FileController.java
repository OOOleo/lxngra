package com.lxn.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxn.api.service.FileService;
import com.lxn.api.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Api(tags = {"保存上传的文件"})
@RequestMapping("/file")
@RestController
@Slf4j
public class FileController {

    @Value("${file-location}")
    String fileAddress;

    @Autowired
    FileService fileService;

    @ApiOperation("上传文件保存")
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping
    public String uploadFile(HttpServletResponse response, HttpServletRequest request) throws Exception {
        fileService.uploadFile(response, request);
        sendResponse(JSONObject.toJSONString(ResultUtil.success()), response);
        return null;
    }


    private void sendResponse(String responseString,HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(responseString);
            pw.flush();
        } finally {
            IOUtils.closeQuietly(pw);
        }
    }
}
