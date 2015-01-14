package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.Observer;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import model.IFigure;
import control.ControlGame;

public class Gui implements Observer, Runnable {

	private JPanel contentPane;
	private ArrayList<List<JButton>> buttonList = new ArrayList<List<JButton>>();
	private JButton btnStartGame = new JButton("Start Game");
	private JButton btnCloseGame = new JButton("Close Game");
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	private JButton button3 = new JButton("");
	private JButton button4 = new JButton("");
	private JButton button5 = new JButton("");
	private JButton button6 = new JButton("");
	private JButton button7 = new JButton("");
	private JButton button8 = new JButton("");
	private JButton button9 = new JButton("");
	private JButton button10 = new JButton("");
	private JButton button11 = new JButton("");
	private JButton button12 = new JButton("");
	private JButton button13 = new JButton("");
	private JButton button14 = new JButton("");
	private JButton button15 = new JButton("");
	private JButton button16 = new JButton("");
	private JButton button17 = new JButton("");
	private JButton button65 = new JButton("");
	private JButton button18 = new JButton("");
	private JButton button19 = new JButton("");
	private JButton button20 = new JButton("");
	private JButton button21 = new JButton("");
	private JButton button22 = new JButton("");
	private JButton button23 = new JButton("");
	private JButton button24 = new JButton("");
	private JButton button25 = new JButton("");
	private JButton button26 = new JButton("");
	private JButton button27 = new JButton("");
	private JButton button28 = new JButton("");
	private JButton button29 = new JButton("");
	private JButton button30 = new JButton("");
	private JButton button31 = new JButton("");
	private JButton button32 = new JButton("");
	private JButton button33 = new JButton("");
	private JButton button34 = new JButton("");
	private JButton button35 = new JButton("");
	private JButton button36 = new JButton("");
	private JButton button37 = new JButton("");
	private JButton button38 = new JButton("");
	private JButton button39 = new JButton("");
	private JButton button40 = new JButton("");
	private JButton button41 = new JButton("");
	private JButton button42 = new JButton("");
	private JButton button43 = new JButton("");
	private JButton button44 = new JButton("");
	private JButton button45 = new JButton("");
	private JButton button46 = new JButton("");
	private JButton button47 = new JButton("");
	private JButton button48 = new JButton("");
	private JButton button49 = new JButton("");
	private JButton button50 = new JButton("");
	private JButton button51 = new JButton("");
	private JButton button52 = new JButton("");
	private JButton button54 = new JButton("");
	private JButton button55 = new JButton("");
	private JButton button56 = new JButton("");
	private JButton button57 = new JButton("");
	private JButton button58 = new JButton("");
	private JButton button59 = new JButton("");
	private JButton button60 = new JButton("");
	private JButton button61 = new JButton("");
	private JButton button62 = new JButton("");
	private JButton button63 = new JButton("");
	private JButton button64 = new JButton("");
	private JFrame frame = new JFrame();

	private ControlGame controlGame;
	private List<IFigure> availableFigures;
	private List<Integer[]> availableFields;
	private List<IFigure> spieler;
	private List<IFigure> gegenspieler;
	private char tmpCase = ' ';

	/**
	 * Launch the application.
	 */
	@Override
	public void run() {
		frame.setVisible(true);
	}
	
	public class ChessButton extends JButton {
		int x;
		int y;
		
		public ChessButton(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
	}

