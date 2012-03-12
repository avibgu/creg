package presentation.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.Controller;

public class Cli {

	private Controller _controller;
	private BufferedReader _br;

	public Cli(Controller controller) {
		
		super();
		set_controller(controller);
		set_br(new BufferedReader(new InputStreamReader(System.in)));
	}

	public void runCli() throws IOException{
		
		//	get information about the user
		System.out.print("Enter username: ");
		String username = get_br().readLine();
		String password = retrievePassword();
		System.out.print("Enter id: ");
		String id = get_br().readLine();

		get_controller().set_userInfo(username, password, id);

		while(true){

			System.out.print("Enter department ('700' - the first part of the course number): ");
			String department = get_br().readLine();
			System.out.print("Enter level ('1' - the second part of the course number): ");
			String level = get_br().readLine();
			System.out.print("Enter course ('0212 - the third part of the course number'): ");
			String course = get_br().readLine();
			System.out.print("Enter Group number: ");
			String group = get_br().readLine();
			System.out.print("Enter Tirgul group number: ");
			String tirgul = get_br().readLine();

			System.out.println(tirgul.isEmpty());
			
			get_controller().addCourse(department, level, course, group, tirgul);

			//	another course?
			System.out.print("Press y to enter another course: ");

			if (0 == get_br().readLine().compareTo("y")) continue;

			break;
		}
		
		System.out.println("\n==========================================================================\n");
		
		//	wait until the user will approve the sending
		System.out.println("Press Enter to start the registration");
		get_br().readLine();
		
		//	tell the controller to start
		// TODO:	get_controller().startTheRegistrationUsingThreads();
		// GOOD:	get_controller().startTheRegistration();
		// TODO:	get_controller().startTheRegistrationExperimental();
		// TODO:	get_controller().registerForever();
		get_controller().registerForeverExperimental();
	}

	protected String retrievePassword() throws IOException {
		System.out.print("Enter password: ");
		String password = get_br().readLine();
		return password;
	}
	
	public Controller get_controller() {
		return _controller;
	}

	public void set_controller(Controller _controller) {
		this._controller = _controller;
	}

	public BufferedReader get_br() {
		return _br;
	}

	public void set_br(BufferedReader _br) {
		this._br = _br;
	}
}
