package org.example.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
//  参数多了或者少了都不会有影响，想要准确匹配个数可以使用@RequestParams
//  表单key名称必须与这里的一致,如归上传file类型，则要用MultipartFile接收，
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);

//      可以获取一系列文件的属性
        //获取图片的原始名称
        System.out.println(photo.getOriginalFilename());
        //获取文件类型
        System.out.println(photo.getContentType());


//      动态地获取到web服务器所在的位置
//      然后创建upload目录（实际不存在，会自动创建), 然后将上传的文件放在**/upload/之下
        String path = request.getServletContext().getRealPath("/upload/");

        System.out.println(path);
        saveFile(photo, path);
        return "success";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
//      判断存储的目录是否存在，如果不存在则创建
        File dir = new File(path);
        if (!dir.exists()) {
//            创建目录
            dir.mkdirs();
        }

//      这里的file代表的是最终存储的文件，不仅要有路径还要有文件名
//      如果想将上传的文件存在固定的地方可以将路径写死
        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
