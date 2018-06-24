package com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("/uploadFile")
	public String uploadFile(MultipartFile file, HttpServletRequest request, Model model){

		//  ׼����
		// ���upload�ľ���·��
		String path = request.getServletContext().getRealPath("upload");
		System.out.println("upload path" + path);
		
		// ����ϴ��ļ�������
		String fileName = file.getOriginalFilename();
		
		// 1. ����Ŀ���ļ���ָ���ļ��Ĵ��·�����ļ����ƣ�
		File targetFile = new File(path, fileName);
		
		// 2. �����ļ�(�յ��ļ�)
		if (!targetFile.exists()){
			targetFile.mkdirs();
		}
		
		try {
			// 3. �����ļ�����
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ���ļ�����������ʱʹ��
		model.addAttribute("fileName", fileName);
		
		return "download";
	}
	
	@RequestMapping("/download")
	public String download(String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");		// 1/2
		
		if (fileName != null){
			
			String realPath = request.getServletContext().getRealPath("upload");


			// 1. �����ļ�
			File file = new File(realPath, fileName);

			// 2.
			if (file != null){
				response.setCharacterEncoding("UTF-8");
				response.setContentType("multipart/form-data");
				
				String recodedFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");	// 2/2
				
				response.setHeader("Content-Disposition", "attachment;fileName="+recodedFileName);					
			}	// if: file	
			
			// 3. ��д�ļ������ļ���Ӧ���ͻ�
			BufferedInputStream bis = null;
			OutputStream out = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(file));   // core
				out = response.getOutputStream();
				
				byte[] buffer = new byte[1024];
				
				int i = bis.read(buffer);
				
				while (i != -1){
					out.write(buffer);
					i = bis.read(buffer);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (out != null){
						out.close();
					}
					
					if (bis != null){
						bis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	// finally
			
		}	// if: fileName
		
		return null;
	}	
}
