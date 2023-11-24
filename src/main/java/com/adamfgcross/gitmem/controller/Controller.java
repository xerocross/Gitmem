package com.adamfgcross.gitmem.controller;

import com.adamfgcross.gitmem.model.NoteDataSummary;

public interface Controller {
	
	public NoteAddResponse addNote();
	public NoteDataSummary getNoteDataSummary();
	public NotesDueSummary getNotesDue();

}