package org.restWebService.RLibrary.converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.restWebService.RLibrary.domain.BookFile;
import org.restWebService.RLibrary.domain.BookFileType;
import org.restWebService.RLibrary.dto.BookFileDto;
import org.restWebService.RLibrary.dto.BookFileTypeDto;
import org.springframework.stereotype.Component;

@Component
public class BookFileConverter {
	
	@Resource
	private BookFileTypeConverter bookFileTypeConverter; 
	
	public BookFile convertDtoToEntity(BookFileDto dto){
		BookFile entity = new BookFile();
		if(dto!=null){
			entity.setId(dto.getId());
			entity.setVersion(dto.getVersion());
			entity.setFile(dto.getFile());
			if(dto.getBookFileTypeDto()!=null){
				BookFileType bookFileType = bookFileTypeConverter.convertDtoToEntity(dto.getBookFileTypeDto());
				entity.setBookFileType(bookFileType);
			}
		}
		return entity;
	}
	
	public BookFileDto convertEntityToDto(BookFile entity){
		BookFileDto dto = new BookFileDto();
		if(entity!=null){
			dto.setId(entity.getId());
			dto.setVersion(entity.getVersion());
			dto.setFile(entity.getFile());
			if(entity.getBookFileType()!=null){
				BookFileTypeDto bookFileTypeDto = bookFileTypeConverter.convertEntityToDto(entity.getBookFileType());
				dto.setBookFileTypeDto(bookFileTypeDto);
			}
		}
		return dto;
	}
	
	public List<BookFile> convertListDtoToListEntity(List<BookFileDto> dtos){
		List<BookFile> entities = new ArrayList<>();
		if(dtos!=null){
			for(BookFileDto dto: dtos){
				BookFile entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	public List<BookFileDto> convertListEntityToListDto(List<BookFile> entities){
		List<BookFileDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(BookFile entity: entities){
				BookFileDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
}