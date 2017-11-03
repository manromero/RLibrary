package org.restWebService.RLibrary.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface BookTypeRepository extends JpaRepository<BookType, Long> {

	@Query("SELECT bt FROM BookType bt ORDER BY bt.description")
	public List<BookType> findAllByDescriptionDesc();

}
