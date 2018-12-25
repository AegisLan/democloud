package com.example.eurekaclient.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author aegis
 * @date 2018-12-24 20:35
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody
    String doFileUpload(@RequestParam(value = "file") MultipartFile file, HttpSession session) throws IOException {
        String path = session.getServletContext().getRealPath("/images");
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File newFile = new File(path + "/" + file.getOriginalFilename());
        file.transferTo(newFile);
        return "success";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String onError() {
        return "failed";
    }

}
