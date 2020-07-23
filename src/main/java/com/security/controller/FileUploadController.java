package com.security.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class FileUploadController {
    @RequestMapping(value = "/uploadFile ", method = RequestMethod.GET)
	public String fileForm()
	{
		return "upload-file";
	}
	
    @RequestMapping(value = "/upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
	         throws IOException {

	      // Save file on system
	      if (!file.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File("/webapp/resources/blogImage", file.getOriginalFilename())));
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();

	         model.addAttribute("msg", "File uploaded successfully.");
	      } else {
	         model.addAttribute("msg", "Please select a valid file..");
	      }

	      return "upload-file";
	   }
}
