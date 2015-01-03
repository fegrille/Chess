package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Observer;
import control.Subject;

public class Gui implements Observer, Runnable {

	private static int observerIDTracker = 1;
	private int observerID;
	private Subject controlGame;
	
	private JPanel contentPane;
	private JFrame mainFrame;
	
	public Gui(Subject controlGame) {
		this.controlGame = controlGame;
		this.observerID = ++observerIDTracker;
		controlGame.register(this);
		
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		mainFrame.setContentPane(contentPane);
		mainFrame.setVisible(true);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
		
	
}
