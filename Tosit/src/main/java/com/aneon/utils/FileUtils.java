package com.aneon.utils;

import com.aneon.po.User;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileUtils {

    public static boolean fileUpload(HttpServletRequest request, HttpSession session, String resourcePath) {  //   /files/teacherFiles
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            // 获取上传的文件
            Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
            for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {

                MultipartFile multipartFile = entry.getValue();

                if (multipartFile != null) {
                    String path = request.getServletContext().getRealPath(resourcePath) + "\\" + ((User) session.getAttribute("User")).getUsername();
                    String filePath = path + "\\" + multipartFile.getOriginalFilename();
                    File dir = new File(path);
                    if (!dir.exists())
                        dir.mkdirs();
                    File file = new File(filePath);
                    if (file.exists())
                        file.delete();
                    try {
                        file.createNewFile();
                        multipartFile.transferTo(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}