package view;

import javax.swing.JButton;

public class UndoableComand implements Comand {
	
	private Receiver r;
	
	public UndoableComand(Receiver r) {
		this.r = r;
	}

	
	
	@Override
    public void execute(int fieldsize, JButton[][] buttons) {
		r.undo(fieldsize, buttons);
	}
}
