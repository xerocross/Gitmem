package com.adamfgcross.xeronote.core;

import com.adamfgcross.xeronote.model.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class NoteAddResponseImpl implements NoteAddResponse {

	public static class NoteAddError {
		private String filePath;
		private List<Exception> exceptions;
		public NoteAddError(String filePath, List<Exception> exceptions) {
			this.filePath = filePath;
			this.exceptions = exceptions;
		}
		public String getFilePath() {
			return filePath;
		}
		
		public List<Exception> getExceptions() {
			return new ArrayList<Exception>(this.exceptions);
		}
	}
	
	private List<String> filePathsAttemptedToAdd;
	private List<Note> notesSuccessfullyAdded;
	private List<NoteAddError> noteAddErrors;
	
	public NoteAddResponseImpl(List<String> filePathsAttemptedToAdd, 
			List<Note> notesSuccessfullyAdded, 
			List<NoteAddError> noteAddErrors) {
		this.filePathsAttemptedToAdd = filePathsAttemptedToAdd;
		this.notesSuccessfullyAdded = notesSuccessfullyAdded;
		this.noteAddErrors = noteAddErrors;
	}
	
	public String toString() {
		String r = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		sb.append("The following notes added without incident: " + r);
		List<String> successFileNames = notesSuccessfullyAdded.stream()
			.map(n -> n.getNotePath())
			.collect(Collectors.toList());
		sb.append(String.join(" ", successFileNames.toArray(new String[0])) + r);
		sb.append("Encountered error(s) in attempting to add the following notes:");
		List<String> failures = noteAddErrors.stream()
				.map(e -> (e.getFilePath()))
				.collect(Collectors.toList());
		sb.append(String.join(" ", failures.toArray(new String[0])));
		return sb.toString();
	}
}
