package com.adamfgcross.xeronote.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteImpl, Long> {

}
