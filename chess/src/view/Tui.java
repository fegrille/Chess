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
	private char tmpCase = ' ';
	
	private String newLine = System.getProperty("line.separator");
	
	private Logger logger = Logger.getLogger("view.tui");
	
	public Tui(ControlGame controlGame) {
		this.controlGame = controlGame;
		availableFigures = new ArrayList<IFigure>();
		availableFields = new ArrayList<Integer[]>();
		controlGame.register(this);
	}
	
	@Override
	public void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase) {
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
		logger.info(newLine + "Player " + controlGame.getPlayerOpponent().getCol() + " has won! Congratulation!");
	}

	public void updateTuiText() {
        switch (this.tmpCase) {
        case 'f':
        	StringBuilder figures = new StringBuilder();
        	figures.append(newLine + "Figures that can be moved:" + newLine);
        	int index = 0;
        	for(IFigure f : getAvailableFigures()) {
        		String s = index + " " + f.returnName() + "[" + f.getField()[0] + "," + f.getField()[1] + "]" + newLine;
        		figures.append(s);
        		index++;
        	}
        	figures.append("Please choose a figure you want to move by entering the index:");
        	logger.info(newLine + figures);
            break;
        case 's':
        	index = 0;
        	StringBuilder fields = new StringBuilder();
        	fields.append(newLine + "These are the fields you can move to:" + newLine);
        	for(Integer[] i : getAvailableFields()) {
        		fields.append(index + " " + "[" + i[0] + "," + i[1] + "]" + newLine);
        		index++;
        	}
        	fields.append("Please select Field or press \"exit\" to return to Figure selection!" + newLine);
            fields.append("Write the Index of the Field!");
        	logger.info(newLine + fields);
            break;
        default:
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

	public char getTmpCase() {
		return tmpCase;
	}

	public void setTmpCase(char tmpCase) {
		this.tmpCase = tmpCase;
	}
	
}
