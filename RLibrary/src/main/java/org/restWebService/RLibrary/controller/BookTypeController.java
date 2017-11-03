package org.restWebService.RLibrary.controller;

import java.util.List;

import org.restWebService.RLibrary.dto.BookTypeDto;
import org.restWebService.RLibrary.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookType")
public class BookTypeController {
	
	@Autowired
	private BookTypeService bookTypeService;
	
	@RequestMapping(value = "/findAllByDescriptionDesc", method = RequestMethod.GET)
	public List<BookTypeDto> findAllByDescriptionDesc(){
		return bookTypeService.findAllByDescriptionDesc();
	}
	
}
