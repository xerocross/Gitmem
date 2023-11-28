package com.adamfgcross.xeronote.core;

import org.springframework.stereotype.Component;
import com.adamfgcross.xeronote.model.NoteImpl;
import java.nio.file.Path;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class XeronoteCoreImpl implements XeronoteCore {
	private static final Logger logger = LoggerFactory.getLogger(XeronoteCoreImpl.class);
	private NoteService<NoteImpl> noteService;
	private NoteReader<NoteImpl> noteReader;
	
	public XeronoteCoreImpl (NoteReader<NoteImpl> noteReader) {
		this.noteReader = noteReader;
	}
	
	public void addNoteFromFile(String fileAddress) throws XeronoteException {
		Path filePath = Path.of(fileAddress);
		try {
			NoteImpl newNote = noteReader.createNote(filePath);
			noteService.addNote(newNote);
		}
		catch (IOException ex) {
			logger.error("An IOException occurred while trying to add note from file.");
			throw new XeronoteException();
		}
	}
}
