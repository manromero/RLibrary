package org.restWebService.RLibrary.converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.restWebService.RLibrary.domain.Book;
import org.restWebService.RLibrary.domain.BookUserPending;
import org.restWebService.RLibrary.domain.RUser;
import org.restWebService.RLibrary.dto.BookDto;
import org.restWebService.RLibrary.dto.BookUserPendingDto;
import org.restWebService.RLibrary.dto.RUserDto;
import org.springframework.stereotype.Component;

@Component
public class BookUserPendingConverter {
	
	@Resource
	private RUserConverter rUserConverter;
	
	@Resource
	private BookConverter bookConverter;
	
	public BookUserPending convertDtoToEntity(BookUserPendingDto dto){
		BookUserPending entity = new BookUserPending();
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
		}
		return entity;
	}
	
	public BookUserPendingDto convertEntityToDto(BookUserPending entity){
		BookUserPendingDto dto = new BookUserPendingDto();
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
		}
		return dto;
	}
	
	public List<BookUserPending> convertListDtoToListEntity(List<BookUserPendingDto> dtos){
		List<BookUserPending> entities = new ArrayList<>();
		if(dtos!=null){
			for(BookUserPendingDto dto: dtos){
				BookUserPending entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	public List<BookUserPendingDto> convertListEntityToListDto(List<BookUserPending> entities){
		List<BookUserPendingDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(BookUserPending entity: entities){
				BookUserPendingDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
}
