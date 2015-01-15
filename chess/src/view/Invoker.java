/**
 * 
 */
package view;

/**
 * @author Felix
 *
 */
public class Invoker {
	
	private Comand com;
	
	public void setCommand(Comand c) {
		this.setCom(c);
	}

	public Comand getCom() {
		return com;
	}

	public void setCom(Comand com) {
		setCommand(com);
	}
}
