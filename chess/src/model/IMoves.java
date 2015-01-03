package model;

import java.util.List;

/**
 * 
 * @author fegrille
 *
 */
public interface IMoves {
	
	/**
	 * 
	 * @return
	 */
	List<Integer[]> getFields();
	
	/**
	 * 
	 * @param fields
	 */
	void setFields(List<Integer[]> fields);
	
	/**
	 * 
	 * @param yKord
	 * @param xKord
	 */
	void movesQueen(int yKord, int xKord);
	
	/**
	 * 
	 * @param yKord
	 * @param xKord
	 */
	void movesBishop(int yKord, int xKord);
	
	/**
	 * 
	 * @param yKord
	 * @param xKord
	 */
	void movesRook(int yKord, int xKord);
	
	/**
	 * 
	 * @param f
	 * @param yKord
	 * @param xKord
	 */
	void moveFigure(IFigure f, int yKord, int xKord);
	
	/**
	 * 
	 * @return
	 */
	List<List<Integer[]>> getFieldList();

	/**
	 * 
	 * @param fieldList
	 */
	void setFieldList(List<List<Integer[]>> fieldList);

}
