package com.sutiboot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sutiboot.domain.FileUpload;
import com.sutiboot.service.FileService;

@Controller
public class FilesController  {
	
	 @Autowired
	    private FileService fileService;

	@PostMapping(path = "upload")
	public ModelAndView singleFileUpload(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			try {
				byte[] bytes = file.getBytes();
				String mimeType = file.getContentType();
				String filename = file.getOriginalFilename();
				FileUpload fileUpload = new FileUpload(filename, bytes, mimeType);
				fileService.save(fileUpload);
				System.out.println("Successfully Uploaded the files you have uploaded");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping(path = "mailwithupload")
	public ModelAndView mail_Files_Upload(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			try {
				byte[] bytes = file.getBytes();
				String mimeType = file.getContentType();
				String filename = file.getOriginalFilename();
				FileUpload fileUpload = new FileUpload(filename, bytes, mimeType);
				fileService.save(fileUpload);
				System.out.println("Successfully Uploaded the files you have uploaded");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/#/mail");
	}
}
