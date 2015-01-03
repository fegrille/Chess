package view;

import control.Observer;
import control.Subject;

public class Tui implements Observer, Runnable {

	private static int observerIDTracker = 1;
	private int observerID;
	private Subject controlGame;
	
	public Tui(Subject controlGame) {
		this.controlGame = controlGame;
		this.observerID = ++observerIDTracker;
		controlGame.register(this);
	}
	
	@Override
	public void update() {
		System.out.println("TEst");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
