/**
 * 
 */
package data.info;

/**
 * @author Avi Digmi
 *
 */
public class CourseInfo {
	
	private String _semester;
	private String _department;
	private String _level;
	private String _group;

	/**
	 * 
	 */
	public CourseInfo() {
		super();
	}
	
	/**
	 * @param _semester
	 * @param _department
	 * @param _level
	 * @param group 
	 */
	public CourseInfo(String semester, String department, String level, String group) {
		super();
		set_semester(semester);
		set_department(department);
		set_level(level);
		set_group(group);
	}

	public Object get_group() {
		return _group;
	}

	public void set_group(String _group) {
		this._group = _group;
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
}
