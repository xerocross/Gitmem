package com.adamfgcross.xeronote.commandline;

import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Component
@Command(name = "", subcommands = {AddCommandImpl.class, NotesCommandImpl.class})
public class TopCommandImpl implements TopCommand {

	@Override
	public void run(String... args) {
	}
}
