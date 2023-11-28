package com.adamfgcross.xeronote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adamfgcross.xeronote.core.*;
import com.adamfgcross.xeronote.model.*;
import com.adamfgcross.xeronote.model.NoteDataSummary;

@Controller
public class XeronoteControllerImpl implements XeronoteController {
	private static final Logger logger = LoggerFactory.getLogger(XeronoteControllerImpl.class);
	private XeronoteCore xeronoteCore;
	
	@Value("${com.adamfgcross.xeronote.controller.addingNotesLogMessage}")
	private String addingNotesLogMessage;
	
	@Value("${com.adamfgcross.xeronote.controller.exceptionLogMessage}")
	private String exceptionLogMessage;
	
	public XeronoteControllerImpl(XeronoteCore xeronoteCore) {
		this.xeronoteCore = xeronoteCore;
	}
	
	public NoteAddResponse addNotes(List<String> filePaths) {
		logger.info(addingNotesLogMessage + " : " + String.join(" ", filePaths.toArray(new String[0])));
		try {
			NoteAddResponse response = xeronoteCore.addNotes(filePaths);
			return response;
		}
		catch (XeronoteException ex) {
			logger.error(exceptionLogMessage + " : " + ex.toString() + ex.getMessage());
		}
		return null;
	}
	public NoteDataSummary getNoteDataSummary() {
		return null;
	}
	public NotesDueSummary getNotesDue() {
		return null;
	}
	
	public List<? extends Note> getAllNotes() {
		return xeronoteCore.getAllNotes();
	}
}
