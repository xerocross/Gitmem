package com.adamfgcross.xeronote.core;

import org.springframework.stereotype.Service;
import com.adamfgcross.xeronote.model.NotesRepository;
import com.adamfgcross.xeronote.model.NoteImpl;
import java.util.List;

@Service
public class NotesServiceImpl implements NoteService<NoteImpl> {
	private NotesRepository notesRepository;
	
	public NotesServiceImpl(NotesRepository notesRepository) {
		this.notesRepository = notesRepository;
	}
	
	@Override
	public List<NoteImpl> getNotes() {
		return notesRepository.findAll();
	}
	
	@Override
	public void addNote(NoteImpl newNote) {
		NoteImpl noteImpl = (NoteImpl) newNote;
		notesRepository.save(noteImpl);
	}
	
	@Override
	public void addAllNotes(List<NoteImpl> notes) {
		notesRepository.saveAll(notes);
	}
}
