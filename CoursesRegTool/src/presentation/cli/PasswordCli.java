package presentation.cli;

import java.io.Console;

import data.Controller;

public class PasswordCli extends Cli {

	public PasswordCli(Controller controller) {
		super(controller);
	}

	protected String retrievePassword(){
		
		Console c = System.console();
        
		if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        char [] password = c.readPassword("Enter password: ");
		
        System.err.println(password);
        
        return password.toString();
	}
}
