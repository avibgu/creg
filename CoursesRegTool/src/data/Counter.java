/**
 * 
 */
package data;

/**
 * @author Avi Digmi
 *
 */
public class Counter {
	
	private int _counter;
	
	public Counter(int maxValue) {

		set_counter(maxValue);
	}
	
	public synchronized void decrease() {

		set_counter(get_counter()-1);
		this.notifyAll();
	}

	public synchronized void set_counter(int _counter) {
		this._counter = _counter;
	}

	public synchronized int get_counter() {
		return _counter;
	}
}
