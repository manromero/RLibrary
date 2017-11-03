package org.restWebService.RLibrary.repository;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.BookUserReaded;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BookUserReadedRepository extends JpaRepository<BookUserReaded, Long> {

}
