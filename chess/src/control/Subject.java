package control;

/**
 * 
 * @author Felix
 *
 */
public interface Subject {
	
	/**
	 * 
	 * @param o
	 */
	void register(Observer o);
	
	/**
	 * 
	 * @param o
	 */
	void unregister(Observer o);
	
	/**
	 * 
	 */
	void notifyObserver();

}
