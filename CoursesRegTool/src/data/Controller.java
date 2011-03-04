/**
 * 
 */
package data;

import java.io.IOException;
import java.util.Vector;

import main.RegThread;

import data.info.CourseInfo;
import data.info.UserInfo;
import data.message.LoginMessage;

/**
 * @author Avi Digmi
 *
 */
public class Controller {
	
	private NetController netController;

	private UserInfo _userInfo;
	private Vector<CourseInfo> _coursesInfo;
	
	private LoginMessage _loginMsg;

	public Controller() {
		
		super();
		
		setNetController(new NetController());
		
		//	prepare a class to hold the user information
		set_userInfo(new UserInfo());
		
		//	prepare a vector to hold the courses information
		set_coursesInfo(new Vector<CourseInfo>());
		
		//	prepare a default login message
		set_loginMsg(new LoginMessage());
	}
	
	public void startTheRegistration() {
		
		set_loginMsg(new LoginMessage(get_userInfo().getUsername(),
				get_userInfo().getPassword(), get_userInfo().getId()));
		
		String rc_rowid;
		
		while(true){
			
			try {
				
				rc_rowid = getNetController().connectSendAndReceiveMessage("/pls/scwp/!fw.checkId", get_loginMsg());
				break;
			}
			catch (IOException e) { e.printStackTrace(); }
		}
		
		get_userInfo().setRc_rowid(rc_rowid);
		
		//	generate and execute a registration thread for each course
		for (CourseInfo cInfo: _coursesInfo)
			new Thread(new RegThread(cInfo,get_userInfo()));
	}

	public UserInfo get_userInfo() {
		return _userInfo;
	}

	public void set_userInfo(UserInfo _userInfo) {
		this._userInfo = _userInfo;
	}

	public Vector<CourseInfo> get_coursesInfo() {
		return _coursesInfo;
	}

	public void set_coursesInfo(Vector<CourseInfo> _coursesInfo) {
		this._coursesInfo = _coursesInfo;
	}
	
	public void addCourse(CourseInfo courseInfo){
		this._coursesInfo.add(courseInfo);
	}

	public void set_userInfo(String username, String password, String id) {
		set_userInfo( new UserInfo(username, password, id) );
	}

	public void addCourse(String department, String level, String course, String group) {
		addCourse(new CourseInfo(department, level, course, group));
	}

	public void set_loginMsg(LoginMessage _loginMsg) {
		this._loginMsg = _loginMsg;
	}

	public LoginMessage get_loginMsg() {
		return _loginMsg;
	}

	public void setNetController(NetController netController) {
		this.netController = netController;
	}

	public NetController getNetController() {
		return netController;
	}
}
