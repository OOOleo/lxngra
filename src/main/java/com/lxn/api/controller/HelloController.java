package com.lxn.api.controller;

import com.lxn.api.base.Result;
import com.lxn.api.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"test"})
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Result hello() {
        String str = "hello";
        return ResultUtil.result(str);
    }
}
