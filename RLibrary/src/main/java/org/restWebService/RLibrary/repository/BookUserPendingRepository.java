package org.restWebService.RLibrary.repository;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.BookUserPending;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BookUserPendingRepository extends JpaRepository<BookUserPending, Long> {

}
