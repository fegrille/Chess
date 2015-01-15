package view;

import java.util.ArrayList;
import java.util.List;

import control.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import model.Bishop;
import model.IFigure;
import model.King;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;
import control.ControlGame;

public class Gui implements Observer, Runnable {

	private JPanel contentPane;
	private List<List<JButton>> buttonList = new ArrayList<List<JButton>>();
	private JButton btnResetChoise = new JButton("ResetFigChoise");
	private JButton btnCloseGame = new JButton("Close Game");

	private int fieldsize = 8;
	private JButton[][] buttons = new JButton[fieldsize][fieldsize];
	private JFrame frame = new JFrame();

	private ControlGame controlGame;
	private List<IFigure> availableFigures;
	private List<Integer[]> availFields;
	private List<IFigure> player;
	private List<IFigure> enemy;
	private char tempCase = ' ';
	private JLabel win = new JLabel();
	private static final String TAHOMA = "Tahoma";

	/**
	 * Launch the application.
	 */
	@Override
	public void run() {
		frame.setVisible(true);
	}


	/**
	 * Create the frame.
	 */
	public Gui(ControlGame controlGame) {
		this.controlGame = controlGame;
		availableFigures = new ArrayList<IFigure>();
		availFields = new ArrayList<Integer[]>();
		controlGame.register(this);
		
		for(int y = 0; y < fieldsize; y++) {
			for(int x = 0; x < fieldsize; x++) {
				buttons[y][x] = new JButton("");
			}
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 662, 429);
		frame.setResizable(false);
		frame.setTitle("Chess");
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.setContentPane(contentPane);
		win.setBounds(490, 300, 150, 80);
		win.setVisible(true);
		frame.add(win);
		
		actionStart();
		
		btnResetChoise.setBounds(490, 129, 150, 30);
	
		actionClose();
		btnCloseGame.setBounds(490, 228, 150, 30);
		contentPane.setLayout(null);
		contentPane.add(btnResetChoise);
		contentPane.add(btnCloseGame);
		
		for(int y = 0; y < fieldsize; y++) {
			for(int x = 0; x < fieldsize; x++) {
				buttons[y][x].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						returnButtonField();
					}
				});
				buttons[y][x].setEnabled(false);
				if(y % 2 == 0 && x % 2 == 1 || y % 2 == 1 && x % 2 == 0) {
					buttons[y][x].setBackground(Color.BLACK);
				} else {
					buttons[y][x].setBackground(Color.WHITE);
				}
				buttons[y][x].setBounds((x)*45+40, (7-y)*40+20, 45, 40);
				contentPane.add(buttons[y][x]);
			}
		}

		

		
		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label.setBounds(1, 306, 22, 41);
		contentPane.add(label);
		
		JLabel label1 = new JLabel("2");
		label1.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(1, 267, 22, 41);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("3");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label2.setBounds(1, 227, 22, 41);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("4");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label3.setBounds(1, 186, 22, 41);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("5");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label4.setBounds(1, 147, 22, 41);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("6");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label5.setBounds(1, 106, 22, 41);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("7");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label6.setBounds(1, 66, 22, 41);
		contentPane.add(label6);
		
		JLabel label7 = new JLabel("8");
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label7.setBounds(1, 27, 22, 41);
		contentPane.add(label7);
		
		JLabel label8 = new JLabel("1");
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label8.setBounds(43, 349, 37, 23);
		contentPane.add(label8);
		
		JLabel label9 = new JLabel("2");
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label9.setBounds(89, 349, 37, 23);
		contentPane.add(label9);
		
		JLabel label10 = new JLabel("3");
		label10.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setBounds(135, 349, 37, 23);
		contentPane.add(label10);
		
		JLabel label11 = new JLabel("4");
		label11.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		label11.setBounds(182, 349, 37, 23);
		contentPane.add(label11);
		
		JLabel label12 = new JLabel("5");
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label12.setBounds(231, 349, 37, 23);
		contentPane.add(label12);
		
		JLabel label13 = new JLabel("6");
		label13.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label13.setHorizontalAlignment(SwingConstants.CENTER);
		label13.setBounds(276, 349, 37, 23);
		contentPane.add(label13);
		
		JLabel lblNewLabel = new JLabel("7");
		lblNewLabel.setFont(new Font(TAHOMA, Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(320, 349, 37, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label14 = new JLabel("8");
		label14.setFont(new Font(TAHOMA, Font.BOLD, 17));
		label14.setHorizontalAlignment(SwingConstants.CENTER);
		label14.setBounds(366, 349, 37, 23);
		contentPane.add(label14);
		
		JButton button = new JButton("");
		button.setForeground(Color.BLACK);
		button.setEnabled(false);
		button.setBackground(Color.BLACK);
		button.setBounds(466, 0, 9, 391);
		contentPane.add(button);
		
		fillListEmpty();
	}

	private void fillListEmpty() {
		for (int i = 0; i < 8; i++) {
			this.buttonList.add(new ArrayList<JButton>());
		}
	}

	private void returnButtonField() {
		for(int y = 0; y < fieldsize; y++) {
			for(int x = 0; x < fieldsize; x++) {
				if(buttons[y][x].isFocusOwner()) {
					if(getTempCase() == 'f') {
						IFigure fig;
						for(int f = 0; f < getAvailableFigs().size(); f++) {
							fig = getAvailableFigs().get(f);
							if(fig.getY() - 1 == y && fig.getX() - 1 == x) {
						        Integer myInteger = Integer.valueOf(f); 
						        String s = myInteger.toString(); 
								controlGame.setChoise(s);
								return;
							}
						}
					} else {
						Integer[] field;
						for(int f = 0; f < getAvailFields().size(); f++) {
							field = getAvailFields().get(f);
							if(field[0] - 1 == y && field[1] - 1 == x) {
						        Integer myInteger = Integer.valueOf(f); 
						        String s = myInteger.toString(); 
								controlGame.setChoise(s);
								return;
							}
						}
					}
				}
			}
		}
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
		btnResetChoise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int f = -1;
				Integer myInteger = Integer.valueOf(f);
				String s = myInteger.toString();
				controlGame.setChoise(s);
				btnResetChoise.setEnabled(false);
			}

		});
	}

	public void updateLists(List<Integer[]> availableField,
			List<IFigure> availableFigure) {
		this.availFields = availableField;
		this.availableFigures = availableFigure;
	}

	@Override
	public void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase, List<IFigure> curPlayer, List<IFigure> opPlayer) {
		setAvailableFigs(availableFigures);
		setAvailFields(availableFields);
		setTempCase(tmpCase);
		setPlayer(curPlayer);
		setEnemy(opPlayer);
		updateGuiView();
	}
	
	private void updateGuiView() {
		resetField();
		if(getPlayer().get(0).getColor() == 'w') {
			setIconWhite(getPlayer());
			setIconBlack(getEnemy());
		} else {
			setIconWhite(getEnemy());
			setIconBlack(getPlayer());
		}
        switch (this.tempCase) {
	    case 'f':
	    	enableButtonsFigures();
	    	break;
	    case 's':
	    	enableButtonsFields();
	        break;
	    case 'w':
	    	resetField();
	    	setWin();
	        break;
	    default:
	        break;
	    }
	}

	private void setWin() {
		win.setText("Player " + controlGame.getPlayerOpponent().getCol() + " has won!");
	}


	private void enableButtonsFigures() {
		for(IFigure fig : getAvailableFigs()) {
			buttons[fig.getY() -1][fig.getX() -1].setEnabled(true);
		}
	}


	private void enableButtonsFields() {
		btnResetChoise.setEnabled(true);
		for(Integer[] field : getAvailFields()) {
			buttons[field[0] -1][field[1] -1].setEnabled(true);
		}
	}



	private void resetField() {
		btnResetChoise.setEnabled(false);
		for(int y = 0; y < fieldsize; y++) {
			for(int x = 0; x < fieldsize; x++) {
				buttons[y][x].setIcon(null);
				buttons[y][x].setEnabled(false);
			}
		}
	}

	private void setIconWhite(List<IFigure> figs) {
		for(IFigure fig : figs) {
			if(fig instanceof Pawn) {
				buttons[fig.getY() -1][fig.getX() -1].setIcon(new ImageIcon("src/images/Bauerweiss.png"));
				continue;
			}
			if(fig instanceof King) {
				buttons[fig.getY() -1][fig.getX() -1].setIcon(new ImageIcon("src/images/Koenigweiss.png"));
				continue;
			}
			if(fig instanceof Queen) {
				buttons[fig.getY() -1][fig.getX() -1].setIcon(new ImageIcon("src/images/Koeniginweiss.png"));
				continue;
			}
			if(fig instanceof Bishop) {
				buttons[fig.getY() -1][fig.getX() -1].setIcon(new ImageIcon("src/images/Laeuferweiss.png"));
				continue;
			}
			if(fig instanceof Rook) {
				buttons[fig.getY() -1][fig.getX() -1].setIcon(new ImageIcon("src/images/Turmweiss.png"));
				continue;
			}
			if(fig instanceof Knight) {
				buttons[fig.getY() -1][fig.getX() -1].setIcon(new ImageIcon("src/images/Pferdweiss.png"));
				continue;
			}
		}
	}
	
	private void setIconBlack(List<IFigure> figs) {
		for(IFigure f : figs) {
			if(f instanceof Pawn) {
				buttons[f.getY() -1][f.getX() -1].setIcon(new ImageIcon("src/images/Bauerschwarz.png"));
				continue;
			}
			if(f instanceof King) {
				buttons[f.getY() -1][f.getX() -1].setIcon(new ImageIcon("src/images/Koenigschwarz.png"));
				continue;
			}
			if(f instanceof Queen) {
				buttons[f.getY() -1][f.getX() -1].setIcon(new ImageIcon("src/images/Koeniginschwarz.png"));
				continue;
			}
			if(f instanceof Bishop) {
				buttons[f.getY() -1][f.getX() -1].setIcon(new ImageIcon("src/images/Laeuferschwarz.png"));
				continue;
			}
			if(f instanceof Rook) {
				buttons[f.getY() -1][f.getX() -1].setIcon(new ImageIcon("src/images/Turmschwarz.png"));
				continue;
			}
			if(f instanceof Knight) {
				buttons[f.getY() -1][f.getX() -1].setIcon(new ImageIcon("src/images/Pferdschwarz.png"));
				continue;
			}
		}
	}

	public List<IFigure> getAvailableFigs() {
		return availableFigures;
	}

	public void setAvailableFigs(List<IFigure> availableFigs) {
		this.availableFigures = availableFigs;
	}

	public List<Integer[]> getAvailFields() {
		return availFields;
	}

	public void setAvailFields(List<Integer[]> availFields) {
		this.availFields = availFields;
	}

	public char getTempCase() {
		return tempCase;
	}

	public void setTempCase(char tempCase) {
		this.tempCase = tempCase;
	}
	
	private List<IFigure> getPlayer() {
		return player;
	}

	private void setPlayer(List<IFigure> player) {
		this.player = player;
	}

	private List<IFigure> getEnemy() {
		return enemy;
	}

	private void setEnemy(List<IFigure> enemy) {
		this.enemy = enemy;
	}
}