	/**
	 * Create the frame.
	 */
	public Gui(ControlGame controlGame) {
		this.controlGame = controlGame;
		availableFigures = new ArrayList<IFigure>();
		availableFields = new ArrayList<Integer[]>();
		//controlGame.register(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 662, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.setContentPane(contentPane);
		
		actionStart();
		
		btnStartGame.setBounds(525, 129, 87, 23);
	
		actionClose();
		btnCloseGame.setBounds(525, 228, 89, 23);
		contentPane.setLayout(null);
		contentPane.add(btnStartGame);
		contentPane.add(btnCloseGame);
		
		actionButton1();
		button1.setEnabled(false);
		button1.setBackground(Color.BLACK);
		button1.setBounds(125, 306, 47, 41);
		button1.setIcon(new ImageIcon("src/images/Laeuferweiss.png"));
		contentPane.add(button1);
		
		actionButton2();
		button2.setEnabled(false);
		button2.setForeground(Color.WHITE);
		button2.setBackground(Color.WHITE);
		button2.setIcon(new ImageIcon("src/images/Pferdweiss.png"));
		button2.setBounds(79, 306, 47, 41);
		contentPane.add(button2);
		
		actionButton3();
		button3.setEnabled(false);
		button3.setBackground(Color.BLACK);
		button3.setIcon(new ImageIcon("src/images/Turmweiss.png"));
		button3.setBounds(33, 306, 47, 41);
		contentPane.add(button3);
		
		actionButton4();
		button4.setEnabled(false);
		button4.setBackground(Color.BLACK);
		button4.setIcon(new ImageIcon("src/images/Koenigweiss.png"));
		button4.setBounds(221, 305, 47, 42);
		contentPane.add(button4);
		
		actionButton5();
		button5.setEnabled(false);
		button5.setForeground(Color.WHITE);
		button5.setBackground(Color.WHITE);
		button5.setIcon(new ImageIcon("src/images/Laeuferweiss.png"));
		button5.setBounds(266, 306, 47, 41);
		contentPane.add(button5);
		
		actionButton6();
		button6.setEnabled(false);
		button6.setBackground(Color.BLACK);
		button6.setIcon(new ImageIcon("src/images/Pferdweiss.png"));
		button6.setBounds(310, 306, 47, 41);
		contentPane.add(button6);
		
		actionButton7();
		button7.setEnabled(false);
		button7.setForeground(Color.WHITE);
		button7.setBackground(Color.WHITE);
		button7.setIcon(new ImageIcon("src/images/Turmweiss.png"));
		button7.setBounds(356, 306, 47, 41);
		contentPane.add(button7);
		
		actionButton8();
		button8.setEnabled(false);
		button8.setBackground(Color.BLACK);
		button8.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button8.setBounds(356, 267, 47, 41);
		contentPane.add(button8);
		
		actionButton9();
		button9.setEnabled(false);
		button9.setBackground(Color.BLACK);
		button9.setBounds(310, 147, 47, 41);
		contentPane.add(button9);
		
		actionButton10();
		button10.setEnabled(false);
		button10.setForeground(Color.BLACK);
		button10.setBackground(Color.BLACK);
		button10.setBounds(356, 186, 47, 41);
		contentPane.add(button10);
		
		actionButton11();
		button11.setEnabled(false);
		button11.setForeground(Color.WHITE);
		button11.setBackground(Color.WHITE);
		button11.setBounds(356, 147, 47, 41);
		contentPane.add(button11);
		
		actionButton12();
		button12.setEnabled(false);
		button12.setBackground(Color.BLACK);
		button12.setBounds(356, 106, 47, 41);
		contentPane.add(button12);
		
		actionButton13();
		button13.setEnabled(false);
		button13.setForeground(Color.WHITE);
		button13.setBackground(Color.WHITE);
		button13.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button13.setBounds(356, 66, 47, 41);
		contentPane.add(button13);
		
		actionButton14();
		button14.setEnabled(false);
		button14.setIcon(new ImageIcon("src/images/Turmschwarz.png"));
		button14.setForeground(Color.BLACK);
		button14.setBackground(Color.BLACK);
		button14.setBounds(356, 27, 47, 41);
		contentPane.add(button14);
		
		actionButton15();
		button15.setEnabled(false);
		button15.setBackground(Color.WHITE);
		button15.setForeground(Color.WHITE);
		button15.setBounds(356, 227, 47, 41);
		contentPane.add(button15);
		
		actionButton16();
		button16.setEnabled(false);
		button16.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button16.setBackground(Color.BLACK);
		button16.setBounds(310, 66, 47, 41);
		contentPane.add(button16);
		
		actionButton17();
		button17.setEnabled(false);
		button17.setBackground(Color.BLACK);
		button17.setBounds(33, 147, 47, 41);
		contentPane.add(button17);
		
		actionButton65();
		button65.setEnabled(false);
		button65.setForeground(Color.WHITE);
		button65.setBackground(Color.WHITE);
		button65.setBounds(79, 147, 47, 41);
		contentPane.add(button65);
		
		actionButton18();
		button18.setEnabled(false);
		button18.setBackground(Color.BLACK);
		button18.setBounds(125, 147, 47, 41);
		contentPane.add(button18);
		
		actionButton19();
		button19.setEnabled(false);
		button19.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button19.setBackground(Color.BLACK);
		button19.setBounds(266, 267, 47, 41);
		contentPane.add(button19);
		
		actionButton20();
		button20.setEnabled(false);
		button20.setForeground(Color.WHITE);
		button20.setBackground(Color.WHITE);
		button20.setBounds(266, 147, 47, 41);
		contentPane.add(button20);
		
		actionButton21();
		button21.setEnabled(false);
		button21.setForeground(Color.WHITE);
		button21.setBackground(Color.WHITE);
		button21.setBounds(33, 186, 47, 41);
		contentPane.add(button21);
		
		actionButton22();
		button22.setEnabled(false);
		button22.setForeground(Color.BLACK);
		button22.setBackground(Color.BLACK);
		button22.setBounds(79, 186, 47, 41);
		contentPane.add(button22);
		
		actionButton23();
		button23.setEnabled(false);
		button23.setForeground(Color.WHITE);
		button23.setBackground(Color.WHITE);
		button23.setBounds(125, 186, 47, 41);
		contentPane.add(button23);
		
		actionButton24();
		button24.setEnabled(false);
		button24.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button24.setBackground(Color.BLACK);
		button24.setBounds(221, 66, 47, 41);
		contentPane.add(button24);
		
		actionButton25();
		button25.setEnabled(false);
		button25.setForeground(Color.WHITE);
		button25.setBackground(Color.WHITE);
		button25.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button25.setBounds(266, 66, 47, 41);
		contentPane.add(button25);
		
		actionButton26();
		button26.setEnabled(false);
		button26.setForeground(Color.WHITE);
		button26.setBackground(Color.WHITE);
		button26.setBounds(310, 186, 47, 41);
		contentPane.add(button26);
		
		actionButton27();
		button27.setEnabled(false);
		button27.setIcon(new ImageIcon("src/images/Pferdschwarz.png"));
		button27.setBackground(Color.WHITE);
		button27.setBounds(310, 27, 47, 41);
		contentPane.add(button27);
		
		actionButton28();
		button28.setEnabled(false);
		button28.setForeground(Color.WHITE);
		button28.setBackground(Color.WHITE);
		button28.setBounds(310, 106, 47, 46);
		contentPane.add(button28);
		
		actionButton29();
		button29.setEnabled(false);
		button29.setBackground(Color.BLACK);
		button29.setBounds(79, 106, 47, 41);
		contentPane.add(button29);
		
		actionButton30();
		button30.setEnabled(false);
		button30.setBackground(Color.BLACK);
		button30.setBounds(172, 106, 47, 41);
		contentPane.add(button30);
		
		actionButton31();
		button31.setEnabled(false);
		button31.setForeground(Color.WHITE);
		button31.setBackground(Color.WHITE);
		button31.setBounds(125, 106, 47, 41);
		contentPane.add(button31);
		
		actionButton32();
		button32.setEnabled(false);
		button32.setIcon(new ImageIcon("src/images/Koeniginschwarz.png"));
		button32.setBackground(Color.BLACK);
		button32.setBounds(172, 27, 47, 41);
		contentPane.add(button32);
		
		actionButton33();
		button33.setEnabled(false);
		button33.setForeground(Color.WHITE);
		button33.setBackground(Color.WHITE);
		button33.setIcon(new ImageIcon("src/images/Laeuferschwarz.png"));
		button33.setBounds(125, 27, 47, 41);
		contentPane.add(button33);
		
		actionButton34();
		button34.setEnabled(false);
		button34.setIcon(new ImageIcon("src/images/Pferdschwarz.png"));
		button34.setBackground(Color.BLACK);
		button34.setBounds(79, 27, 47, 41);
		contentPane.add(button34);
		
		actionButton35();
		button35.setEnabled(false);
		button35.setForeground(Color.WHITE);
		button35.setBackground(Color.WHITE);
		button35.setIcon(new ImageIcon("src/images/Turmschwarz.png"));
		button35.setBounds(33, 27, 47, 41);
		contentPane.add(button35);
		
		actionButton36();
		button36.setEnabled(false);
		button36.setForeground(Color.WHITE);
		button36.setBackground(Color.WHITE);
		button36.setBounds(172, 306, 47, 41);
		button36.setIcon(new ImageIcon("src/images/Koeniginweiss.png"));
		contentPane.add(button36);	
		
		actionButton37();
		button37.setEnabled(false);
		button37.setForeground(Color.BLACK);
		button37.setBackground(Color.BLACK);
		button37.setBounds(172, 186, 47, 41);
		contentPane.add(button37);
		
		actionButton38();
		button38.setEnabled(false);
		button38.setBackground(Color.BLACK);
		button38.setBounds(266, 106, 47, 41);
		contentPane.add(button38);
		
		actionButton39();
		button39.setEnabled(false);
		button39.setForeground(Color.WHITE);
		button39.setBackground(Color.WHITE);
		button39.setIcon(new ImageIcon("src/images/Koenigschwarz.png"));
		button39.setBounds(221, 27, 47, 41);
		contentPane.add(button39);
		
		actionButton40();
		button40.setEnabled(false);
		button40.setIcon(new ImageIcon("src/images/Laeuferschwarz.png"));
		button40.setForeground(Color.BLACK);
		button40.setBackground(Color.BLACK);
		button40.setBounds(266, 27, 47, 41);
		contentPane.add(button40);
		
		actionButton41();
		button41.setEnabled(false);
		button41.setForeground(Color.WHITE);
		button41.setBackground(Color.WHITE);
		button41.setBounds(172, 147, 47, 41);
		contentPane.add(button41);
		
		actionButton42();
		button42.setEnabled(false);
		button42.setBackground(Color.BLACK);
		button42.setForeground(Color.BLACK);
		button42.setBounds(221, 147, 47, 41);
		contentPane.add(button42);
		
		actionButton43();
		button43.setEnabled(false);
		button43.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button43.setBackground(Color.BLACK);
		button43.setBounds(33, 66, 47, 41);
		contentPane.add(button43);
		
		actionButton44();
		button44.setEnabled(false);
		button44.setForeground(Color.WHITE);
		button44.setBackground(Color.WHITE);
		button44.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button44.setBounds(79, 66, 47, 41);
		contentPane.add(button44);
	    
		actionButton45();
		button45.setEnabled(false);
		button45.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button45.setBackground(Color.BLACK);
		button45.setBounds(125, 66, 47, 41);
		contentPane.add(button45);
		
		actionButton46();
		button46.setEnabled(false);
		button46.setForeground(Color.WHITE);
		button46.setBackground(Color.WHITE);
		button46.setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
		button46.setBounds(172, 66, 47, 41);
		contentPane.add(button46);
		
		actionButton47();
		button47.setEnabled(false);
		button47.setForeground(Color.BLACK);
		button47.setBackground(Color.BLACK);
		button47.setBounds(125, 227, 47, 41);
		contentPane.add(button47);
		
		actionButton48();
		button48.setEnabled(false);
		button48.setForeground(Color.WHITE);
		button48.setBackground(Color.WHITE);
		button48.setBounds(79, 227, 47, 41);
		contentPane.add(button48);
		
		actionButton49();
		button49.setEnabled(false);
		button49.setForeground(Color.BLACK);
		button49.setBackground(Color.BLACK);
		button49.setBounds(33, 227, 47, 41);
		contentPane.add(button49);
		
		actionButton50();
		button50.setEnabled(false);
		button50.setForeground(Color.BLACK);
		button50.setBackground(Color.BLACK);
		button50.setBounds(266, 186, 47, 41);
		contentPane.add(button50);
		
		actionButton51();
		button51.setEnabled(false);
		button51.setForeground(Color.WHITE);
		button51.setBackground(Color.WHITE);
		button51.setBounds(33, 106, 47, 41);
		contentPane.add(button51);
		
		actionButton52();
		button52.setEnabled(false);
		button52.setForeground(Color.WHITE);
		button52.setBackground(Color.WHITE);
		button52.setBounds(221, 186, 47, 41);
		contentPane.add(button52);
		
		actionButton54();
		button54.setEnabled(false);
		button54.setForeground(Color.WHITE);
		button54.setBackground(Color.WHITE);
		button54.setBounds(221, 106, 47, 41);
		contentPane.add(button54);
		
		actionButton55();
		button55.setEnabled(false);
		button55.setForeground(Color.WHITE);
		button55.setBackground(Color.WHITE);
		button55.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button55.setBounds(310, 267, 47, 41);
		contentPane.add(button55);
		
		
		actionButton56();
		button56.setEnabled(false);
		button56.setForeground(Color.BLACK);
		button56.setBackground(Color.BLACK);
		button56.setBounds(310, 227, 47, 41);
		contentPane.add(button56);
		
		
		actionButton57();
		button57.setEnabled(false);
		button57.setForeground(Color.WHITE);
		button57.setBackground(Color.WHITE);
		button57.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button57.setBounds(221, 267, 47, 41);
		contentPane.add(button57);
		
		
		actionButton58();
		button58.setEnabled(false);
		button58.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button58.setForeground(Color.BLACK);
		button58.setBackground(Color.BLACK);
		button58.setBounds(172, 267, 47, 41);
		contentPane.add(button58);
		
		
		actionButton59();
		button59.setEnabled(false);
		button59.setForeground(Color.WHITE);
		button59.setBackground(Color.WHITE);
		button59.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button59.setBounds(125, 267, 47, 41);
		contentPane.add(button59);
		
		
		actionButton60();
		button60.setEnabled(false);
		button60.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button60.setForeground(Color.BLACK);
		button60.setBackground(Color.BLACK);
		button60.setBounds(79, 267, 47, 41);
		contentPane.add(button60);
		
		
		actionButton61();
		button61.setEnabled(false);
		button61.setForeground(Color.WHITE);
		button61.setBackground(Color.WHITE);
		button61.setIcon(new ImageIcon("src/images/Bauerweiss.png"));
		button61.setBounds(33, 267, 47, 41);
		contentPane.add(button61);
		
		
		actionButton62();
		button62.setEnabled(false);
		button62.setForeground(Color.WHITE);
		button62.setBackground(Color.WHITE);
		button62.setBounds(266, 227, 47, 41);
		contentPane.add(button62);
		
		
		actionButton63();
		button63.setEnabled(false);
		button63.setForeground(Color.BLACK);
		button63.setBackground(Color.BLACK);
		button63.setBounds(221, 227, 47, 41);
		contentPane.add(button63);
		
		actionButton64();
		button64.setEnabled(false);
		button64.setForeground(Color.WHITE);
		button64.setBackground(Color.WHITE);
		button64.setBounds(172, 227, 47, 41);
		contentPane.add(button64);
		
		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(1, 306, 22, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(1, 267, 22, 41);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(1, 227, 22, 41);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(1, 186, 22, 41);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(1, 147, 22, 41);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_5.setBounds(1, 106, 22, 41);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_6.setBounds(1, 66, 22, 41);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_7.setBounds(1, 27, 22, 41);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("1");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_8.setBounds(43, 349, 37, 23);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("2");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_9.setBounds(89, 349, 37, 23);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("3");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(135, 349, 37, 23);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("4");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(182, 349, 37, 23);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("5");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_12.setBounds(231, 349, 37, 23);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("6");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(276, 349, 37, 23);
		contentPane.add(label_13);
		
		JLabel lblNewLabel = new JLabel("7");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(320, 349, 37, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label_14 = new JLabel("8");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(366, 349, 37, 23);
		contentPane.add(label_14);
		
		JButton button = new JButton("");
		button.setForeground(Color.BLACK);
		button.setEnabled(false);
		button.setBackground(Color.BLACK);
		button.setBounds(466, 0, 9, 391);
		contentPane.add(button);
		
		fillListEmpty();
		
		buttonList.get(0).add(button3);
		buttonList.get(0).add(button2);
		buttonList.get(0).add(button1);
		buttonList.get(0).add(button36);
		buttonList.get(0).add(button4);
		buttonList.get(0).add(button5);
		buttonList.get(0).add(button6);
		buttonList.get(0).add(button7);
		
		buttonList.get(1).add(button61);
		buttonList.get(1).add(button60);
		buttonList.get(1).add(button59);
		buttonList.get(1).add(button58);
		buttonList.get(1).add(button57);
		buttonList.get(1).add(button19);
		buttonList.get(1).add(button55);
		buttonList.get(1).add(button8);
		
		buttonList.get(2).add(button49);
		buttonList.get(2).add(button48);
		buttonList.get(2).add(button47);
		buttonList.get(2).add(button64);
		buttonList.get(2).add(button63);
		buttonList.get(2).add(button62);
		buttonList.get(2).add(button56);
		buttonList.get(2).add(button10);
	
		buttonList.get(3).add(button21);
		buttonList.get(3).add(button22);
		buttonList.get(3).add(button23);
		buttonList.get(3).add(button37);
		buttonList.get(3).add(button52);
		buttonList.get(3).add(button50);
		buttonList.get(3).add(button26);
		buttonList.get(3).add(button15);
		
		buttonList.get(4).add(button17);
		buttonList.get(4).add(button65);
		buttonList.get(4).add(button18);
		buttonList.get(4).add(button41);
		buttonList.get(4).add(button42);
		buttonList.get(4).add(button20);
		buttonList.get(4).add(button9);
		buttonList.get(4).add(button11);
		
		buttonList.get(5).add(button51);
		buttonList.get(5).add(button29);
		buttonList.get(5).add(button31);
		buttonList.get(5).add(button30);
		buttonList.get(5).add(button54);
		buttonList.get(5).add(button38);
		buttonList.get(5).add(button28);
		buttonList.get(5).add(button12);
		
		buttonList.get(6).add(button43);
		buttonList.get(6).add(button44);
		buttonList.get(6).add(button45);
		buttonList.get(6).add(button46);
		buttonList.get(6).add(button24);
		buttonList.get(6).add(button25);
		buttonList.get(6).add(button16);
		buttonList.get(6).add(button13);
		
		buttonList.get(7).add(button35);
		buttonList.get(7).add(button34);
		buttonList.get(7).add(button33);
		buttonList.get(7).add(button32);
		buttonList.get(7).add(button39);
		buttonList.get(7).add(button40);
		buttonList.get(7).add(button27);
		buttonList.get(7).add(button14);
	}

	private void fillListEmpty() {
		for (int i = 0; i < 8; i++) {
			this.buttonList.add(new ArrayList<JButton>());
		}
	}

	private void actionButton64() {
		button64.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton63() {
		button63.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton62() {
		button62.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton61() {
		button61.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton60() {
		button60.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton59() {
		button59.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton58() {
		button58.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton57() {
		button57.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton56() {
		button56.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton55() {
		button55.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton54() {
		button54.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton52() {
		button52.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton51() {
		button51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton50() {
		button50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton49() {
		button49.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton48() {
		button48.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton47() {
		button47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton46() {
		button46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton45() {
		button45.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton44() {
		button44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton43() {
		button43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton42() {
		button42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton41() {
		button41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton40() {
		button40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton39() {
		button39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton38() {
		button38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton37() {
		button37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton36() {
		button36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton35() {
		button35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton34() {
		button34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton33() {
		button33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton32() {
		button32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton31() {
		button31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton30() {
		button30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton29() {
		button29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton28() {
		button28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton27() {
		button27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton26() {
		button26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton25() {
		button25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton24() {
		button24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton23() {
		button23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton22() {
		button22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton21() {
		button21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton20() {
		button20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton19() {
		button19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton18() {
		button18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton65() {
		button65.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton17() {
		button17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton16() {
		button16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton15() {
		button15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton14() {
		button14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton13() {
		button13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton12() {
		button12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton11() {
		button11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton10() {
		button10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton9() {
		button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton8() {
		button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton7() {
		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton6() {
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton5() {
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton4() {
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton3() {
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton2() {
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionButton1() {
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void actionClose() {
		btnCloseGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void actionStart() {
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableStartFields();
				btnStartGame.setEnabled(false);
			}

			private void enableStartFields() {
				Integer[] lines = { 0, 1 };
				for (int i : lines) {
					enableButtons(i);
				}
			}

			private void enableButtons(int i) {
				for (int a = 0; a < buttonList.get(i).size(); a++) {
					buttonList.get(i).get(a).setEnabled(true);
				}
			}
		});
	}

	public void updateLists(List<Integer[]> availableField,
			List<IFigure> availableFigure) {
		this.availableFields = availableField;
		this.availableFigures = availableFigure;
	}

	@Override
	public void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase, List<IFigure> curPlayer, List<IFigure> opPlayer) {
		setAvailableFigures(availableFigures);
		setAvailableFields(availableFields);
		setTmpCase(tmpCase);
		setSpieler(curPlayer);
		setGegenspieler(opPlayer);
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