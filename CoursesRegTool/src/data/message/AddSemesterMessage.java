/**
 * 
 */
package data.message;

/**
 * @author Avi Digmi
 *
 */

public class AddSemesterMessage implements Message {
	
	private String _rc_rowid;
	private String _rn_student_degree;
	private String _rn_department;
	private String _rn_degree_level;
	private String _rn_student_path;
	private String _rn_year;
	private String _rn_semester;
	private String _rn_consult_term;
	private String _rn_consult_status;
	
	public AddSemesterMessage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param _rc_rowid
	 * @param _rn_student_degree
	 * @param _rn_department
	 * @param _rn_degree_level
	 * @param _rn_student_path
	 * @param _rn_year
	 * @param _rn_semester
	 * @param _rn_consult_term
	 * @param _rn_consult_status
	 */
	public AddSemesterMessage(String _rc_rowid, String _rn_student_degree,
			String _rn_department, String _rn_degree_level,
			String _rn_student_path, String _rn_year, String _rn_semester,
			String _rn_consult_term, String _rn_consult_status) {
		
		super();
		set_rc_rowid(_rc_rowid);
		set_rn_student_degree(_rn_student_degree);
		set_rn_department(_rn_department);
		set_rn_degree_level(_rn_degree_level);
		set_rn_student_path(_rn_student_path);
		set_rn_year(_rn_year);
		set_rn_semester(_rn_semester);
		set_rn_consult_term(_rn_consult_term);
		set_rn_consult_status(_rn_consult_status);
	}

	@Override
	public String getMessage() {
		
		String msg =	"rc_rowid=" + get_rc_rowid() + "&" +
						"rn_student_degree=" + get_rn_student_degree() + "&" +
						"rn_department=" + get_rn_department() + "&" +
						"rn_degree_level=" + get_rn_degree_level() + "&" +
						"rn_student_path=" + get_rn_student_path() + "&" +
						"rn_year=" + get_rn_year() + "&" +
						"rn_semester=" + get_rn_semester() + "&" +
						"rn_consult_term=" + get_rn_consult_term() + "&" +
						"rn_consult_status=" + get_rn_consult_status();

		return msg;
	}

	public String get_rc_rowid() {
		return _rc_rowid;
	}

	public void set_rc_rowid(String _rc_rowid) {
		this._rc_rowid = _rc_rowid;
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

	public String get_rn_consult_status() {
		return _rn_consult_status;
	}

	public void set_rn_consult_status(String _rn_consult_status) {
		this._rn_consult_status = _rn_consult_status;
	}
}
