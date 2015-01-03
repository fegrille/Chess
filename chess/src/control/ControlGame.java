package control;

import java.util.ArrayList;


public class ControlGame implements Subject {

	private ArrayList<Observer> observers;
	private ControlEndGame controlEG;


	public ControlGame() {
		observers = new ArrayList<Observer>();
		controlEG = new ControlEndGame();
	}
	
	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
		
	}

	@Override
	public void unregister(Observer deleteObserver) {
		observers.remove(deleteObserver);
		
	}

	@Override
	public void notifyObserver() {
		for(Observer observer : observers) {
			observer.update();
		}
		
	}
	
	public void start() {
		while(!controlEG.getWin()) {
			notifyObserver();
		}
	}
}
