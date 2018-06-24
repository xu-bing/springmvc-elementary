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
	@ResponseBody   // 返回json
	public Map<String,Object> uploadFile(MultipartFile file,HttpServletRequest request){
				// 获得upload的绝对路径
				String path = request.getServletContext().getRealPath("upload");
				System.out.println("upload path" + path);
				
				
				boolean b = true;
				
				// 获得文件的名称
				String fileName = file.getOriginalFilename();
				
				// 1. 创建目标文件
				File targetFile = new File(path, fileName);
				
				// 2. 创建文件(空的文件)
				if (!targetFile.exists()){
					targetFile.mkdirs();
				}
				
				try {
					// 3. 传输文件内容
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
				//返回上传图片在服务器的相对路径
				resultMap.put("fileUrl", request.getContextPath() + "/upload/" +fileName);
				//返回上传的结果
				resultMap.put("result", b);
				
				return resultMap;
	}
}
