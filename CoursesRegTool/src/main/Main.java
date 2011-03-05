package main;

import java.io.IOException;

import presentation.cli.Cli;

import data.Controller;

/**
 * 
 */

/**
 * @author Avi Digmi
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//	create the Controller
		Controller controller = new Controller();
		
		//	start the cli dialog..
		new Cli(controller).runCli();
	}
}
