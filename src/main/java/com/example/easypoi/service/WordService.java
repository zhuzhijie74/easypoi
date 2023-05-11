package com.example.easypoi.service;

import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;

public interface WordService extends IService{


    public void exportWord(HttpServletResponse response) throws Exception;
}
