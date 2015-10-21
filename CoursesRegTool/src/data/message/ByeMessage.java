/**
 * 
 */
package data.message;

/**
 * @author Avi Digmi
 *
 */
public class ByeMessage implements Message {

	private String _rn_student_degree;
	private String _rn_department;
	private String _rn_degree_level;
	private String _rn_student_path;
	private String _rn_year;
	private String _rn_semester;
	private String _rn_consult_term;
	private String _rc_rowid;
	private String _rn_StudentAuthorization_semester;
	private String _rn_CoursesPrintout_semester;
	
	public ByeMessage() {}
	
	/**
	 * @param _rn_student_degree
	 * @param _rn_department
	 * @param _rn_degree_level
	 * @param _rn_student_path
	 * @param _rn_year
	 * @param _rn_semester
	 * @param _rn_consult_term
	 * @param _rc_rowid
	 * @param _rn_StudentAuthorization_semester
	 * @param _rn_CoursesPrintout_semester
	 */
	public ByeMessage(String _rn_student_degree, String _rn_department,
			String _rn_degree_level, String _rn_student_path, String _rn_year,
			String _rn_semester, String _rn_consult_term, String _rc_rowid,
			String _rn_StudentAuthorization_semester,
			String _rn_CoursesPrintout_semester) {
		super();
		this._rn_student_degree = _rn_student_degree;
		this._rn_department = _rn_department;
		this._rn_degree_level = _rn_degree_level;
		this._rn_student_path = _rn_student_path;
		this._rn_year = _rn_year;
		this._rn_semester = _rn_semester;
		this._rn_consult_term = _rn_consult_term;
		this._rc_rowid = _rc_rowid;
		this._rn_StudentAuthorization_semester = _rn_StudentAuthorization_semester;
		this._rn_CoursesPrintout_semester = _rn_CoursesPrintout_semester;
	}

	/* (non-Javadoc)
	 * @see data.message.Message#getMessage()
	 */
	@Override
	public String getMessage() {

		String msg =	"rn_student_degree=" + get_rn_student_degree() + "&" +
						"rn_department=" + get_rn_department() + "&" +
						"rn_degree_level=" + get_rn_degree_level() + "&" +
						"rn_student_path=" + get_rn_student_path() + "&" +
						"rn_year=" + get_rn_year() + "&" +
						"rn_semester=" + get_rn_semester() + "&" +
						"rn_consult_term=" + get_rn_consult_term() + "&" +
						"rc_rowid=" + get_rc_rowid() + "&" +
						"rn_StudentAuthorization_semester=" + get_rn_StudentAuthorization_semester() + "&" +
						"rn_CoursesPrintout_semester=" + get_rn_CoursesPrintout_semester() + "&" +
						"oc_course_name=" +
						"on_course_department=" +
						"on_course_degree_level=" +
						"on_course=";	
				
		return msg;
	}

	public String get_rn_student_degree() {
		return _rn_student_degree;
	}

	public void set_rn_student_degree(String _rn_student_degree) {
		this._rn_student_degree = _rn_student_degree;
	}

	public String get_rn_department() {
		return _rn_department;
	}

	public void set_rn_department(String _rn_department) {
		this._rn_department = _rn_department;
	}

	public String get_rn_degree_level() {
		return _rn_degree_level;
	}

	public void set_rn_degree_level(String _rn_degree_level) {
		this._rn_degree_level = _rn_degree_level;
	}

	public String get_rn_student_path() {
		return _rn_student_path;
	}

	public void set_rn_student_path(String _rn_student_path) {
		this._rn_student_path = _rn_student_path;
	}

	public String get_rn_year() {
		return _rn_year;
	}

	public void set_rn_year(String _rn_year) {
		this._rn_year = _rn_year;
	}

	public String get_rn_semester() {
		return _rn_semester;
	}

	public void set_rn_semester(String _rn_semester) {
		this._rn_semester = _rn_semester;
	}

	public String get_rn_consult_term() {
		return _rn_consult_term;
	}

	public void set_rn_consult_term(String _rn_consult_term) {
		this._rn_consult_term = _rn_consult_term;
	}

	public String get_rc_rowid() {
		return _rc_rowid;
	}

	public void set_rc_rowid(String _rc_rowid) {
		this._rc_rowid = _rc_rowid;
	}

	public String get_rn_StudentAuthorization_semester() {
		return _rn_StudentAuthorization_semester;
	}

	public void set_rn_StudentAuthorization_semester(
			String _rn_StudentAuthorization_semester) {
		this._rn_StudentAuthorization_semester = _rn_StudentAuthorization_semester;
	}

	public String get_rn_CoursesPrintout_semester() {
		return _rn_CoursesPrintout_semester;
	}

	public void set_rn_CoursesPrintout_semester(String _rn_CoursesPrintout_semester) {
		this._rn_CoursesPrintout_semester = _rn_CoursesPrintout_semester;
	}
}
