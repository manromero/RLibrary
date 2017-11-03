package org.restWebService.RLibrary.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.restWebService.RLibrary.converter.BookConverter;
import org.restWebService.RLibrary.domain.Book;
import org.restWebService.RLibrary.dto.BookDto;
import org.restWebService.RLibrary.repository.BookRepository;
import org.restWebService.RLibrary.util.Constantes;
import org.restWebService.RLibrary.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookTypeService bookTypeService;
	
	@Resource
	private BookConverter bookConverter;
	
	@PostConstruct
	public void cargaEntidadesPrueba(){
		String cargaEntidades = Util.getProperties("application.properties").getProperty("carga.entidades.prueba");
		if(cargaEntidades!=null && cargaEntidades.equals(Constantes.S_TRUE)){
			bookRepository.deleteAll();
			List<Book> listBooks = new ArrayList<>();
			listBooks.add(new Book("Autor Libro 1", "Título Libro 1", "Descripción Libro 1", null, bookTypeService.findEntityByDescription("Aventura")));
			listBooks.add(new Book("Autor Libro 2", "Título Libro 2", "Descripción Libro 2", null, bookTypeService.findEntityByDescription("Romance")));
			listBooks.add(new Book("Autor Libro 3", "Título Libro 3", "Descripción Libro 3", null, bookTypeService.findEntityByDescription("Novela Histórica")));
			listBooks.add(new Book("Autor Libro 4", "Título Libro 4", "Descripción Libro 4", null, bookTypeService.findEntityByDescription("Aventura")));
			listBooks.add(new Book("Autor Libro 5", "Título Libro 5", "Descripción Libro 5", null, bookTypeService.findEntityByDescription("Romance")));
			bookRepository.save(listBooks);
			System.out.println("Se han cargado los libros de prueba");
		}
	}
	
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
