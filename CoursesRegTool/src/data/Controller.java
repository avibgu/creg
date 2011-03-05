/**
 * 
 */
package data;

import java.io.IOException;
import java.util.Vector;

import main.RegThread;
import main.StrManip;

import data.info.CourseInfo;
import data.info.UserInfo;
import data.message.AcademicLoginMessage;
import data.message.AddSemesterMessage;
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
	private AcademicLoginMessage _academicLoginMessage;
	private AddSemesterMessage _addSemesterMessage;

	public Controller() {
		
		super();
		
		setNetController(new NetController());
		
		//	prepare a class to hold the user information
		set_userInfo(new UserInfo());
		
		//	prepare a vector to hold the courses information
		set_coursesInfo(new Vector<CourseInfo>());
		
		//	prepare a default login message
		set_loginMsg(new LoginMessage());
		
		//	prepare a default academic login message
		set_academicLoginMessage(new AcademicLoginMessage());
		
		//	prepare a default add semester message
		set_addSemesterMessage(new AddSemesterMessage());
	}
	
	public void startTheRegistration() {
		
		set_loginMsg(new LoginMessage(get_userInfo().getUsername(),
				get_userInfo().getPassword(), get_userInfo().getId()));
		
		String answer;
		String[] splittedAnswer;
		
		while(true){
			
			try {
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!fw.checkId", get_loginMsg());
				
				get_userInfo().setRc_rowid( StrManip.filterOutTheValueOf(answer, "rc_rowid") );
				
				set_academicLoginMessage(new AcademicLoginMessage(get_userInfo().getRc_rowid()));
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!sc.academiclogin", get_academicLoginMessage());
				
				splittedAnswer = StrManip.filterOutParamsForNextMessage(answer, "setFormActionAndSubmitAcLogInNew");
				
				//	TODO:	insert the data to RegInfo..
				
				set_addSemesterMessage(new AddSemesterMessage(splittedAnswer[1], splittedAnswer[3], splittedAnswer[5],
						splittedAnswer[7], splittedAnswer[9], splittedAnswer[11], splittedAnswer[13], splittedAnswer[15],
						splittedAnswer[17]));
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!sc.AddSemester", get_addSemesterMessage());
				
				//	TODO: continue from here.. get relevant info if there is such and save it in RegInfo..
				
				break;
			}
			catch (IOException e) { e.printStackTrace(); }
		}

		//	generate and execute a registration thread for each course
		for (CourseInfo cInfo: _coursesInfo)
			new Thread(new RegThread(cInfo,get_userInfo())).start();
		
		//	TODO:	wait all threads..
		
		//	TODO:	generate leave packet..
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

	public void set_academicLoginMessage(AcademicLoginMessage _academicLoginMessage) {
		this._academicLoginMessage = _academicLoginMessage;
	}

	public AcademicLoginMessage get_academicLoginMessage() {
		return _academicLoginMessage;
	}

	public void set_addSemesterMessage(AddSemesterMessage _addSemesterMessage) {
		this._addSemesterMessage = _addSemesterMessage;
	}

	public AddSemesterMessage get_addSemesterMessage() {
		return _addSemesterMessage;
	}
}
