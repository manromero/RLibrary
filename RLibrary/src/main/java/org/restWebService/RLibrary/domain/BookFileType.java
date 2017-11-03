package org.restWebService.RLibrary.domain;

import javax.persistence.Entity;

@Entity
public class BookFileType extends DomainEntity {

private String description;
	
	public BookFileType(){
		super();
	}
	
	public BookFileType(String description){
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
