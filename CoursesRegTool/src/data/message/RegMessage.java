/**
 * 
 */
package data.message;

/**
 * @author Avi Digmi
 *
 */
public class RegMessage {

	private String _year;
	private String _semester;
	private String _department;
	private String _level;
	private String _course;
	private String _rowID;
	private String _course_consult_msg;
	private String _courseType;
	private String _groupNumber;

	/**
	 * @param _year
	 * @param _semester
	 * @param _department
	 * @param _level
	 * @param _course
	 * @param _rowID
	 * @param _course_consult_msg
	 * @param _courseType
	 * @param _groupNumber
	 */
	public RegMessage(String _year, String _semester, String _department,
			String _level, String _course, String _rowID,
			String _course_consult_msg, String _courseType, String _groupNumber) {

		super();
		set_year(_year);
		set_semester(_semester);
		set_department(_department);
		set_level(_level);
		set_course(_course);
		set_rowID(_rowID);
		set_course_consult_msg(_course_consult_msg);
		set_courseType(_courseType);
		set_groupNumber(_groupNumber);
	}

	public String toString(){
		
		String msg =	"rc_rowid=" + get_rowID() + "&" +
						"rn_student_degree=1&" +
						"rn_department=373&" +
						"rn_degree_level=1&" +
						"rn_student_path=1&" +
						"rn_year=" + get_year() + "&" +
						"rn_semester=" + get_semester() + "&" +
						"rn_course_institution=0&" +
						"rn_course_department=" + get_department() + "&" +
						"rn_course_degree_level=" + get_level() + "&" +
						"rn_course=" + get_course() + "&" +
						"on_course_type=" + get_courseType() + "&" +
						"rn_consult_term=0&" +
						"oc_course_consult_msg=" + get_course_consult_msg() + "&" +
						"on_waiting_group=&" +
						"on_next_action=&" +
						"rn_course_exists=0&" +
						"window=&" +
						"width=&" +
						"height=&" +
						"rn_group_number_leftSpace=&" +
						"rn_profile_leftSpace=&" +
						"rn_StudentAuthorization_semester=" + get_semester() + "&" +
						"rn_CoursesPrintout_semester=" + get_semester() + "&" +
						"on_group_number_1=" + get_groupNumber() + "&" +
						"mainSet=7";
		
		return msg;
	}

	public String get_year() {
		return _year;
	}

	public void set_year(String _year) {
		this._year = _year;
	}

	public String get_semester() {
		return _semester;
	}

	public void set_semester(String _semester) {
		this._semester = _semester;
	}

	public String get_department() {
		return _department;
	}

	public void set_department(String _department) {
		this._department = _department;
	}

	public String get_level() {
		return _level;
	}

	public void set_level(String _level) {
		this._level = _level;
	}

	public String get_course() {
		return _course;
	}

	public void set_course(String _course) {
		this._course = _course;
	}

	public String get_rowID() {
		return _rowID;
	}

	public void set_rowID(String _rowID) {
		this._rowID = _rowID;
	}

	public String get_course_consult_msg() {
		return _course_consult_msg;
	}

	public void set_course_consult_msg(String _course_consult_msg) {
		this._course_consult_msg = _course_consult_msg;
	}

	public String get_courseType() {
		return _courseType;
	}

	public void set_courseType(String _courseType) {
		this._courseType = _courseType;
	}

	public String get_groupNumber() {
		return _groupNumber;
	}

	public void set_groupNumber(String _groupNumber) {
		this._groupNumber = _groupNumber;
	}
}
