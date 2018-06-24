package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@RequestMapping("/toAddBook")
	public String toAddBook(){
		return "addbook";
	}
	
	@RequestMapping("/book/addBook") 
	public String addBook(@RequestParam(value="book") Book book){
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		System.out.println(book.getPublishDate());
		
		return "index";
	}
	
	
}
