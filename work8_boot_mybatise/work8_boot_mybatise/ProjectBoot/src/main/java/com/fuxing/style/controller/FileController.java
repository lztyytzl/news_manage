package com.fuxing.style.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class FileController {  
  
    /** 
     * 文件上传具体实现方法; 
     * @param file 
     * @return 
     */  
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){  
            try {  
                String fileName = file.getOriginalFilename();  
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("D:\\files\\" + fileName)));
                out.write(file.getBytes());  
                out.flush();  
                out.close();  
            } catch (FileNotFoundException e) {
                e.printStackTrace();  
                return"上传失败,"+e.getMessage();  
            } catch (IOException e) {
                e.printStackTrace();  
                return"上传失败,"+e.getMessage();  
            }  
            return"上传成功";  
        }else{  
            return"上传失败，因为文件是空的.";  
        }  
    }  
    @RequestMapping(value = "/fileDownload")  
    @ResponseBody  
        public String download(HttpServletResponse response) throws Exception {
            BufferedInputStream bis = null;  
            BufferedOutputStream bos = null;  
            //获取下载文件露肩  
            String downLoadPath = "C:\\Users\\DIY\\Desktop\\some\\PDF\\Android开发艺术探索.pdf";
  
            /*response.setHeader("content-type", "application/octet-stream"); 
 
            //获取文件的长度 
            long fileLength = new File(downLoadPath).length(); 
            //设置文件输出类型 
            response.setContentType("application/octet-stream"); 
            //设置输出长度 
            response.setHeader("Content-Length", String.valueOf(fileLength));*/  
        /********************************************************************/  
            //获取输入流  
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
            //输出流  
            bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\files\\Android开发艺术探索.pdf")));
            byte[] buff = new byte[2048];  
            int bytesRead;  
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
                bos.write(buff, 0, bytesRead);  
            }  
            //关闭流  
            bis.close();  
            bos.close();  
  
        return "下载成功";  
    }  
  
    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
    @ResponseBody  
    public String handleFileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;  
        BufferedOutputStream stream = null;  
        for (int i =0; i< files.size(); ++i) {  
            file = files.get(i);  
            if (!file.isEmpty()) {  
                try {  
                   BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\files\\" + file.getOriginalFilename())));
                   bufferedOutputStream.write(file.getBytes());  
                   bufferedOutputStream.flush();  
                   bufferedOutputStream.close();  
                } catch (Exception e) {  
                    return "You failed to upload " + i + " => " + e.getMessage();  
                }  
            } else {  
                return "You failed to upload " + i + " because the file was empty.";  
            }  
        }  
        return "上传成功";  
    }  
}  