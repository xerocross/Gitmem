package com.adamfgcross.xeronote.core;

import com.adamfgcross.xeronote.model.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class NoteAddResponseImpl implements NoteAddResponse {

	public static class NoteAddErrorImpl implements NoteAddResponse.NoteAddError {
		private String filePath;
		private List<Exception> exceptions = new ArrayList<>();
		public NoteAddErrorImpl(String filePath) {
			this.filePath = filePath;
		}
		public NoteAddErrorImpl(String filePath, List<Exception> exceptions) {
			this.filePath = filePath;
			this.exceptions = exceptions;
		}
		@Override
		public String getFilePath() {
			return filePath;
		}
		
		public List<Exception> getExceptions() {
			return this.exceptions;
		}
	}
	
	private List<String> filePathsAttemptedToAdd;
	private List<Note> notesSuccessfullyAdded;
	private List<NoteAddError> noteAddErrors;
	private String attemptMessage;
	private String successMessage;
	private String errorMessage;
	
	public NoteAddResponseImpl(
			String attemptMessage,
			String successMessage,
			String errorMessage,
			List<String> filePathsAttemptedToAdd, 
			List<Note> notesSuccessfullyAdded, 
			List<NoteAddError> noteAddErrors) {
		this.attemptMessage = attemptMessage;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.filePathsAttemptedToAdd = filePathsAttemptedToAdd;
		this.notesSuccessfullyAdded = notesSuccessfullyAdded;
		this.noteAddErrors = noteAddErrors;
	}
	
	public String toString() {
		String r = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		sb.append(attemptMessage + r);
		if (!notesSuccessfullyAdded.isEmpty()) {
			sb.append(r);
			sb.append(successMessage + ":" + r);
			List<String> successFileNames = notesSuccessfullyAdded.stream()
				.map(n -> "* " + n.getNotePath() + " : " + n.getHash())
				.collect(Collectors.toList());
			sb.append(String.join(r, successFileNames.toArray(new String[0])));
		}
		if (!noteAddErrors.isEmpty()) {
			sb.append(r);
			sb.append(errorMessage + ":" + r);
			List<String> failures = noteAddErrors.stream()
					.map(e -> ("* " + e.getFilePath()))
					.collect(Collectors.toList());
			sb.append(String.join(r, failures.toArray(new String[0])));
		}
		return sb.toString();
	}
}