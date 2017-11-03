package org.restWebService.RLibrary.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

	
	@Query("SELECT b FROM Book b ORDER BY b.title DESC")
	public List<Book> findAllByTitleDesc();

}
