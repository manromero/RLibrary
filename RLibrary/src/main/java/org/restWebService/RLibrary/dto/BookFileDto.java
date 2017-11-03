package org.restWebService.RLibrary.dto;

public class BookFileDto extends Dto {
	
	private byte[] file;
	private BookFileTypeDto bookFileTypeDto;
	
	public BookFileDto(){
		super();
	}
	
	public BookFileDto(byte[] file, BookFileTypeDto bookFileTypeDto){
		this.file = file;
		this.bookFileTypeDto = bookFileTypeDto;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public BookFileTypeDto getBookFileTypeDto() {
		return bookFileTypeDto;
	}

	public void setBookFileTypeDto(BookFileTypeDto bookFileTypeDto) {
		this.bookFileTypeDto = bookFileTypeDto;
	}

}