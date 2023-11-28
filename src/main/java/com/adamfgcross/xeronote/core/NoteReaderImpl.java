package com.adamfgcross.xeronote.core;

import com.adamfgcross.xeronote.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.io.FileInputStream;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class NoteReaderImpl implements NoteReader<NoteImpl> {
	private static final Logger logger = LoggerFactory.getLogger(NoteReaderImpl.class);
	private HashReader hashReader;
	
	public NoteReaderImpl(HashReader hashReader) {
		this.hashReader = hashReader;
	}

	public NoteImpl createNote(Path filePath) throws IOException, XeronoteException {
//		try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
//			
//		}
		logger.info("Adding file {}", filePath.toString());
		NoteImpl note = new NoteImpl();
		note.setFileName(filePath.getFileName().toString());
		note.setNotePath(filePath.toString());
		note.setHash(hashReader.getHash(filePath));
		logger.info("file hash: {}", note.getHash());
		return note;
	}
}
