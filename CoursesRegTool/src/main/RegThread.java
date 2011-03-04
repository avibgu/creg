/**
 * 
 */
package main;

import java.io.IOException;

import data.NetController;
import data.info.CourseInfo;
import data.info.UserInfo;

/**
 * @author Avi Digmi
 *
 */
public class RegThread implements Runnable {

	private NetController netController;
	
	private CourseInfo _courseInfo;
	private UserInfo _userInfo;

	public RegThread(CourseInfo cInfo, UserInfo uInfo) {

		super();
		setNetController(new NetController());
		set_courseInfo(cInfo);
		set_userInfo(uInfo);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		//	TODO:  get the missing fields - oc_course_consult_msg, _courseType
		
		//	create registration message
		
		//	register loop until the registration succeed
		
		String answer;
		
		while(true){
			
			try {
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!fw.checkId", get_loginMsg());
				break;
			}
			catch (IOException e) { e.printStackTrace(); }
		}
	}

	public void setNetController(NetController netController) {
		this.netController = netController;
	}

	public NetController getNetController() {
		return netController;
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
}
