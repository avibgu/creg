/**
 * 
 */
package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import data.message.Message;

/**
 * @author Avi Digmi
 *
 */
public class NetController {

	private URL bguUrl;
	private URLConnection bguUrlConnection;
	private BufferedReader inBuff;
	private OutputStreamWriter outStrWriter;
	
	public NetController() throws IOException {
		
		setBguUrl(new URL("http://bgu4u.bgu.ac.il"));
		setBguUrlConnection(openConnection());
		setDoOutput(true);
		
		setOutStrWriter(new OutputStreamWriter(getBguUrlConnection().getOutputStream()));
		
		setInBuff(new BufferedReader( new InputStreamReader( getBguUrlConnection().getInputStream())));
	}
	
	public NetController(String subFolder) throws IOException {
		
		setBguUrl(new URL("http", "bgu4u.bgu.ac.il", subFolder));
		setBguUrlConnection(openConnection());
		setDoOutput(true);
		
		setOutStrWriter(new OutputStreamWriter(getBguUrlConnection().getOutputStream()));
		
		setInBuff(new BufferedReader( new InputStreamReader( getBguUrlConnection().getInputStream())));
	}
	
	public void changeURLSubFolder(String subFolder) throws IOException{
		
		closeConnection();
		
		setBguUrl(new URL("http", "bgu4u.bgu.ac.il", subFolder));
		setBguUrlConnection(openConnection());
		setDoOutput(true);
		
		setOutStrWriter(new OutputStreamWriter(getBguUrlConnection().getOutputStream()));
		
		setInBuff(new BufferedReader( new InputStreamReader( getBguUrlConnection().getInputStream())));
	}

	public void sendMessage(Message msg) throws IOException{

		getOutStrWriter().write(msg.getMessage());
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
	
	public void closeConnection() throws IOException{
		
		getInBuff().close();
		getOutStrWriter().close();
	}

	public void setBguUrl(URL bguUrl) {
		this.bguUrl = bguUrl;
	}

	public URL getBguUrl() {
		return bguUrl;
	}
	
	public URLConnection openConnection() throws IOException {
		return getBguUrl().openConnection();
	}
	
	private void setDoOutput(boolean b) {
		getBguUrlConnection().setDoOutput(b);
	}

	public void setInBuff(BufferedReader inBuff) {
		this.inBuff = inBuff;
	}

	public BufferedReader getInBuff() {
		return inBuff;
	}

	public void setBguUrlConnection(URLConnection bguUrlConnection) {
		this.bguUrlConnection = bguUrlConnection;
	}

	public URLConnection getBguUrlConnection() {
		return bguUrlConnection;
	}

	public void setOutStrWriter(OutputStreamWriter outStrWriter) {
		this.outStrWriter = outStrWriter;
	}

	public OutputStreamWriter getOutStrWriter() {
		return outStrWriter;
	}
}
