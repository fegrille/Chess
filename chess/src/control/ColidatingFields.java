package control;

import java.util.ArrayList;
import java.util.List;

import model.ChessConstants;
import model.Figure;
import model.IFigure;
import model.Player;

public class ColidatingFields {
	
	private List<List<Integer[]>> fields;
	private List<IFigure> figureList;
	private boolean colidate = false;
	private int counter;

	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figList) {
		this.figureList = new ArrayList<IFigure>();
		for(IFigure fig : figList) {
			IFigure f = deepCopy(fig);
			this.figureList.add(f);
		}
	}
	
	private IFigure deepCopy(IFigure fig) {
		IFigure copy = new Figure();
		copy.setColor(fig.getColor());
		copy.setField(fig.getField()[0], fig.getField()[1]);
		return copy;
	}

	private void setColidate(boolean b) {
		this.colidate = b;
	}
	
	public boolean isColidate() {
		return colidate;
	}
	
	public List<List<Integer[]>> getFields() {
		return fields;
	}
	
	public void setFields(List<List<Integer[]>> fields) {
		this.fields = fields;
	}
	
	public void unmovedFigures(IFigure f) {
		int[] cords = f.getField();
		for(setCounter(0); getCounter() < getFigureList().size(); setCounter(getCounter() + 1)) {
			int[] figPos = getFigureList().get(getCounter()).getField();
			removeFigure(cords,figPos);
		}
	}

	private void removeFigure(int[] fPos,int[] figPos) {
		if(fPos[0] == figPos[0] && fPos[1] == figPos[1]) {
			getFigureList().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}
	
	public boolean colidate(Integer[] posF) {
		setColidate(false);
		checkColidateFigures(posF);
		return isColidate();
	}

	private void checkColidateFigures(Integer[] posF) {
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] position = getFigureList().get(i).getField();
			checkColidatePosition(posF, position);
		}
	}

	private void checkColidatePosition(Integer[] posF, int[] position) {
		if(equalsArray(posF, position)) {
			setColidate(true);
		}
	}
	
	private void checkColiDirectionOwn(int j) {
		for(int i = 0; i < getFields().get(j).size(); i++) {
			checkColidationOwn(i, j);
		}
	}

	private void checkColidationOwn(int i, int list) {
		if(colidate(getFields().get(list).get(i))) {
			removeRest(i, list);
		}
	}

	private void removeRest(int i, int list) {
		int a = i;
		while( a < getFields().get(list).size()) {
			getFields().get(list).remove(a);
		}
		
	}

	public void colidateOwnFigure(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwn();
		f.setPosFields(getFields());
	}

	private void checkColiOwn() {
		checkColiDirectionOwn(ChessConstants.LISTELEONE);
		checkColiDirectionOwn(ChessConstants.LISTELETWO);
		checkColiDirectionOwn(ChessConstants.LISTELETHREE);
		checkColiDirectionOwn(ChessConstants.LISTELEFOUR);
	}


	public void colidateOtherFigure(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOther();
		f.setPosFields(getFields());
	}

	private void checkColiOther() {
		checkColiDirecOther(ChessConstants.LISTELEONE);
		checkColiDirecOther(ChessConstants.LISTELETWO);
		checkColiDirecOther(ChessConstants.LISTELETHREE);
		checkColiDirecOther(ChessConstants.LISTELEFOUR);
	}
	
	private void checkColiDirecOther(int j) {
		for(int i = 0; i < getFields().get(j).size(); i++) {
			checkColidationOther(i, j);
		}
	}

	private void checkColidationOther(int i, int list) {
		if(colidate(getFields().get(list).get(i))) {
			removeRest(i + 1, list);
		}
	}
	
	public void colidateOwnQueen(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwnQueen();
		f.setPosFields(getFields());
	}
	
	private void checkColiOwnQueen() {
		checkColiDirectionOwn(ChessConstants.LISTELEONE);
		checkColiDirectionOwn(ChessConstants.LISTELETWO);
		checkColiDirectionOwn(ChessConstants.LISTELETHREE);
		checkColiDirectionOwn(ChessConstants.LISTELEFOUR);
		checkColiDirectionOwn(ChessConstants.LISTELEFIVE);
		checkColiDirectionOwn(ChessConstants.LISTELESIX);
		checkColiDirectionOwn(ChessConstants.LISTELESEVEN);
		checkColiDirectionOwn(ChessConstants.LISTELEEIGHT);
	}
	
	public void colidateOtherQueen(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOtherQueen();
		f.setPosFields(getFields());
		
	}

	private void checkColiOtherQueen() {
		checkColiDirecOther(ChessConstants.LISTELEONE);
		checkColiDirecOther(ChessConstants.LISTELETWO);
		checkColiDirecOther(ChessConstants.LISTELETHREE);
		checkColiDirecOther(ChessConstants.LISTELEFOUR);
		checkColiDirecOther(ChessConstants.LISTELEFIVE);
		checkColiDirecOther(ChessConstants.LISTELESIX);
		checkColiDirecOther(ChessConstants.LISTELESEVEN);
		checkColiDirecOther(ChessConstants.LISTELEEIGHT);		
	}

	private boolean equalsArray(Integer[] arr1, int[] arr2) {
		boolean equals = false;
		if(arr1[0] == arr2[0] && arr1[1] == arr2[1]) {
			equals = true;
		}
		return equals;
	}
	
	public void colidateInFrontPawn(IFigure f, Player p) {
		List<IFigure> flist = p.getFigureList();
		setFigureList(flist);
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiDirectionOwn(0);
		f.setPosFields(getFields());
		
	}

}
