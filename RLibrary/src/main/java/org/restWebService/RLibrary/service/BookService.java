package org.restWebService.RLibrary.service;

import java.util.List;

import javax.annotation.Resource;

import org.restWebService.RLibrary.converter.BookConverter;
import org.restWebService.RLibrary.domain.Book;
import org.restWebService.RLibrary.dto.BookDto;
import org.restWebService.RLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Resource
	private BookConverter bookConverter;
	
	/**
	 * Devuelve todos los libros por su title desc
	 * @return
	 */
	public List<BookDto> findAllByTitleDesc(){
		List<Book> entities = bookRepository.findAllByTitleDesc();
		List<BookDto> res = bookConverter.convertListEntityToListDto(entities);
		return res;
	}

}
