/**
 * 
 */
package view;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author Felix
 *
 */
public class Receiver {
	
	private int fieldsize;
	private JButton[][] buttons;
	

	public void undo(int fsize, JButton[][] buts) {
		this.fieldsize = fsize;
		this.buttons = buts.clone();
		for(int y = 0; y < fieldsize; y++) {
			for(int x = 0; x < fieldsize; x++) {
				buttons[y][x].setIcon(null);
				buttons[y][x].setEnabled(false);
				if(y % 2 == 0 && x % 2 == 1 || y % 2 == 1 && x % 2 == 0) {
					buttons[y][x].setBackground(Color.BLACK);
				} else {
					buttons[y][x].setBackground(Color.WHITE);
				}
			}
		}
	}
}
