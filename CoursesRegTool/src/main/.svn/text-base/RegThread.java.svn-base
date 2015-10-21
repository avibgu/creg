/**
 * 
 */
package main;

import java.io.IOException;
import java.util.logging.Logger;

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
				get_userInfo().getRc_rowid(), "7", get_courseInfo().get_group(), get_courseInfo().get_tirgul()));
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
				
				Logger.getLogger("RegLogger").info(answer);
				
				break;
			}
			catch (IOException e) {	
				Logger.getLogger("RegLogger").severe(e.getMessage());
			}
		}
		
		//TODO:	get_counter().decrease();
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

	public void set_courseInfo(CourseInfo courseInfo) {
		this._courseInfo = courseInfo;
	}

	public UserInfo get_userInfo() {
		return _userInfo;
	}

	public void set_userInfo(UserInfo userInfo) {
		this._userInfo = userInfo;
	}

	public void set_regInfo(RegInfo regInfo) {
		this._regInfo = regInfo;
	}

	public RegInfo get_regInfo() {
		return _regInfo;
	}

	public void set_counter(Counter counter) {
		this._counter = counter;
	}

	public Counter get_counter() {
		return _counter;
	}

	public void set_addCourseMessage(AddCourseMessage addCourseMessage) {
		this._addCourseMessage = addCourseMessage;
	}

	public AddCourseMessage get_addCourseMessage() {
		return _addCourseMessage;
	}
}
