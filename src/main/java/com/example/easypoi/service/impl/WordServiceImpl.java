package com.example.easypoi.service.impl;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.easypoi.service.WordService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WordServiceImpl extends ServiceImpl implements WordService {
    @Override
    public void exportWord(HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("college", "计算机学院");
        map.put("department", "人工智能系");
        map.put("name", "张三");
        map.put("sex", "女");
        map.put("birthday", "2000-1-1");
        map.put("politicalStatus", "党员");
        map.put("positions", "书记");
        map.put("employmentPositions", "无");


        File templateFile = new File("E:\\javaProject\\easypoi\\src\\main\\resources\\template\\template.docx");
        XWPFDocument word = null;
        try {
            word = WordExportUtil.exportWord07(templateFile.getPath(), map);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String filename = "XX大学考核表.docx";
        try {
            response.setHeader("content-disposition","attachment;filename="+new String(filename.getBytes(),"ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        try {
            if (word != null) {
                word.write(response.getOutputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
