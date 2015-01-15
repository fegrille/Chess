package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import model.IFigure;
import model.Knight;
import control.ControlGame;
import control.Observer;

public class Tui implements Observer, Runnable {

	private ControlGame controlGame;
	private List<IFigure> availableFigures;
	private List<IFigure> spieler;
	private List<IFigure> gegenspieler;
	private List<Integer[]> availableFields;
	private char tmpCase = ' ';
	private List<List<String>> fieldlines;
	private StringBuilder field;
	private String s;
	
	private String newLine = System.getProperty("line.separator");
	
	private Logger logger = Logger.getLogger("view.tui");
	
	public Tui(ControlGame controlGame) {
		this.controlGame = controlGame;
		availableFigures = new ArrayList<IFigure>();
		availableFields = new ArrayList<Integer[]>();
		controlGame.register(this);
	}

	@Override
	public void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase, List<IFigure> curPlayer, List<IFigure> opPlayer) {
		setAvailableFigures(availableFigures);
		setAvailableFields(availableFields);
		setTmpCase(tmpCase);
		setSpieler(curPlayer);
		setGegenspieler(opPlayer);
		updateTuiText();
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String si;
		while(!controlGame.getControlEG().getWin()) {
			si = scan.next();
			controlGame.setChoise(si);	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warning(e.getMessage());
			}
		}
		scan.close();
		logger.info(newLine + "Player " + controlGame.getPlayerOpponent().getCol() + " has won! Congratulation!");
	}

	public void updateTuiText() {
        switch (this.tmpCase) {
        case 'f':
        	field = new StringBuilder();
        	buildField();
        	fillField();
        	field.append(newLine);
        	fillPrint();
        	addLastLine();
        	addInformation();
        	StringBuilder figures = new StringBuilder();
        	figures.append(field);
        	figures.append(newLine + "Figures that can be moved:" + newLine);
        	int index = 0;
        	for(IFigure f : getAvailableFigures()) {
        		String sa = index + " " + f.returnName() + "[" + f.getField()[0] + "," + f.getField()[1] + "]" + newLine;
        		figures.append(sa);
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
        	fields.append("Please select a Field to move you figure" + newLine + "or select -1 to return to Figure selection!" + newLine);
            fields.append("Write the Index of the Field!");
        	logger.info(newLine + fields);
            break;
        default:
        	logger.info(newLine + "You wrote a wrong value!");
            break;
        }
	}

	private void addInformation() {
		field.append(newLine);
		field.append("Field Information: (1. 0, 2. P , 3. w)" + newLine);
		field.append("1. Index of figure" + newLine);
		field.append("2. Kind of figure (P = Pawn, Kn = Knight etc)" + newLine);
		field.append("3. Color of figure (w = white, b = black)" + newLine);
		
	}

	private void fillPrint() {
		for( int i = 8; i >= 0; i--) {
			fillPrintXLine(i);
			addNewLine(i);
		}
	}

	private void addNewLine(int i) {
		if(i > 0) {
			field.append(newLine);
		}
	}

	private void fillPrintXLine(int i) {
		for(int a = 0; a < fieldlines.get(i).size(); a++) {
			field.append(fieldlines.get(i).get(a));
		}
	}

	private void addLastLine() {
		for(int a = 0; a < fieldlines.get(9).size(); a++) {
			field.append(fieldlines.get(9).get(a));
		}
		field.append(newLine);
	}

	private void fillField() {
		int index = 0;
		for(IFigure f : getSpieler()) {
			checkFigureType(index, f);
			fieldlines.get(f.getY()).set(f.getX(), this.s);
		    index++;
		}
		insertEnemy();
	}

	/**
	 * @param index
	 * @param f
	 * @return
	 */
	private void checkFigureType(int index, IFigure f) {
		if(f instanceof Knight) {
			fillIndexForKnight(index, f);
		} else {
			fillForIndex(index, f);
		}
	}

	private void fillIndexForKnight(int index, IFigure f) {
		if(index < 10) {
			this.s = "[  " + index +  "Kn" + f.getColor() + "]";
		} else {
			this.s = "[ " + index +  "Kn" + f.getColor() + "]";
		}
	}

	private void fillForIndex(int index, IFigure f) {
		if(index < 10) {
			this.s = "[   " + index + f.returnName().charAt(0) + f.getColor() + "]";
		} else {
			this.s = "[  " + index + f.returnName().charAt(0) + f.getColor() + "]";
		}
	}

	/**
	 * 
	 */
	private void insertEnemy() {
		int index = 0;
		for(IFigure f : getGegenspieler()) {
			checkFigureType(index, f);
			fieldlines.get(f.getY()).set(f.getX(), this.s);
			index++;
		}
	}

	private void buildField() {
		fieldlines = new ArrayList<List<String>>();
		int c = 1;
		fillFieldLines();
		c = iterateLine(c);
	}

	private void fillFieldLines() {
		for(int i = 10; i > 0; i--) {
			fieldlines.add(new ArrayList<String>());
		}
	}

	/**
	 * @param c
	 * @return
	 */
	private int iterateLine(int c) {
		int ind = 0;
		int ca = c;
		for(int i = 9; i > 0; i--) {
			ca = buildLine(ca, i, ind);
			ind++;
		}
		return ca;
	}

	/**
	 * @param c
	 * @param i
	 * @return
	 */
	private int buildLine(int c, int i, int ind) {
		int ca = c;
		if(i == 9) {
			fieldlines.get(i).add(" ");
			xKordLine(i);
		} else {
			fieldlines.get(c).add("" + ind + "");
			fillLinesEmpty(c);
			ca++;
		}
		return ca;
	}

	private void xKordLine(int i) {
		for(int b = 1; b < 9; b++) {
			fieldlines.get(i).add("   " + b + "    ");
		}
	}

	private void fillLinesEmpty(int c) {
		for(int a = 0; a < 8; a++) {
			fieldlines.get(c).add("[      ]");
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
	
	private List<IFigure> getSpieler() {
		return spieler;
	}

	private void setSpieler(List<IFigure> spieler) {
		this.spieler = spieler;
	}

	private List<IFigure> getGegenspieler() {
		return gegenspieler;
	}

	private void setGegenspieler(List<IFigure> gegenspieler) {
		this.gegenspieler = gegenspieler;
	}
	
}
