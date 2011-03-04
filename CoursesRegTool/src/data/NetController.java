package data;

/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Avi Digmi
 *
 */
public class NetController {

	private URL bguUrl;
	private HttpURLConnection bguUrlConnection;
	private OutputStream outputStream;
	private BufferedReader inBuff;

	public NetController() throws IOException {
		
		setBguUrl(null);
		setBguUrlConnection(null);
		setOutputStream(null);
		setInBuff(null);
	}

	public String connectSendAndReceiveMessage(String subFolder, String message) throws IOException{
		
		setBguUrl(new URL("http","bgu4u.bgu.ac.il",subFolder));

		setBguUrlConnection((HttpURLConnection)getBguUrl().openConnection());

		setDoInput(true);
		setDoOutput(true);

		connect();
		
		setOutputStream(getBguUrlConnection().getOutputStream());

		sendMessage(message);

		setInBuff(new BufferedReader( new InputStreamReader( getBguUrlConnection().getInputStream())));

		String respone = receiveMessage();

		disconnect();

		return respone;
	}
	
	private void setDoOutput(boolean b) {
		getBguUrlConnection().setDoOutput(b);
	}

	private void setDoInput(boolean b) {
		getBguUrlConnection().setDoInput(b);
	}

	private void connect() throws IOException {
		getBguUrlConnection().connect();		
	}

	private void sendMessage(String message) throws IOException{

		getOutputStream().write(message.getBytes());
	}

	private String receiveMessage() throws IOException{

		String inputLine = "";
		String respone = "";

		while ((inputLine = inBuff.readLine()) != null) respone += inputLine;
		
		return respone;
	}
	
	private void disconnect() throws IOException {
		getBguUrlConnection().disconnect();		
	}

	public void setBguUrl(URL bguUrl) {
		this.bguUrl = bguUrl;
	}

	public URL getBguUrl() {
		return bguUrl;
	}

	public void setBguUrlConnection(HttpURLConnection bguUrlConnection) {
		this.bguUrlConnection = bguUrlConnection;
	}

	public HttpURLConnection getBguUrlConnection() {
		return bguUrlConnection;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}
	
	public BufferedReader getInBuff() {
		return inBuff;
	}

	public void setInBuff(BufferedReader inBuff) {
		this.inBuff = inBuff;
	}
}
