/**
 * 
 */
package data;

import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import main.RegThread;
import main.StrManip;

import data.info.CourseInfo;
import data.info.RegInfo;
import data.info.UserInfo;
import data.message.AcademicLoginMessage;
import data.message.AddSemesterMessage;
import data.message.ByeMessage;
import data.message.LoginMessage;

/**
 * @author Avi Digmi
 *
 */
public class Controller {
	
	private NetController netController;

	private UserInfo _userInfo;
	private Vector<CourseInfo> _coursesInfo;
	private RegInfo _regInfo;
	
	private LoginMessage _loginMsg;
	private AcademicLoginMessage _academicLoginMessage;
	private AddSemesterMessage _addSemesterMessage;
	private ByeMessage _byeMessage;
	
	private ExecutorService _executor;
	private Counter _counter;

	public Controller() {
		
		super();
		
		setNetController(new NetController());
		
		//	prepare a class to hold the user information
		set_userInfo(new UserInfo());
		
		//	prepare a vector to hold the courses information
		set_coursesInfo(new Vector<CourseInfo>());
		
		//	prepare a class to hold the registration information
		set_regInfo(new RegInfo());
		
		//	prepare a default login message
		set_loginMsg(new LoginMessage());
		
		//	prepare a default academic login message
		set_academicLoginMessage(new AcademicLoginMessage());
		
		//	prepare a default add semester message
		set_addSemesterMessage(new AddSemesterMessage());
		
		//	prepare a default bye message
		set_byeMessage(new ByeMessage());
		
		//	sets the executor to null
		set_executor(null);
		
		//	sets the counter to null
		set_counter(null);
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
				
				System.out.println("==============================");
				System.out.println(answer);

				splittedAnswer = StrManip.filterOutParamsForNextMessage(answer, "setFormActionAndSubmitAcLogInNew");

				get_userInfo().setRc_rowid(splittedAnswer[1]);
				get_regInfo().set_rn_student_degree(splittedAnswer[3]);
				get_regInfo().set_rn_department(splittedAnswer[5]);
				get_regInfo().set_rn_degree_level(splittedAnswer[7]);
				get_regInfo().set_rn_student_path(splittedAnswer[9]);
				get_regInfo().set_rn_year(splittedAnswer[11]);
				get_regInfo().set_rn_semester(splittedAnswer[13]);
				get_regInfo().set_rn_consult_term(splittedAnswer[15]);
				get_regInfo().set_rn_consult_status(splittedAnswer[17]);

				set_addSemesterMessage(new AddSemesterMessage(splittedAnswer[1], splittedAnswer[3], splittedAnswer[5],
						splittedAnswer[7], splittedAnswer[9], splittedAnswer[11], splittedAnswer[13], splittedAnswer[15],
						splittedAnswer[17]));
				
				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!sc.AddSemester", get_addSemesterMessage());
				
				System.out.println("==============================");
				System.out.println(answer);
				
				break;
			}
			catch (IOException e) { e.printStackTrace(); }
		}
		
		set_executor(Executors.newFixedThreadPool(get_coursesInfo().size()));
		
		set_counter(new Counter(get_coursesInfo().size()));

		//	generate and execute a registration thread for each course
		for (CourseInfo cInfo: this._coursesInfo)
			get_executor().execute(new RegThread(cInfo, get_userInfo(), get_regInfo(), get_counter()));
		
		//	wait to all threads
		while(get_counter().get_counter() > 0){
			
			try {
				
				get_counter().wait();
			}
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		//	generate leave packet
		set_byeMessage(new ByeMessage(get_regInfo().get_rn_student_degree(), get_regInfo().get_rn_department(),
				get_regInfo().get_rn_degree_level(), get_regInfo().get_rn_student_path(), get_regInfo().get_rn_year(),
				get_regInfo().get_rn_semester(), get_regInfo().get_rn_consult_term(), get_userInfo().getRc_rowid(),
				get_regInfo().get_rn_StudentAuthorization_semester(), get_regInfo().get_rn_CoursesPrintout_semester()));

		while(true){
			
			try {

				answer = getNetController().connectSendAndReceiveMessage("/pls/scwp/!SC.BYEBYEHD", get_byeMessage());
				
				System.out.println("==============================");
				System.out.println(answer);
				
				break;
				
			}
			catch (IOException e) { e.printStackTrace(); }
		}
		
		//	shutdown the executor
		get_executor().shutdownNow();
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

	public void set_regInfo(RegInfo _regInfo) {
		this._regInfo = _regInfo;
	}

	public RegInfo get_regInfo() {
		return _regInfo;
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

	public void set_byeMessage(ByeMessage _byeMessage) {
		this._byeMessage = _byeMessage;
	}

	public ByeMessage get_byeMessage() {
		return _byeMessage;
	}

	public void set_executor(ExecutorService _executor) {
		this._executor = _executor;
	}

	public ExecutorService get_executor() {
		return _executor;
	}

	public void set_counter(Counter _counter) {
		this._counter = _counter;
	}

	public Counter get_counter() {
		return _counter;
	}
}
