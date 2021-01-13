package com.lxn.api.controller;


import com.lxn.api.base.Response;
import com.lxn.api.base.Result;
import com.lxn.api.service.PythonRunService;
import com.lxn.api.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Python计算"})
@RequestMapping("/python")
@RestController
public class PythonRunController {

    @Autowired
    PythonRunService pythonRunService;

    @ApiOperation("python")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public Result getPyCalRes(){


        return ResultUtil.success();
    }


}
