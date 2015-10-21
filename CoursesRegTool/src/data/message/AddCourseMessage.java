/**
 * 
 */
package data.message;

/**
 * @author Avi Digmi
 *
 */
public class AddCourseMessage implements Message {

	private String _year;
	private String _semester;
	private String _department;
	private String _level;
	private String _course;
	private String _rowID;
	private String _courseType;
	private String _groupNumber;
	private String _tirgulGroupNumber;

	/**
	 * @param year
	 * @param semester
	 * @param department
	 * @param level
	 * @param course
	 * @param rowID
	 * @param course_consult_msg
	 * @param courseType
	 * @param groupNumber
	 * @param tirgulGroupNumber
	 */
	public AddCourseMessage(String year, String semester, String department,
			String level, String course, String rowID, String courseType,
			String groupNumber, String tirgulGroupNumber) {

		super();
		set_year(year);
		set_semester(semester);
		set_department(department);
		set_level(level);
		set_course(course);
		set_rowID(rowID);
		set_courseType(courseType);
		set_groupNumber(groupNumber);
		set_tirgulGroupNumber(tirgulGroupNumber);
	}

	@Override
	public String getMessage() {
		
		String tirgul1 = "";
		String tirgul2 = "";
		
		if (!get_tirgulGroupNumber().isEmpty()){
		
			tirgul1 = "on_group_number_2=" + get_tirgulGroupNumber() + "&";
			tirgul2 = "&" + "Set1_2=" + get_tirgulGroupNumber();
		}
		
		//	TODO: make 'rn_department=373' as variable
		
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
						"oc_course_consult_msg=%F8%E9%F9%E5%ED+%EC%F7%E5%F8%F1+%E1%E5%F6%F2+%E1%E4%F6%EC%E7%E4&" +
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
						tirgul1 + "mainSet=" + get_groupNumber() + tirgul2;
		
		return msg;
	}

	public String get_year() {
		return _year;
	}

	public void set_year(String year) {
		this._year = year;
	}

	public String get_semester() {
		return _semester;
	}

	public void set_semester(String semester) {
		this._semester = semester;
	}

	public String get_department() {
		return _department;
	}

	public void set_department(String department) {
		this._department = department;
	}

	public String get_level() {
		return _level;
	}

	public void set_level(String level) {
		this._level = level;
	}

	public String get_course() {
		return _course;
	}

	public void set_course(String course) {
		this._course = course;
	}

	public String get_rowID() {
		return _rowID;
	}

	public void set_rowID(String rowID) {
		this._rowID = rowID;
	}

	public String get_courseType() {
		return _courseType;
	}

	public void set_courseType(String courseType) {
		this._courseType = courseType;
	}

	public String get_groupNumber() {
		return _groupNumber;
	}

	public void set_groupNumber(String groupNumber) {
		this._groupNumber = groupNumber;
	}

	public void set_tirgulGroupNumber(String tirgulGroupNumber) {
		this._tirgulGroupNumber = tirgulGroupNumber;
	}

	public String get_tirgulGroupNumber() {
		return _tirgulGroupNumber;
	}
}
