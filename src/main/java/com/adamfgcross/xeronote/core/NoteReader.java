package com.adamfgcross.xeronote.core;

import java.io.IOException;
import java.nio.file.Path;

import com.adamfgcross.xeronote.model.Note;

public interface NoteReader<T extends Note> {
	public T createNote(Path filePath) throws IOException, XeronoteException;
}
