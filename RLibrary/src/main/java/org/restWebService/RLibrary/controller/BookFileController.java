package org.restWebService.RLibrary.controller;

import java.util.List;

import org.restWebService.RLibrary.dto.BookFileDto;
import org.restWebService.RLibrary.service.BookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookFile")
public class BookFileController {
	
	@Autowired
	private BookFileService bookFileService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public BookFileDto save(@RequestBody BookFileDto bookFileDto){
		return bookFileService.save(bookFileDto);
	}
	
	@RequestMapping(value = "/findByIdBook/{idBook}", method = RequestMethod.GET)
	public List<BookFileDto> findByIdBook(@PathVariable("idBook") Long idBook){
		return bookFileService.findByIdBook(idBook);
	}
	
	@RequestMapping(value = "/delete/{idBookFile}", method = RequestMethod.GET)
	public BookFileDto delete(@PathVariable("idBookFile") Long idBookFile){
		return bookFileService.delete(idBookFile);
	}
	
}