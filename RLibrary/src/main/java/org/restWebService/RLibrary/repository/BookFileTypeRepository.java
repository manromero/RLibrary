package org.restWebService.RLibrary.repository;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.BookFileType;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BookFileTypeRepository extends JpaRepository<BookFileType, Long> {

}
