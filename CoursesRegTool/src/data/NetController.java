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

import data.message.Message;

/**
 * @author Avi Digmi
 *
 */
public class NetController {

	private URL bguUrl;
	private HttpURLConnection bguUrlConnection;
	private OutputStream outputStream;
	private BufferedReader inBuff;
	private String cookieName = "";
	private String cookieValue = "";

	public NetController(){
		
		setBguUrl(null);
		setBguUrlConnection(null);
		setOutputStream(null);
		setInBuff(null);
	}
	
	public String connectSendAndReceiveMessage(String subFolder, Message message) throws IOException{
		return connectSendAndReceiveMessage(subFolder,message.getMessage());
	}

	//	TODO:	{HTTP}	Persistent \ Non-Persistent ??..
	
	public String connectSendAndReceiveMessage(String subFolder, String message) throws IOException{
		
		setBguUrl(new URL("http","bgu4u.bgu.ac.il",subFolder));

		setBguUrlConnection((HttpURLConnection)getBguUrl().openConnection());

		setDoInput(true);
		setDoOutput(true);

		//	TODO: add cookies:
		setCookieInRequest();
		
		connect();
		
		setOutputStream(getBguUrlConnection().getOutputStream());

		sendMessage(message);

		setInBuff(new BufferedReader( new InputStreamReader( getBguUrlConnection().getInputStream())));

		String respone = receiveMessage();
		
		//	TODO: get cookies:
		retrieveCookieFromResponse();
		
		disconnect();
		
		return respone;
	}
	
	//	TODO:	{Cookies}	http://www.hccp.org/java-net-cookie-how-to.html
	
	private void retrieveCookieFromResponse(){

		if (cookieName.equals("")){
			
			String headerName=null;
			
			for (int i=1; (headerName = getBguUrlConnection().getHeaderFieldKey(i))!=null; i++) {
	
				if (headerName.equals("Set-Cookie")) {                  
				
					String cookie = getBguUrlConnection().getHeaderField(i);
					
					if (cookie.indexOf(";") >= 0 )
						cookie = cookie.substring(0, cookie.indexOf(";"));
					
					String[] splitted = cookie.split("=");
					
					cookieName = splitted[0];
					cookieValue = splitted[1];
				}
			}
		}
	}
	
	private void setCookieInRequest(){
		
		if (!cookieName.equals(""))
			getBguUrlConnection().setRequestProperty("Cookie",
					cookieName + "=" + cookieValue);
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
