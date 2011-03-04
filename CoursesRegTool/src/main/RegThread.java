/**
 * 
 */
package main;

import java.io.IOException;

import data.NetController;
import data.info.CourseInfo;
import data.info.UserInfo;
import data.message.AcademicLoginMessage;
import data.message.AddSemesterMessage;

/**
 * @author Avi Digmi
 *
 */
public class RegThread implements Runnable {

	private NetController _netController;
	
	private CourseInfo _courseInfo;
	private UserInfo _userInfo;
	
	private AcademicLoginMessage _academicLoginMessage;
	private AddSemesterMessage _addSemesterMessage;

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
		
		String answer;
		String[] splittedAnswer;
		
		while(true){
			
			try {
				
				set_academicLoginMessage(new AcademicLoginMessage(get_userInfo().getRc_rowid()));
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!sc.academiclogin", get_academicLoginMessage());
				
				splittedAnswer = filterOutParamsForNextMessage(answer, "setFormActionAndSubmitAcLogInNew");
				
				set_addSemesterMessage(new AddSemesterMessage(splittedAnswer[1], splittedAnswer[3], splittedAnswer[5],
						splittedAnswer[7], splittedAnswer[9], splittedAnswer[11], splittedAnswer[13], splittedAnswer[15],
						splittedAnswer[17]));
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!sc.AddSemester", get_addSemesterMessage());
				
				//	TODO: continue from here.. generate the next packet..
				
				break;
			}
			catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	private String[] filterOutParamsForNextMessage(String textToFilter, String theFunctionOwnTheParams) {

		String[] splittedText = textToFilter.split(" ");
		
		String relevantString = "";
		
		for(int i=0; i < splittedText.length; i++){

			if( 0 == splittedText[i].compareTo(theFunctionOwnTheParams) ){

				relevantString = splittedText[i];
				break;
			}
		}
		
		int start = relevantString.indexOf("(");
		int end = relevantString.indexOf(")");

		relevantString = relevantString.substring(start+1, end);
		
		splittedText = relevantString.split("\'");
		
		return null;
	}

	public String filterOutTheValueOf(String textToFilter, String whatToFind) {

		String value = "";

		String[] splittedText = textToFilter.split(" ");

		for(int i=0; i < splittedText.length; i++){

			if( 0 == splittedText[i].compareTo("name=" + whatToFind) ){

				value = splittedText[i+1];
				break;
			}
		}

		int start = value.indexOf("\"");
		int end = value.lastIndexOf("\"");

		return value.substring(start+1, end);		
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

	public void set_academicLoginMessage(AcademicLoginMessage _academicLoginMessage) {
		this._academicLoginMessage = _academicLoginMessage;
	}

	public AcademicLoginMessage get_academicLoginMessage() {
		return _academicLoginMessage;
	}

	public AddSemesterMessage get_addSemesterMessage() {
		return _addSemesterMessage;
	}

	public void set_addSemesterMessage(AddSemesterMessage _addAddSemesterMessage) {
		this._addSemesterMessage = _addAddSemesterMessage;
	}
}
