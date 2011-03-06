/**
 * 
 */
package main;

import java.io.IOException;

import data.Counter;
import data.NetController;
import data.info.CourseInfo;
import data.info.RegInfo;
import data.info.UserInfo;
import data.message.AddCourseMessage;

/**
 * @author Avi Digmi
 *
 */
public class RegThread implements Runnable {

	private NetController _netController;
	
	private CourseInfo _courseInfo;
	private UserInfo _userInfo;
	private RegInfo _regInfo;
	
	private Counter _counter;
	
	private AddCourseMessage _addCourseMessage;

	public RegThread(CourseInfo cInfo, UserInfo uInfo, RegInfo regInfo, Counter counter) {

		super();
		setNetController(new NetController());
		set_courseInfo(cInfo);
		set_userInfo(uInfo);
		set_regInfo(regInfo);
		set_counter(counter);
		
		//	TODO:	what is course type??...
		
		set_addCourseMessage(new AddCourseMessage(get_regInfo().get_rn_year(), get_regInfo().get_rn_semester(),
				get_courseInfo().get_department(), get_courseInfo().get_level(), get_courseInfo().get_course(),
				get_userInfo().getRc_rowid(), "7", get_courseInfo().get_group()));
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		//	register loop until the registration succeed
		while(true){
				
			//	TODO:	(maybe searchCourse here..)

			try {
				
				//	addCourse packet..
				String answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!sc.AddCourse", get_addCourseMessage());
				
				System.out.println("==============================");
				System.out.println(answer);
				
				break;
			}
			catch (IOException e) {	e.printStackTrace(); }
		}
		
		get_counter().decrease();
	}

	public void setNetController(NetController netController) {
		this._netController = netController;
	}

	public NetController getNetController() {
		return _netController;
	}
	
	public CourseInfo get_courseInfo() {
		return _courseInfo;
	}

	public void set_courseInfo(CourseInfo _courseInfo) {
		this._courseInfo = _courseInfo;
	}

	public UserInfo get_userInfo() {
		return _userInfo;
	}

	public void set_userInfo(UserInfo _userInfo) {
		this._userInfo = _userInfo;
	}

	public void set_regInfo(RegInfo _regInfo) {
		this._regInfo = _regInfo;
	}

	public RegInfo get_regInfo() {
		return _regInfo;
	}

	public void set_counter(Counter _counter) {
		this._counter = _counter;
	}

	public Counter get_counter() {
		return _counter;
	}

	public void set_addCourseMessage(AddCourseMessage _addCourseMessage) {
		this._addCourseMessage = _addCourseMessage;
	}

	public AddCourseMessage get_addCourseMessage() {
		return _addCourseMessage;
	}
}
