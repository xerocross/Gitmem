package com.adamfgcross.xeronote.core;

import org.springframework.stereotype.Component;

import com.adamfgcross.xeronote.model.Note;

import java.util.List;

@Component
public class XeronoteCoreImpl implements XeronoteCore {
	
	private List<Note> notes;

}
