package com.adamfgcross.xeronote.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.adamfgcross.xeronote.model.*;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class XeronoteCoreImpl implements XeronoteCore {
	private static final Logger logger = LoggerFactory.getLogger(XeronoteCoreImpl.class);
	private NoteService<NoteImpl> noteService;
	private NoteReader<NoteImpl> noteReader;
	
	
	@Value("${core.noteaddresponse.successmessage}")
	private String addNoteSuccessMessage;
	
	@Value("${core.noteaddresponse.errormessage}")
	private String addNoteErrorMessage;
	
	@Value("${core.noteaddresponse.attemptmessage}")
	private String addNoteAttemptMessage;
	
	public XeronoteCoreImpl (NoteReader<NoteImpl> noteReader, NoteService<NoteImpl> noteService) {
		this.noteReader = noteReader;
		this.noteService = noteService;
	}
	
	public List<? extends Note> getAllNotes() {
		return noteService.getNotes();
	}
	
	private Note addNoteFromFile(String fileAddress) throws XeronoteException {
		Path filePath = Path.of(fileAddress);
		try {
			NoteImpl newNote = noteReader.createNote(filePath);
			noteService.addNote(newNote);
			return newNote;
		}
		catch (IOException ex) {
			logger.error("An IOException occurred while trying to add note from file: " + fileAddress);
			throw new XeronoteException();
		}
	}
	
	public NoteAddResponse addNotes(List<String> fileAddresses) throws XeronoteException {
		List<NoteAddResponse.NoteAddError> errors = new ArrayList<>();
		List<Note> successList = new ArrayList<>();
		fileAddresses.forEach(address -> {
			try {
				Note newNote = addNoteFromFile(address);
				successList.add(newNote);
			} 
			catch (Exception e) {
				NoteAddResponse.NoteAddError err = new NoteAddResponseImpl.NoteAddErrorImpl(address);
				// add exception
				errors.add(err);
			}
		});
		return new NoteAddResponseImpl(addNoteAttemptMessage, addNoteSuccessMessage, addNoteErrorMessage, fileAddresses, successList, errors);
	}
}
