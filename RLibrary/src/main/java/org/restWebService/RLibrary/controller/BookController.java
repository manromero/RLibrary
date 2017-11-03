package org.restWebService.RLibrary.controller;

import java.util.List;

import org.restWebService.RLibrary.dto.BookDto;
import org.restWebService.RLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/findAllByTitleDesc", method = RequestMethod.GET)
	public List<BookDto> findAllByTitleDesc(){
		return bookService.findAllByTitleDesc();
	}
	
}