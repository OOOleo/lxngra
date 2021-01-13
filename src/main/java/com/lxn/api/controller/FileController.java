package com.lxn.api.controller;

import com.lxn.api.base.Result;
import com.lxn.api.service.FileService;
import com.lxn.api.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"保存上传的文件"})
@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    FileService fileService;


    @ApiOperation("上传文件保存")
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping
    public Result uploadFile(){
        //fileService.saveFile();

        return ResultUtil.success();
    }
}
