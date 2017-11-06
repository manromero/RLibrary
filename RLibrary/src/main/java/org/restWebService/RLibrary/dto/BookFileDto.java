package org.restWebService.RLibrary.dto;

public class BookFileDto extends Dto {
	
	private byte[] file;
	private Long idBook;
	
	public BookFileDto(){
		super();
	}
	
	public BookFileDto(byte[] file){
		this.file = file;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

}