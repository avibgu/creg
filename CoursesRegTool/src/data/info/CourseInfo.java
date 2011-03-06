/**
 * 
 */
package data.info;

/**
 * @author Avi Digmi
 *
 */
public class CourseInfo {
	
	private String _department;
	private String _level;
	private String _course;
	private String _group;

	/**
	 * 
	 */
	public CourseInfo() {
		super();
	}

	/**
	 * @param _department
	 * @param _level
	 * @param _course
	 * @param _group
	 */
	public CourseInfo(String _department, String _level, String _course, String _group) {
		
		super();
		this._department = _department;
		this._level = _level;
		this._course = _course;
		this._group = _group;
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
	
	public void set_course(String _course) {
		this._course = _course;
	}

	public String get_course() {
		return _course;
	}

	public String get_group() {
		return _group;
	}

	public void set_group(String _group) {
		this._group = _group;
	}
}
