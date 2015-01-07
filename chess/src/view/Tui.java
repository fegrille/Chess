package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import model.IFigure;
import control.ControlGame;
import control.Observer;

public class Tui implements Observer, Runnable {

	private ControlGame controlGame;
	private List<IFigure> availableFigures;
	private List<Integer[]> availableFields;
	private String tmpCase = "";
	
	private String newLine = System.getProperty("line.separator");
	
	private Logger logger = Logger.getLogger("view.tui");
	
	public Tui(ControlGame controlGame) {
		this.controlGame = controlGame;
		availableFigures = new ArrayList<IFigure>();
		availableFields = new ArrayList<Integer[]>();
		controlGame.register(this);
	}
	
	@Override
	public void update(List<IFigure> availableFigures, List<Integer[]> availableFields, String tmpCase) {
		setAvailableFigures(availableFigures);
		setAvailableFields(availableFields);
		setTmpCase(tmpCase);
		updateTuiText();
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String s;
		while(!controlGame.getControlEG().getWin()) {
			s = scan.next();
			controlGame.setChoise(s);	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		scan.close();
		logger.info(newLine + "Player " + controlGame.getPlayerOpponent().getCol() + " has won! Concratulation!");
	}

	public void updateTuiText() {
        switch (this.tmpCase) {
        case "figure":
        	logger.info(newLine + "Please select Figure! Write the Index of the Figure!");
        	int index = 0;
        	for(IFigure f : getAvailableFigures()) {
        		logger.info(newLine + index + " " + f.returnName() + "[" + f.getField()[0] + "," + f.getField()[1] + "]");
        		index++;
        	}
            break;
        case "field":
        	logger.info(newLine + "Please select Field or press \"exit\" to return to Figure selection!");
        	logger.info(newLine + "Write the Index of the Figure!");
        	index = 0;
        	for(Integer[] i : getAvailableFields()) {
        		logger.info(newLine + index + " " + "[" + i[0] + "," + i[1] + "]");
        		index++;
        	}
            break;
        case "wrong":
        	logger.info(newLine + "You wrote a wrong value!");
            break;
        }
	}

	public List<IFigure> getAvailableFigures() {
		return availableFigures;
	}

	public void setAvailableFigures(List<IFigure> availableFigures) {
		this.availableFigures = availableFigures;
	}

	public List<Integer[]> getAvailableFields() {
		return availableFields;
	}

	public void setAvailableFields(List<Integer[]> availableFields) {
		this.availableFields = availableFields;
	}

	public String getTmpCase() {
		return tmpCase;
	}

	public void setTmpCase(String tmpCase) {
		this.tmpCase = tmpCase;
	}
	
}
