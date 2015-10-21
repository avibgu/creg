package main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import presentation.cli.Cli;

import data.Controller;


/**
 * @author Avi Digmi
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SecurityException, IOException {

		//	create the logger
		makeLogger("RegLogger");
		
		//	create the Controller
		Controller controller = new Controller();
		
		//	start the cli dialog..
		new Cli(controller).runCli();
	}

	/**
	 * 
	 * @param loggerName
	 * @throws SecurityException
	 * @throws IOException
	 */
	private static void makeLogger(String loggerName)
		throws SecurityException, IOException {

		//	creating logger called loggerName 
		Logger logger = Logger.getLogger(loggerName);

		//	creating log file
		Handler logFileHandler = new FileHandler(loggerName + ".log");
		
		//	setting the log format to be a simple one
		logFileHandler.setFormatter(new VerySimpleLogFormatter());

		//	logger output is written to a file in logFileHandler handler - loggerName.log
		logger.addHandler(logFileHandler);

		//	Set the log level specifying which message levels will be logged by this logger
		logger.setLevel(Level.INFO);
	}
}
