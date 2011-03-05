/**
 * 
 */
package main;

import data.NetController;
import data.info.CourseInfo;
import data.info.UserInfo;

/**
 * @author Avi Digmi
 *
 */
public class RegThread implements Runnable {

	private NetController _netController;
	
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
		
		//	register loop until the registration succeed
		
		while(true){
			
			//try {

				//	TODO: addCourse packet.. (and maybe searchCourse before it..)
				
				break;
			//}
			//catch (IOException e) { e.printStackTrace(); }
		}
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
}
