package org.restWebService.RLibrary.converter;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.RLibrary.domain.BookFileType;
import org.restWebService.RLibrary.dto.BookFileTypeDto;
import org.springframework.stereotype.Component;

@Component
public class BookFileTypeConverter {
	
	public BookFileType convertDtoToEntity(BookFileTypeDto dto){
		BookFileType entity = new BookFileType();
		if(dto!=null){
			entity.setId(dto.getId());
			entity.setVersion(dto.getVersion());
			entity.setDescription(dto.getDescription());
		}
		return entity;
	}
	
	public BookFileTypeDto convertEntityToDto(BookFileType entity){
		BookFileTypeDto dto = new BookFileTypeDto();
		if(entity!=null){
			dto.setId(entity.getId());
			dto.setVersion(entity.getVersion());
			dto.setDescription(entity.getDescription());
		}
		return dto;
	}
	
	public List<BookFileType> convertListDtoToListEntity(List<BookFileTypeDto> dtos){
		List<BookFileType> entities = new ArrayList<>();
		if(dtos!=null){
			for(BookFileTypeDto dto: dtos){
				BookFileType entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	public List<BookFileTypeDto> convertListEntityToListDto(List<BookFileType> entities){
		List<BookFileTypeDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(BookFileType entity: entities){
				BookFileTypeDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
