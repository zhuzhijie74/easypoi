package com.example.easypoi.controller;

import com.example.easypoi.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/download")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("word")
    public void download(HttpServletResponse response) throws Exception{
        wordService.exportWord(response);
    }
}
