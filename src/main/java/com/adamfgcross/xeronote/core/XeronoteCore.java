package com.adamfgcross.xeronote.core;

import java.util.List;

import com.adamfgcross.xeronote.model.Note;

public interface XeronoteCore {
	public NoteAddResponse addNotes(List<String> fileAddress) throws XeronoteException;
	public List<? extends Note> getAllNotes();
}
