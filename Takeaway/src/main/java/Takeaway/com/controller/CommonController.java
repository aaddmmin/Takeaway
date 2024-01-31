package Takeaway.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import Takeaway.com.common.R;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 文件的上传和下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    @Value("${Takeaway.path}")
    private String basePath;
    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        //file临时文件，本次请求后删除
        log.info(file.toString());
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重命名,防止同名覆盖
        String filename = UUID.randomUUID().toString() + suffix;
        //创建文件夹
        File dir = new File(basePath);
        //判断文件夹是否存在
        if(!dir.exists()){
            dir.mkdirs();
        }
        try {
            //将文件转到指定位置file.transferTo(new File(basePath+"hello.jpg"));
            file.transferTo(new File(basePath+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(filename);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public  void download(String name, HttpServletResponse response){

        try {
            //输入流,通过输入流获取数据
            FileInputStream fileInputStream = new FileInputStream(new File(basePath+name));
            //输出流,通过输出流将文件写回浏览器，在浏览器显示图片
            ServletOutputStream servletOutputStream = response.getOutputStream();
            //返回图形类型文件
            response.setContentType("image/jpeg");
            int len = 0;
            byte [] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) !=-1){
                servletOutputStream.write(bytes,0,len);
                servletOutputStream.flush();
            }
            servletOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
