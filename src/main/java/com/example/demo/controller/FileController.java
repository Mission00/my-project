package com.example.demo.controller;

import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
    @CrossOrigin
    @PostMapping("api/admin/file/upload")
    @ResponseBody
    public String uploadImg(@RequestParam("file")MultipartFile multipartFile,HttpServletRequest request){
        System.out.println(multipartFile.getOriginalFilename());
        String originalFileName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replaceAll("-", "")
                +originalFileName.substring(originalFileName.lastIndexOf("."));//uuid随机生成文件名
        String filePath = "G:/disign/data/" + fileName;
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
        System.out.println(fileName);
        //return file.getAbsolutePath().replaceAll("\\\\", "/");
        return fileName;
    }


    @CrossOrigin
    @PostMapping("api/file/upload")
    @ResponseBody
    public String uploadImg2(@RequestParam("file")MultipartFile multipartFile,HttpServletRequest request){
        System.out.println(multipartFile.getOriginalFilename());
        String originalFileName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replaceAll("-", "")
                +originalFileName.substring(originalFileName.lastIndexOf("."));//uuid随机生成文件名
        String filePath = "G:/disign/data/" + fileName;
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
        System.out.println(fileName);
        //return file.getAbsolutePath().replaceAll("\\\\", "/");
        return fileName;
    }
    @CrossOrigin
    @GetMapping("api/admin/file/remove")
    @ResponseBody
    public Boolean removeFile(String fileName){
        File file = new File("G:/disign/data/"+fileName);
        if (file.exists()) {
            file.delete();
            System.out.println("===========删除成功=================");
            return true;
        } else {
            System.out.println("===============删除失败==============");
            return false;
        }
    }

}
