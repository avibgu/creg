/**
 * 
 */
package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import data.message.Message;

/**
 * @author Avi Digmi
 *
 */
public class NetController {

	private URL bguUrl;
	private BufferedReader inBuff;
	
	public NetController() throws IOException {
		
		setBguUrl(new URL("http://bgu4u.bgu.ac.il"));
		setInBuff(new BufferedReader( new InputStreamReader( getBguUrl().openStream())));
	}

	public void sendMessage(Message msg){
		//	TODO: implement..
	}

	public String receiveMessage() throws IOException{

		String inputLine;
		String message = "";

		while ((inputLine = getInBuff().readLine()) != null){
			
			message += inputLine;
			System.out.println(inputLine);	//	TODO: remove it..
		}

		return message;
	}

	
	public void openConnection() throws IOException {
		getBguUrl().openConnection();
	}

	public void setBguUrl(URL bguUrl) {
		this.bguUrl = bguUrl;
	}

	public URL getBguUrl() {
		return bguUrl;
	}

	public void setInBuff(BufferedReader inBuff) {
		this.inBuff = inBuff;
	}

	public BufferedReader getInBuff() {
		return inBuff;
	}
}
