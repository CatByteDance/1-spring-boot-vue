package org.example.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
//  等价于@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        //获取图片的原始名称
        System.out.println(photo.getOriginalFilename());
        //获取文件类型
        System.out.println(photo.getContentType());

//      获取到Web服务器的运行目录，因为最终是要将文件存储在Web服务器上，而这个Web服务器最终是运行在Linux系统上，因为这个项目是要部署到Linux系统上去的，放到云端
//      现在的Web服务器是idea自带的tomcat，以后项目部署到云端时tomcat也会在云端
//      获取到upload目录（实际不存在，会自动创建), 然后将上传的文件放在**/upload/之下
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
        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
