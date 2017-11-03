package org.restWebService.RLibrary.dto;

public class BookUserPendingDto extends Dto {
	
	private RUserDto rUserDto;
	private BookDto bookDto;
	
	public BookUserPendingDto(){
		super();
	}
	
	public BookUserPendingDto(RUserDto rUserDto, BookDto bookDto){
		super();
		this.rUserDto = rUserDto;
		this.bookDto = bookDto;
	}

	public RUserDto getRUserDto() {
		return rUserDto;
	}

	public void setRUserDto(RUserDto rUserDto) {
		this.rUserDto = rUserDto;
	}

	public BookDto getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
	}
	
}
