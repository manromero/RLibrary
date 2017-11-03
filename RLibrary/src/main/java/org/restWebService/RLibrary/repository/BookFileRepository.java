package org.restWebService.RLibrary.repository;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.BookFile;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BookFileRepository extends JpaRepository<BookFile, Long> {

}
