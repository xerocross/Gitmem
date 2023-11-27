package com.adamfgcross.xeronote.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
public class CommandLineApp implements CommandLineRunner {

    private TopCommand topCommand;
	private IFactory factory;
	
	
	public CommandLineApp(IFactory factory, TopCommand topCommand) {
	    this.factory = factory;
	    this.topCommand = topCommand;
	}
	
	
	@Override
    public void run(String... args) {
		System.out.println("The IFactory is " + factory);
		System.out.println("Executing CommandLineApp run: " + String.join(" ", args));
		CommandLine cmd = new CommandLine(topCommand, factory);
		cmd.execute(args);
    }
}
