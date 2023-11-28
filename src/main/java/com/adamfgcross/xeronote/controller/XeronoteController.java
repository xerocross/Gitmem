package com.adamfgcross.xeronote.controller;

import java.util.List;

import com.adamfgcross.xeronote.core.NoteAddResponse;
import com.adamfgcross.xeronote.model.NoteDataSummary;

public interface XeronoteController {
	
	public NoteDataSummary getNoteDataSummary();
	public NotesDueSummary getNotesDue();
	public NoteAddResponse addNotes(List<String> filePaths);

}