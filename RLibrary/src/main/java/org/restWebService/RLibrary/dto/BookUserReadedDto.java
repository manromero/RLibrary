package org.restWebService.RLibrary.dto;

public class BookUserReadedDto extends Dto {
	
	private RUserDto rUserDto;
	private BookDto bookDto;
	private Integer score;
	
	public BookUserReadedDto() {
		super();
	}

	public BookUserReadedDto(RUserDto rUserDto, BookDto bookDto, Integer score) {
		super();
		this.rUserDto = rUserDto;
		this.bookDto = bookDto;
		this.score = score;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
