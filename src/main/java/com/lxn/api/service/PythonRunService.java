package com.lxn.api.service;

public interface PythonRunService {
    /**
     * 运行某个位置的python脚本文件 得到结果
     * @param filepath
     * @return
     */
    double getPyResult(String filepath);
}
