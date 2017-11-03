package org.restWebService.RLibrary.repository;

import javax.transaction.Transactional;

import org.restWebService.RLibrary.domain.RUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface RUserRepository extends JpaRepository<RUser, Long> {

}
