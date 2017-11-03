package org.restWebService.RLibrary.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.restWebService.RLibrary.converter.BookTypeConverter;
import org.restWebService.RLibrary.domain.BookType;
import org.restWebService.RLibrary.dto.BookTypeDto;
import org.restWebService.RLibrary.repository.BookTypeRepository;
import org.restWebService.RLibrary.util.Constantes;
import org.restWebService.RLibrary.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookTypeService {
	
	@Autowired
	private BookTypeRepository bookTypeRepository;
	
	@Resource
	private BookTypeConverter bookTypeConverter;
	
	@PostConstruct
	public void inicialice(){
		String autoUpdate = Util.getProperties("application.properties").getProperty("spring.jpa.hibernate.ddl-auto");
		if(autoUpdate!=null && autoUpdate.equals(Constantes.S_UPDATE)){
			bookTypeRepository.deleteAll();
			List<BookType> listBookType = new ArrayList<>();
			listBookType.add( new BookType("Novela Histórica"));
			listBookType.add( new BookType("Aventura"));
			listBookType.add( new BookType("Romance"));
			bookTypeRepository.save(listBookType);
			System.out.println("Se han creado los distintos tipos de libros");
		}
	}
	
	/**
	 * Devuelve todos los tipos de libros por su descripcion
	 * @return
	 */
	public List<BookTypeDto> findAllByDescriptionDesc(){
		List<BookType> entities = bookTypeRepository.findAllByDescriptionDesc();
		List<BookTypeDto> res = bookTypeConverter.convertListEntityToListDto(entities);
		return res;
	}

}
