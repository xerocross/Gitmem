package com.adamfgcross.xeronote.core;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Path;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class HashReaderImpl implements HashReader {
	private static final Logger logger = LoggerFactory.getLogger(HashReaderImpl.class);
	
	private String hashAlgorithm;
	
	public HashReaderImpl(@Value("${fileHashAlgorithm}") String hashAlgorithm) {
		this.hashAlgorithm = hashAlgorithm;
	}
	
	@Override
	public String getHash(Path filePath) throws FileHashingException, IOException {
		try {
			MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
			try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
	            byte[] buffer = new byte[8192];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                md.update(buffer, 0, bytesRead);
	            }
	        }
			// Convert the byte array to a hexadecimal string
	        byte[] digest = md.digest();
	        StringBuilder checksum = new StringBuilder();
	        for (byte b : digest) {
	            checksum.append(String.format("%02x", b));
	        }

	        return checksum.toString();
			
		} catch (NoSuchAlgorithmException ex) {
			logger.error("Encountered a NoSuchAlgorithmException on fileHashAlgorithm={}", hashAlgorithm);
			throw new FileHashingException();
		} catch (IOException ex) {
			throw ex;
		}
	}
}
