/**
 * 
 */
package data;

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

	private UserInfo _userInfo;
	private Vector<CourseInfo> _coursesInfo;
	
	private String _year;
	private String _semester;
	
	private LoginMessage _loginMsg;

	public Controller() {
		
		super();
		
		//	prepare a class to hold the user information
		set_userInfo(new UserInfo());
		
		//	prepare a vector to hold the courses information
		set_coursesInfo(new Vector<CourseInfo>());
		
		//	prepare a default login message
		set_loginMsg(new LoginMessage());
	}
	
	public void startTheRegistration() {
		
		//	TODO:	get the rc_rowid from the server.
		//			for that, send login message and get the rc_rowid value from the html message
		//			do: new NetController("/html/yeutz/time_windows.php");
		//			and then connect.

		String rc_rowid = "";
		
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

	public void setYear(String year) {
		this._year = year;
	}
	
	public String get_year() {
		return _year;
	}

	public void setSemester(String semester) {
		this._semester = semester;
	}

	public String get_semester() {
		return _semester;
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
}
