package com.adamfgcross.xeronote.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteLinkRepository extends JpaRepository<NoteLinkImpl, Long> {

}
