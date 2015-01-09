package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Color;

public class Gui extends JFrame {

	/**
	 * Create the frame.
	 */
	public Gui() {
		JPanel contentPane;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 425);
		JLabel btBild = new JLabel(new ImageIcon("C:/Users/Felix/git/Chess/chess/src/images/Schachhintergrund.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		btBild.setLabelFor(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnStartGame = new JButton("Start Game");
		
		JButton btnCloseGame = new JButton("Close Game");
		contentPane.add(btBild,0);
		contentPane.add(btnStartGame,0);
		contentPane.add(btnCloseGame,0);
	}
}
