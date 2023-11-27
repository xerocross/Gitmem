package com.adamfgcross.xeronote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.adamfgcross.xeronote.model")
public class XeronoteApplication {
	public static void main(String[] args) {
		SpringApplication.run(XeronoteApplication.class, args);
	}
}
