/**
 * 
 */
package data.message;

/**
 * @author Avi Digmi
 *
 */
public class LoginMessage implements Message{

	private String _username;
	private String _password;
	private String _id;
	
	public LoginMessage() {}

	/**
	 * @param _username
	 * @param _password
	 * @param _id
	 */
	public LoginMessage(String username, String password, String id) {
		
		super();
		set_username(username);
		set_password(password);
		set_id(id);
	}

	@Override
	public String getMessage() {

		return "oc_username=" + get_username() + "&oc_password=" + get_password() + "&rc_id=" + get_id() + "&rc_system=sc";
	}
	
	public String get_username() {
		return _username;
	}

	public void set_username(String _username) {
		this._username = _username;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
