package org.restWebService.RLibrary.service;

import java.util.List;

import javax.annotation.Resource;

import org.restWebService.RLibrary.converter.BookUserPendingConverter;
import org.restWebService.RLibrary.domain.BookUserPending;
import org.restWebService.RLibrary.dto.BookUserPendingDto;
import org.restWebService.RLibrary.repository.BookUserPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookUserPendingService {
	
	@Autowired
	private BookUserPendingRepository bookUserPendingRepository;
	
	@Resource
	private BookUserPendingConverter bookUserPendingConverter;
	
	/**
	 * Elimina todos los BookUserPending asociados a un id Book
	 * @param idBook
	 */
	public void deleteByIdBook(Long idBook){
		if(idBook!=null && !idBook.equals(0l)){
			List<BookUserPending> listBookUserPending = bookUserPendingRepository.findByIdBook(idBook);
			bookUserPendingRepository.delete(listBookUserPending);
		}
	}

	/**
	 * Guarda una relacion user - book que indica que un usuario tiene pendiente de lectura un determiado libro
	 * @param bookUserPendingDto
	 * @return
	 */
	public BookUserPendingDto save(BookUserPendingDto bookUserPendingDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
