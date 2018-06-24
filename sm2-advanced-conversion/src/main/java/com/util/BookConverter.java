package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.entity.Book;

/**
 * 1/2. �Զ�������ת������ʵ��Converter�ӿ�
 * @author boode
 *
 */
public class BookConverter implements Converter<String, Book> {  // Converter<Դ, Ŀ��>

	/**
	 * bookStr: �������
	 * Book: ת�����
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
				
				// �ַ���-->����
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
