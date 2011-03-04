package main;

import java.io.IOException;

import cli.Cli;
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
	
//	public static void main(String[] args) throws IOException{
//		
//		NetController nc = new NetController();
//
//		String respone;
//
//		while(true){
//
//			try {
//				
//				respone = nc.connectSendAndReceiveMessage("/pls/scwp/!fw.checkId", "oc_username=admin&oc_password=Password1&rc_id=123456789&rc_system=sc");
//				System.out.println(respone);
//				System.out.println("=====================================================");
//
//				break;
//			}
//			catch (IOException e) { e.printStackTrace(); }
//		}
//
//		System.out.println( filterOut(respone, "rc_rowid") );
//	}
//
//	private static String filterOut(String textToFilter, String whatToFind) {
//
//		String value = "";
//
//		String[] splittedText = textToFilter.split(" ");
//
//		for(int i=0; i < splittedText.length; i++){
//
//			if( 0 == splittedText[i].compareTo("name=" + whatToFind) ){
//
//				value = splittedText[i+1];
//				break;
//			}
//		}
//
//		int start = value.indexOf("\"");
//		int end = value.lastIndexOf("\"");
//
//		return value.substring(start+1, end);		
//	}
//
//	public static String connect(String subFolder, String message) throws IOException{
//
//		URL url = new URL("http","bgu4u.bgu.ac.il",subFolder);
//
//		HttpURLConnection urlConn= (HttpURLConnection)url.openConnection();
//
//		urlConn.setDoInput(true);
//		urlConn.setDoOutput(true);
//
//		urlConn.connect();
//
//		byte[] msg = message.getBytes();
//
//		urlConn.getOutputStream().write(msg);
//
//		BufferedReader inBuff = new BufferedReader( new InputStreamReader( urlConn.getInputStream()));
//
//		String inputLine = "";
//		String respone = "";
//
//		while ((inputLine = inBuff.readLine()) != null) respone += inputLine;
//
//		urlConn.disconnect();
//
//		return respone;
//	}
}
