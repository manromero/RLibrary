package org.restWebService.RLibrary.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.restWebService.RLibrary.converter.BookFileTypeConverter;
import org.restWebService.RLibrary.domain.BookFileType;
import org.restWebService.RLibrary.repository.BookFileTypeRepository;
import org.restWebService.RLibrary.util.Constantes;
import org.restWebService.RLibrary.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookFileTypeService {
	
	@Autowired
	private BookFileTypeRepository bookFileTypeRepository;

	@Resource
	private BookFileTypeConverter bookFileTypeConverter;
	
	@PostConstruct
	public void inicialice(){
		String autoUpdate = Util.getProperties("application.properties").getProperty("spring.jpa.hibernate.ddl-auto");
		if(autoUpdate!=null && autoUpdate.equals(Constantes.S_UPDATE)){
			bookFileTypeRepository.deleteAll();
			List<BookFileType> listBookFileType = new ArrayList<>();
			listBookFileType.add( new BookFileType("epub"));
			listBookFileType.add( new BookFileType("movi"));
			listBookFileType.add( new BookFileType("pdf"));
			bookFileTypeRepository.save(listBookFileType);
			System.out.println("Se han creado los distintos tipos de formatos de fillero");
		}
	}
	
}
