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
	private ArrayList<List<JButton>> buttonList = new ArrayList<List<JButton>>();
	private JButton btnResetChoise = new JButton("ResetFigChoise");
	private JButton btnCloseGame = new JButton("Close Game");

	private int fieldsize = 8;
	private JButton[][] buttons = new JButton[fieldsize][fieldsize];
	private JFrame frame = new JFrame();

	private ControlGame controlGame;
	private List<IFigure> availableFigures;
	private List<Integer[]> availableFields;
	private List<IFigure> spieler;
	private List<IFigure> gegenspieler;
	private char tmpCase = ' ';
	private JLabel win = new JLabel();

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
		availableFields = new ArrayList<Integer[]>();
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
					if(getTmpCase() == 'f') {
						IFigure fig;
						for(int f = 0; f < getAvailableFigs().size(); f++) {
							fig = getAvailableFigs().get(f);
							if(fig.getY() - 1 == y && fig.getX() - 1 == x) {
						        Integer myInteger = new Integer(f); 
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
						        Integer myInteger = new Integer(f); 
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
				Integer myInteger = new Integer(f);
				String s = myInteger.toString();
				controlGame.setChoise(s);
				btnResetChoise.setEnabled(false);
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
		setAvailableFigs(availableFigures);
		setAvailableFields(availableFields);
		setTmpCase(tmpCase);
		setSpieler(curPlayer);
		setGegenspieler(opPlayer);
		updateGuiView();
	}
	
	private void updateGuiView() {
		resetField();
		if(getSpieler().get(0).getColor() == 'w') {
			setIconWhite(getSpieler());
			setIconBlack(getGegenspieler());
		} else {
			setIconWhite(getGegenspieler());
			setIconBlack(getSpieler());
		}
        switch (this.tmpCase) {
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