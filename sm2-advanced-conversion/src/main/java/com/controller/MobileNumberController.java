package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.entity.MobileNumber;

@Controller
public class MobileNumberController {

	@RequestMapping("/toMobileNumber")
	public String toMobileNumber(){
		return "query_mobile_number";
	}
	
	@RequestMapping("/saveMobileNumber")
	public String saveMobileNumber(MobileNumber mobileNumber, HttpServletRequest request, RedirectAttributes attrs ){
		System.out.println(mobileNumber.getMobileNumber() + ":::"
				+ mobileNumber.getArea() + ":::" + mobileNumber.getMobileNumber());
		
		List<MobileNumber> mobileList =  (List<MobileNumber>) WebUtils.getSessionAttribute(request, "numberList");
	
		if (mobileList == null){
			mobileList = new ArrayList<MobileNumber>();
			mobileList.add(mobileNumber);
			
			WebUtils.setSessionAttribute(request, "numberList", mobileList);
		} else {
			mobileList.add(mobileNumber);
		}

		// 跳转时传递参数
		attrs.addAttribute("mobileNumber", mobileNumber.getMobileNumber());
		attrs.addFlashAttribute("flashMobileNumber", mobileNumber); 
					
		return "redirect:/findAllMobileNumbers";
	}
	
	@RequestMapping("/findAllMobileNumbers")
	public String findAllMobileNumbers(HttpServletRequest request, Integer mobileNumber, 
			@ModelAttribute("flashMobileNumber") MobileNumber flashMobileNumber){
		
		List<MobileNumber> mobileList =  (List<MobileNumber>) WebUtils.getSessionAttribute(request,"numberList");
		
		System.out.println("----------");
		System.out.println(mobileNumber);
		System.out.println(flashMobileNumber.getAmount());
		
		return "query_mobile_number";
	}
}
