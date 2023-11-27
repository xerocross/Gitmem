package com.adamfgcross.xeronote.commandline;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import com.adamfgcross.xeronote.controller.XeronoteController;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;

@Component("addCommand")
@CommandLine.Command(name="add", mixinStandardHelpOptions = true)
public class AddCommandImpl implements AddCommand {
	private XeronoteController xeronoteController;
	
	public AddCommandImpl(XeronoteController xeronoteController) {
		this.xeronoteController = xeronoteController;
	}
	
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) {
//		this.applicationContext = applicationContext;
//		System.out.println("ApplicationContext set: " + this.applicationContext);
//	}
//	
	@Parameters(index="0", arity="1..*", description="files to be added to the system, as file path strings")
	private String[] noteFilePaths;
	
	public void run() {
		System.out.println("AddCommand: files to add: " + String.join(", ", noteFilePaths));
		xeronoteController.addNotes(new ArrayList<String>(Arrays.asList(noteFilePaths)));
	}
}
