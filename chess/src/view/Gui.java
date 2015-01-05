package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Gui extends JFrame {
	private JPanel contentPane;
	private JLabel btBild_1;

	/**
	 * Create the frame.
	 */
	public Gui() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 425);
		JLabel btBild = new JLabel();
		Image field, background, queen, king, rook, bishop, knight, pawn;
		
		JMenuBar menuBar = new JMenuBar();
		try {
			background = ImageIO.read(getClass().getResource("C:/Users/Felix/git/Chess/chess/src/images/Schachhintergrund.png"));
			btBild_1 = new JLabel(new ImageIcon(background));
			btBild_1.setBounds(new Rectangle(2, 2, 699, 434));
			btBild_1.setText("");
		} 
		catch(IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(this, "Grafikdatei nicht gefunden!");
	    }
	    catch(IOException ioe) {
	    	JOptionPane.showMessageDialog(this, "Fehler beim Einlesen der Grafikdatei!");
	    }
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btBild_1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(287))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btBild_1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
