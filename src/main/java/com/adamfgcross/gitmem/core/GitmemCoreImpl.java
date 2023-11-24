package com.adamfgcross.gitmem.core;

import org.springframework.stereotype.Component;
import java.util.List;
import com.adamfgcross.gitmem.model.Note;

@Component
public class GitmemCoreImpl implements GitmemCore {
	
	private List<Note> notes;

}
