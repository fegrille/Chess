package control;

import java.util.ArrayList;
import java.util.List;

import model.ChessConstants;
import model.Figure;
import model.IFigure;
import model.Player;

/**
 * 
 * @author Felix
 *
 */
public class ColidatingFields implements IColidatingfields{
	
	private List<List<Integer[]>> fields;
	private List<IFigure> figureList;
	private boolean colidate = false;
	private int counter;

	/**
	 * 
	 * @return
	 */
	public int getCounter() {
		return counter;
	}
	
	/**
	 * 
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<IFigure> getFigureList() {
		return figureList;
	}

	/**
	 * 
	 * @param figList
	 */
	public void setFigureList(List<IFigure> figList) {
		this.figureList = new ArrayList<IFigure>();
		for(IFigure fig : figList) {
			IFigure f = deepCopy(fig);
			this.figureList.add(f);
		}
	}
	
	/**
	 * 
	 * @param fig
	 * @return
	 */
	private IFigure deepCopy(IFigure fig) {
		IFigure copy = new Figure();
		copy.setColor(fig.getColor());
		copy.setField(fig.getField()[0], fig.getField()[1]);
		return copy;
	}

	/**
	 * 
	 * @param b
	 */
	private void setColidate(boolean b) {
		this.colidate = b;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isColidate() {
		return colidate;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<List<Integer[]>> getFields() {
		return fields;
	}
	
	/**
	 * 
	 * @param fields
	 */
	public void setFields(List<List<Integer[]>> fields) {
		this.fields = fields;
	}
	
	/**
	 * 
	 * @param f
	 */
	@Override
	public void unmovedFigures(IFigure f) {
		int[] cords = f.getField();
		for(setCounter(0); getCounter() < getFigureList().size(); setCounter(getCounter() + 1)) {
			int[] figPos = getFigureList().get(getCounter()).getField();
			removeFigure(cords,figPos);
		}
	}
	
	/**
	 * 
	 * @param fPos
	 * @param figPos
	 */
	private void removeFigure(int[] fPos,int[] figPos) {
		if(fPos[0] == figPos[0] && fPos[1] == figPos[1]) {
			getFigureList().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}
	
	/**
	 * 
	 * @param posF
	 * @return
	 */
	@Override
	public boolean colidate(Integer[] posF) {
		setColidate(false);
		checkColidateFigures(posF);
		return isColidate();
	}

	/**
	 * 
	 * @param posF
	 */
	private void checkColidateFigures(Integer[] posF) {
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] position = getFigureList().get(i).getField();
			checkColidatePosition(posF, position);
		}
	}

	/**
	 * 
	 * @param posF
	 * @param position
	 */
	private void checkColidatePosition(Integer[] posF, int[] position) {
		if(equalsArray(posF, position)) {
			setColidate(true);
		}
	}
	
	/**
	 * 
	 * @param j
	 */
	private void checkColiDirectionOwn(int j) {
		for(int i = 0; i < getFields().get(j).size(); i++) {
			checkColidationOwn(i, j);
		}
	}

	/**
	 * 
	 * @param i
	 * @param list
	 */
	private void checkColidationOwn(int i, int list) {
		if(colidate(getFields().get(list).get(i))) {
			removeRest(i, list);
		}
	}

	/**
	 * 
	 * @param i
	 * @param list
	 */
	private void removeRest(int i, int list) {
		int a = i;
		while( a < getFields().get(list).size()) {
			getFields().get(list).remove(a);
		}
		
	}

	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOwnFigure(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwn();
		f.setPosFields(getFields());
	}

	/**
	 * 
	 */
	private void checkColiOwn() {
		checkColiDirectionOwn(ChessConstants.LISTELEONE);
		checkColiDirectionOwn(ChessConstants.LISTELETWO);
		checkColiDirectionOwn(ChessConstants.LISTELETHREE);
		checkColiDirectionOwn(ChessConstants.LISTELEFOUR);
	}

	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOtherFigure(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOther();
		f.setPosFields(getFields());
	}

	/**
	 * 
	 */
	private void checkColiOther() {
		checkColiDirecOther(ChessConstants.LISTELEONE);
		checkColiDirecOther(ChessConstants.LISTELETWO);
		checkColiDirecOther(ChessConstants.LISTELETHREE);
		checkColiDirecOther(ChessConstants.LISTELEFOUR);
	}
	
	/**
	 * 
	 * @param j
	 */
	private void checkColiDirecOther(int j) {
		for(int i = 0; i < getFields().get(j).size(); i++) {
			checkColidationOther(i, j);
		}
	}

	/**
	 * 
	 * @param i
	 * @param list
	 */
	private void checkColidationOther(int i, int list) {
		if(colidate(getFields().get(list).get(i))) {
			removeRest(i + 1, list);
		}
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOwnQueen(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwnQueen();
		f.setPosFields(getFields());
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOtherQueen(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOtherQueen();
		f.setPosFields(getFields());
		
	}

	/**
	 * 
	 */
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

	/**
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private boolean equalsArray(Integer[] arr1, int[] arr2) {
		boolean equals = false;
		if(arr1[0] == arr2[0] && arr1[1] == arr2[1]) {
			equals = true;
		}
		return equals;
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateInFrontPawn(IFigure f, Player p) {
		List<IFigure> flist = p.getFigureList();
		setFigureList(flist);
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiDirectionOwn(0);
		f.setPosFields(getFields());
		
	}

}
