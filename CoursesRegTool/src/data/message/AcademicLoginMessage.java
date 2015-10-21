/**
 * 
 */
package data.message;

/**
 * @author Avi Digmi
 *
 */
public class AcademicLoginMessage implements Message {
	
	private String _rc_rowid;

	/**
	 * 
	 */
	public AcademicLoginMessage() {
		super();
	}

	/**
	 * @param rc_rowid
	 */
	public AcademicLoginMessage(String rc_rowid) {
		
		super();
		setRc_rowid(rc_rowid);
	}

	@Override
	public String getMessage() {

		return "rc_rowid=" + getRc_rowid();
	}

	public String getRc_rowid() {
		return _rc_rowid;
	}

	public void setRc_rowid(String rc_rowid) {
		this._rc_rowid = rc_rowid;
	}
}
