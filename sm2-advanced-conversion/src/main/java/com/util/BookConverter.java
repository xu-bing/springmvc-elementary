package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.entity.Book;

/**
 * 1/2. 自定义类型转换器，实现Converter接口
 * @author boode
 *
 */
public class BookConverter implements Converter<String, Book> {  // Converter<源, 目标>

	/**
	 * bookStr: 输入参数
	 * Book: 转换结果
	 */
	@Override
	public Book convert(String bookStr) {
		Book book = null;
		
		// bookStr = "java,23,1991-1-1";

		if (bookStr != null){
			String[] params = bookStr.split(",");
			
			if (params != null && params.length == 3){
				
				book = new Book();
				book.setName(params[0]);
				book.setPrice(Double.parseDouble(params[1]));
				
				// 字符串-->日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					Date d = sdf.parse(params[2]);
					book.setPublishDate(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return book;
			} else {
				return null;
			}
			
		} else {
			return null;
		}		
	}	

}
