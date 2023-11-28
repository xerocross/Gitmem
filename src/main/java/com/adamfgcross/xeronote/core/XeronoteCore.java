package com.adamfgcross.xeronote.core;

import java.util.List;

public interface XeronoteCore {
	public NoteAddResponse addNotes(List<String> fileAddress) throws XeronoteException;
}
