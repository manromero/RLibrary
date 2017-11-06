package org.restWebService.RLibrary.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BookFile extends DomainEntity {
	
	private byte[] file;
	@ManyToOne
	private Book book;
	
	public BookFile(){
		super();
	}
	
	public BookFile(byte[] file, Book book){
		this.file = file;
		this.book = book;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}