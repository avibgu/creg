/**
 * 
 */
package data.info;

/**
 * @author Avi Digmi
 *
 */
public class UserInfo {

	private String _username;
	private String _password;
	private String _id;
	private String _rc_rowid;
	
	/**
	 * @param username
	 * @param password
	 * @param id like 0393..
	 * @param rc_rowid which we gets from the server
	 */
	public UserInfo(String username, String password, String id, String rc_rowid) {
		
		super();
		this._username = username;
		this._password = password;
		this._id = id;
		this._rc_rowid = rc_rowid;
	}

	/**
	 * 
	 */
	public UserInfo() {
		super();
	}

	public UserInfo(String username, String password, String id) {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		this._username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getRc_rowid() {
		return _rc_rowid;
	}

	public void setRc_rowid(String rc_rowid) {
		this._rc_rowid = rc_rowid;
	}
}
