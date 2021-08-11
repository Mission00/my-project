package com.example.demo.controller;

import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@Controller
public class FileController {
    @CrossOrigin
    @PostMapping("api/upload")
    @ResponseBody
    public String uploadImg(@RequestParam("file")MultipartFile multipartFile,HttpServletRequest request){
        System.out.println(multipartFile.getOriginalFilename());
        String filePath = "G:/disign/data/" + multipartFile.getOriginalFilename();
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 文件存储
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(request.getContextPath());
        return file.getAbsolutePath().replaceAll("\\\\", "/");
    }
}
