package com.adamfgcross.xeronote.core;

import java.io.IOException;
import java.nio.file.Path;

public interface HashReader {
	public String getHash(Path filePath) throws FileHashingException, IOException;
}
