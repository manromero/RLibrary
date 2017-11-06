package org.restWebService.RLibrary.service;

import java.util.List;

import javax.annotation.Resource;

import org.restWebService.RLibrary.converter.BookUserReadedConverter;
import org.restWebService.RLibrary.domain.BookUserReaded;
import org.restWebService.RLibrary.dto.BookUserReadedDto;
import org.restWebService.RLibrary.repository.BookUserReadedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookUserReadedService {
	
	@Autowired
	private BookUserReadedRepository bookUserReadedRepository;
	
	@Resource
	private BookUserReadedConverter bookUserReadedConverter;
	
	/**
	 * Elimina todos los BookUserReaded asociados a un id Book
	 * @param idBook
	 */
	public void deleteByIdBook(Long idBook){
		if(idBook!=null && !idBook.equals(0l)){
			List<BookUserReaded> listBookUserReaded = bookUserReadedRepository.findByIdBook(idBook);
			bookUserReadedRepository.delete(listBookUserReaded);
		}
	}

	/**
	 * Guarda una relacion book - user en la base de datos
	 * Indica que un usuario ya ha leido un libro (puede incluir una puntuación)
	 * @param bookUserReadedDto
	 * @return
	 */
	public BookUserReadedDto save(BookUserReadedDto bookUserReadedDto) {
		// TODO Auto-generated method stub
		return null;
	} 

}
