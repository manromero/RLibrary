package org.restWebService.RLibrary.controller;

import org.restWebService.RLibrary.dto.BookUserReadedDto;
import org.restWebService.RLibrary.service.BookUserReadedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookUserReaded")
public class BookUserReadedController {
	
	@Autowired
	private BookUserReadedService bookUserReadedService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public BookUserReadedDto save(@RequestBody BookUserReadedDto bookUserReadedDto){
		return bookUserReadedService.save(bookUserReadedDto);
	}
	
}
