package org.restWebService.RLibrary.dto;

public class BookFileTypeDto extends Dto {

private String description;
	
	public BookFileTypeDto(){
		super();
	}
	
	public BookFileTypeDto(String description){
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
