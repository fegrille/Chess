package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidate {
	
	public List<Integer[]> colidateFigurePawn(Figure f, List<Integer[]> pf, Player p) {
		List<Figure> figureList = unmovedFigures(f,p);
		for(int i = 0; i < pf.size(); i++) {
			if(colidate(figureList, pf.get(i))) {
				pf = removeFieldsPawn(pf,pf.get(i),f.getColor());
			}
		}
		return pf;
	}
	
	public List<Figure> unmovedFigures(Figure f, Player p) {
		List<Figure> figureList = p.getFigureList();
		int[] fPos = f.getField();
		for(int i = 0; i < figureList.size(); i++) {
			int[] figPos = figureList.get(i).getField();
			if(fPos[0] == figPos[0] && fPos[1] == figPos[1]) {
				figureList.remove(i);
			}
		}
		return figureList;
	}
	
	public boolean colidate(List<Figure> f, Integer[] posF) {
		boolean col = false;
		for(int i = 0; i < f.size(); i++) {
			int[] position = f.get(i).getField();
			if(posF[0] == position[0] && posF[1] == position[1]) {
				col = true;
				break;
			}
		}
		return col;
	}
	
	public List<Integer[]> removeFieldsPawn(List<Integer[]> pf, Integer[] colField, char color) {
		for(int i = 0; i < pf.size(); i++) {
			pf = removeFieldForColor(pf, colField, i, color);
		}
		return pf;
	}
	
	public List<Integer[]> removeFieldForColor(List<Integer[]> pf, Integer[] colField, int index, char color) {
		Integer[] position = pf.get(index);
		if(color == 'b') {
			if(position[0] == colField[0] && position[1] == colField[1] || position[0] < colField[0]) {
				pf.remove(index);
			}
		} else {
			if(position[0] == colField[0] && position[1] == colField[1] || position[0] > colField[0]) {
				pf.remove(index);
			}
		}
		
		return pf;
	}

}
