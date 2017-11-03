package org.restWebService.RLibrary.converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.restWebService.RLibrary.domain.Book;
import org.restWebService.RLibrary.domain.BookUserReaded;
import org.restWebService.RLibrary.domain.RUser;
import org.restWebService.RLibrary.dto.BookDto;
import org.restWebService.RLibrary.dto.BookUserReadedDto;
import org.restWebService.RLibrary.dto.RUserDto;
import org.springframework.stereotype.Component;

@Component
public class BookUserReadedConverter {
	
	@Resource
	private RUserConverter rUserConverter;
	
	@Resource
	private BookConverter bookConverter;
	
	public BookUserReaded convertDtoToEntity(BookUserReadedDto dto){
		BookUserReaded entity = new BookUserReaded();
		if(dto!=null){
			entity.setId(dto.getId());
			entity.setVersion(dto.getVersion());
			if(dto.getRUserDto()!=null){
				RUser rUser = rUserConverter.convertDtoToEntity(dto.getRUserDto());
				entity.setRUser(rUser);
			}
			if(dto.getBookDto()!=null){
				Book book = bookConverter.convertDtoToEntity(dto.getBookDto());
				entity.setBook(book);
			}
			entity.setScore(dto.getScore());
		}
		return entity;
	}
	
	public BookUserReadedDto convertEntityToDto(BookUserReaded entity){
		BookUserReadedDto dto = new BookUserReadedDto();
		if(entity!=null){
			dto.setId(entity.getId());
			dto.setVersion(entity.getVersion());
			if(entity.getRUser()!=null){
				RUserDto rUserDto = rUserConverter.convertEntityToDto(entity.getRUser());
				dto.setRUserDto(rUserDto);
			}
			if(entity.getBook()!=null){
				BookDto bookDto = bookConverter.convertEntityToDto(entity.getBook());
				dto.setBookDto(bookDto);
			}
			dto.setScore(entity.getScore());
		}
		return dto;
	}
	
	public List<BookUserReaded> convertListDtoToListEntity(List<BookUserReadedDto> dtos){
		List<BookUserReaded> entities = new ArrayList<>();
		if(dtos!=null){
			for(BookUserReadedDto dto: dtos){
				BookUserReaded entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	public List<BookUserReadedDto> convertListEntityToListDto(List<BookUserReaded> entities){
		List<BookUserReadedDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(BookUserReaded entity: entities){
				BookUserReadedDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
}
