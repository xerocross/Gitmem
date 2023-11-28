package com.adamfgcross.xeronote.commandline;

import picocli.CommandLine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.adamfgcross.xeronote.controller.*;
import com.adamfgcross.xeronote.model.Note;

import java.util.List;

@Component
@CommandLine.Command(name="notes", mixinStandardHelpOptions = true)
public class NotesCommandImpl implements NotesCommand {
	
	@Value("${com.adamfgcross.xeronote.commandline.notescommand.initmessage}")
	private String initMessage;
	
	@Value("${com.adamfgcross.xeronote.commandline.notescommand.notesfound}")
	private String notesFoundMessage;
	
	@Value("${com.adamfgcross.xeronote.commandline.tab}")
	private String tab;

	private XeronoteController xeronoteController;
	
	public NotesCommandImpl(XeronoteController xeronoteController) {
		this.xeronoteController = xeronoteController;
	}
	
	
	public void run() {
		System.out.println(initMessage);
		List<? extends Note> notes = xeronoteController.getAllNotes();
		if (!notes.isEmpty()) {
			printNotesList(notes);
		}
	}
	
	private void printNotesList(List<? extends Note> notes) {
		String r = System.lineSeparator();
		String tab = "     ";
		System.out.println(notesFoundMessage);
		notes.stream()
			.forEach(note -> {
				System.out.println(tab + note.getFileName());
			});
	}
}
