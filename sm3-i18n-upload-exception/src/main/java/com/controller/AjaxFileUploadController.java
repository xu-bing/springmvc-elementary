package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxFileUploadController {

	@RequestMapping("/upload")
	@ResponseBody   // ����json
	public Map<String,Object> uploadFile(MultipartFile file,HttpServletRequest request){
				// ���upload�ľ���·��
				String path = request.getServletContext().getRealPath("upload");
				System.out.println("upload path" + path);
				
				
				boolean b = true;
				
				// ����ļ�������
				String fileName = file.getOriginalFilename();
				
				// 1. ����Ŀ���ļ�
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
					b = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					b = false;
				}
				
				Map<String, Object> resultMap = new HashMap<String,Object>();
				//�����ϴ�ͼƬ�ڷ����������·��
				resultMap.put("fileUrl", request.getContextPath() + "/upload/" +fileName);
				//�����ϴ��Ľ��
				resultMap.put("result", b);
				
				return resultMap;
	}
}
