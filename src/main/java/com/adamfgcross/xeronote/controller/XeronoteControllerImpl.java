package com.adamfgcross.xeronote.controller;

import java.util.List;
import org.springframework.stereotype.Controller;

import com.adamfgcross.xeronote.model.NoteDataSummary;

@Controller
public class XeronoteControllerImpl implements XeronoteController {
	
	public NoteAddResponse addNotes(List<String> filePaths) {
		System.out.println("Controller: Attempting to add notes at the paths:");
		System.out.println(String.join(" ", filePaths.toArray(new String[0])));
		return null;
	}
	public NoteDataSummary getNoteDataSummary() {
		return null;
	}
	public NotesDueSummary getNotesDue() {
		return null;
	}
}
