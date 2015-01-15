package view;

public class UndoableComand implements Comand {
	
	Receiver r;
	
	public UndoableComand(Receiver r) {
		this.r = r;
	}

	
	
	@Override
    public void execute() {
		r.undo();
	}
}
