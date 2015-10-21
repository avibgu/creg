/**
 * 
 */
package data;

import java.util.logging.Logger;

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

		_counter--;
		this.notifyAll();
	}

	public synchronized void set_counter(int _counter) {
		this._counter = _counter;
	}

	public synchronized int get_counter() {
		return _counter;
	}

	public synchronized void waitForZero() {

		try {
		
			while (_counter > 0)
				wait();
		}
		catch (InterruptedException e){
			Logger.getLogger("RegLogger").severe(e.getMessage());
		}
	}
}
