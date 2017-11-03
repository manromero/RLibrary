package org.restWebService.RLibrary.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BookFile extends DomainEntity {
	
	private byte[] file;
	@ManyToOne
	private BookFileType bookFileType;
	
	public BookFile(){
		super();
	}
	
	public BookFile(byte[] file, BookFileType bookFileType){
		this.file = file;
		this.bookFileType = bookFileType;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public BookFileType getBookFileType() {
		return bookFileType;
	}

	public void setBookFileType(BookFileType bookFileType) {
		this.bookFileType = bookFileType;
	}
	
}