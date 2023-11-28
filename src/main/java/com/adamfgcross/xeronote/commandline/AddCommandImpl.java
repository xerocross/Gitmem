package com.adamfgcross.xeronote.commandline;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import com.adamfgcross.xeronote.controller.XeronoteController;
import com.adamfgcross.xeronote.core.NoteAddResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@CommandLine.Command(name="add", mixinStandardHelpOptions = true)
public class AddCommandImpl implements AddCommand {
	private XeronoteController xeronoteController;
	
	@Value("${com.adamfgcross.xeronote.commandline.addcommand.initmessage}")
	private String addCommandInitMessage;
	
	public AddCommandImpl(XeronoteController xeronoteController) {
		this.xeronoteController = xeronoteController;
	}
	
	@Parameters(index="0", arity="1..*", description="files to be added to the system, as file path strings")
	private String[] noteFilePaths;
	
	public void run() {
		System.out.println(addCommandInitMessage + " : " + String.join(", ", noteFilePaths));
		NoteAddResponse response = xeronoteController.addNotes(new ArrayList<String>(Arrays.asList(noteFilePaths)));
		System.out.println(response.toString());
	}
}
