package com.adamfgcross.xeronote.controller;

import com.adamfgcross.xeronote.model.NoteDataSummary;

public interface Controller {
	
	public NoteAddResponse addNote();
	public NoteDataSummary getNoteDataSummary();
	public NotesDueSummary getNotesDue();
	public 

}