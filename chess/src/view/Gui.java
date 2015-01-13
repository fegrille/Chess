package view;

import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;

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

public class Gui extends JFrame {

	private JPanel contentPane;
	private ArrayList<List<JButton>> buttonList = new ArrayList<List<JButton>>();
	private JButton btnStartGame = new JButton("Start Game");
	private JButton btnCloseGame = new JButton("Close Game");
	private JButton button_1 = new JButton("");
	private JButton button_2 = new JButton("");
	private JButton button_3 = new JButton("");
	private JButton button_4 = new JButton("");
	private JButton button_5 = new JButton("");
	private JButton button_6 = new JButton("");
	private JButton button_7 = new JButton("");
	private JButton button_8 = new JButton("");
	private JButton button_9 = new JButton("");
	private JButton button_10 = new JButton("");
	private JButton button_11 = new JButton("");
	private JButton button_12 = new JButton("");
	private JButton button_13 = new JButton("");
	private JButton button_14 = new JButton("");
	private JButton button_15 = new JButton("");
	private JButton button_16 = new JButton("");
	private JButton button_17 = new JButton("");
	private JButton button_65 = new JButton("");
	private JButton button_18 = new JButton("");
	private JButton button_19 = new JButton("");
	private JButton button_20 = new JButton("");
	private JButton button_21 = new JButton("");
	private JButton button_22 = new JButton("");
	private JButton button_23 = new JButton("");
	private JButton button_24 = new JButton("");
	private JButton button_25 = new JButton("");
	private JButton button_26 = new JButton("");
	private JButton button_27 = new JButton("");
	private JButton button_28 = new JButton("");
	private JButton button_29 = new JButton("");
	private JButton button_30 = new JButton("");
	private JButton button_31 = new JButton("");
	private JButton button_32 = new JButton("");
	private JButton button_33 = new JButton("");
	private JButton button_34 = new JButton("");
	private JButton button_35 = new JButton("");
	private JButton button_36 = new JButton("");
	private JButton button_37 = new JButton("");
	private JButton button_38 = new JButton("");
	private JButton button_39 = new JButton("");
	private JButton button_40 = new JButton("");
	private JButton button_41 = new JButton("");
	private JButton button_42 = new JButton("");
	private JButton button_43 = new JButton("");
	private JButton button_44 = new JButton("");
	private JButton button_45 = new JButton("");
	private JButton button_46 = new JButton("");
	private JButton button_47 = new JButton("");
	private JButton button_48 = new JButton("");
	private JButton button_49 = new JButton("");
	private JButton button_50 = new JButton("");
	private JButton button_51 = new JButton("");
	private JButton button_52 = new JButton("");
	private JButton button_54 = new JButton("");
	private JButton button_55 = new JButton("");
	private JButton button_56 = new JButton("");
	private JButton button_57 = new JButton("");
	private JButton button_58 = new JButton("");
	private JButton button_59 = new JButton("");
	private JButton button_60 = new JButton("");
	private JButton button_61 = new JButton("");
	private JButton button_62 = new JButton("");
	private JButton button_63 = new JButton("");
	private JButton button_64 = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		
		
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableStartFields();
				btnStartGame.setEnabled(false);
			}

			private void enableStartFields() {
				Integer[] lines = {0,1};
				for(int i : lines) {
					enableButtons(i);
				}
			}

			private void enableButtons(int i) {
				for(int a = 0; a <buttonList.get(i).size(); a++) {
					buttonList.get(i).get(a).setEnabled(true);
				}
			}
		});
		
		btnStartGame.setBounds(525, 129, 87, 23);
	
		btnCloseGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCloseGame.setBounds(525, 228, 89, 23);
		contentPane.setLayout(null);
		contentPane.add(btnStartGame);
		contentPane.add(btnCloseGame);
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_1.setEnabled(false);
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(125, 306, 47, 41);
		button_1.setIcon(new ImageIcon(Gui.class.getResource("/images/L\u00E4ufer wei\u00DF.png")));
		contentPane.add(button_1);
		
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_2.setEnabled(false);
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.WHITE);
		button_2.setIcon(new ImageIcon(Gui.class.getResource("/images/Pferd wei\u00DF.png")));
		button_2.setBounds(79, 306, 47, 41);
		contentPane.add(button_2);
		
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_3.setEnabled(false);
		button_3.setBackground(Color.BLACK);
		button_3.setIcon(new ImageIcon(Gui.class.getResource("/images/Turm wei\u00DF.png")));
		button_3.setBounds(33, 306, 47, 41);
		contentPane.add(button_3);
		
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_4.setEnabled(false);
		button_4.setBackground(Color.BLACK);
		button_4.setIcon(new ImageIcon(Gui.class.getResource("/images/K\u00F6nig wei\u00DF.png")));
		button_4.setBounds(221, 305, 47, 42);
		contentPane.add(button_4);
		
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_5.setEnabled(false);
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(Color.WHITE);
		button_5.setIcon(new ImageIcon(Gui.class.getResource("/images/L\u00E4ufer wei\u00DF.png")));
		button_5.setBounds(266, 306, 47, 41);
		contentPane.add(button_5);
		
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_6.setEnabled(false);
		button_6.setBackground(Color.BLACK);
		button_6.setIcon(new ImageIcon(Gui.class.getResource("/images/Pferd wei\u00DF.png")));
		button_6.setBounds(310, 306, 47, 41);
		contentPane.add(button_6);
		
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_7.setEnabled(false);
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(Color.WHITE);
		button_7.setIcon(new ImageIcon(Gui.class.getResource("/images/Turm wei\u00DF.png")));
		button_7.setBounds(356, 306, 47, 41);
		contentPane.add(button_7);
		
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_8.setEnabled(false);
		button_8.setBackground(Color.BLACK);
		button_8.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_8.setBounds(356, 267, 47, 41);
		contentPane.add(button_8);
		
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_9.setEnabled(false);
		button_9.setBackground(Color.BLACK);
		button_9.setBounds(310, 147, 47, 41);
		contentPane.add(button_9);
		
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_10.setEnabled(false);
		button_10.setForeground(Color.BLACK);
		button_10.setBackground(Color.BLACK);
		button_10.setBounds(356, 186, 47, 41);
		contentPane.add(button_10);
		
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_11.setEnabled(false);
		button_11.setForeground(Color.WHITE);
		button_11.setBackground(Color.WHITE);
		button_11.setBounds(356, 147, 47, 41);
		contentPane.add(button_11);
		
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_12.setEnabled(false);
		button_12.setBackground(Color.BLACK);
		button_12.setBounds(356, 106, 47, 41);
		contentPane.add(button_12);
		
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_13.setEnabled(false);
		button_13.setForeground(Color.WHITE);
		button_13.setBackground(Color.WHITE);
		button_13.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_13.setBounds(356, 66, 47, 41);
		contentPane.add(button_13);
		
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_14.setEnabled(false);
		button_14.setIcon(new ImageIcon(Gui.class.getResource("/images/Turm schwarz.png")));
		button_14.setForeground(Color.BLACK);
		button_14.setBackground(Color.BLACK);
		button_14.setBounds(356, 27, 47, 41);
		contentPane.add(button_14);
		
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_15.setEnabled(false);
		button_15.setBackground(Color.WHITE);
		button_15.setForeground(Color.WHITE);
		button_15.setBounds(356, 227, 47, 41);
		contentPane.add(button_15);
		
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_16.setEnabled(false);
		button_16.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_16.setBackground(Color.BLACK);
		button_16.setBounds(310, 66, 47, 41);
		contentPane.add(button_16);
		
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_17.setEnabled(false);
		button_17.setBackground(Color.BLACK);
		button_17.setBounds(33, 147, 47, 41);
		contentPane.add(button_17);
		
		button_65.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_65.setEnabled(false);
		button_65.setForeground(Color.WHITE);
		button_65.setBackground(Color.WHITE);
		button_65.setBounds(79, 147, 47, 41);
		contentPane.add(button_65);
		
		button_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_18.setEnabled(false);
		button_18.setBackground(Color.BLACK);
		button_18.setBounds(125, 147, 47, 41);
		contentPane.add(button_18);
		
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_19.setEnabled(false);
		button_19.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_19.setBackground(Color.BLACK);
		button_19.setBounds(266, 267, 47, 41);
		contentPane.add(button_19);
		
		button_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_20.setEnabled(false);
		button_20.setForeground(Color.WHITE);
		button_20.setBackground(Color.WHITE);
		button_20.setBounds(266, 147, 47, 41);
		contentPane.add(button_20);
		
		button_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_21.setEnabled(false);
		button_21.setForeground(Color.WHITE);
		button_21.setBackground(Color.WHITE);
		button_21.setBounds(33, 186, 47, 41);
		contentPane.add(button_21);
		
		button_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_22.setEnabled(false);
		button_22.setForeground(Color.BLACK);
		button_22.setBackground(Color.BLACK);
		button_22.setBounds(79, 186, 47, 41);
		contentPane.add(button_22);
		
		button_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_23.setEnabled(false);
		button_23.setForeground(Color.WHITE);
		button_23.setBackground(Color.WHITE);
		button_23.setBounds(125, 186, 47, 41);
		contentPane.add(button_23);
		
		button_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_24.setEnabled(false);
		button_24.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_24.setBackground(Color.BLACK);
		button_24.setBounds(221, 66, 47, 41);
		contentPane.add(button_24);
		
		button_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_25.setEnabled(false);
		button_25.setForeground(Color.WHITE);
		button_25.setBackground(Color.WHITE);
		button_25.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_25.setBounds(266, 66, 47, 41);
		contentPane.add(button_25);
		
		button_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_26.setEnabled(false);
		button_26.setForeground(Color.WHITE);
		button_26.setBackground(Color.WHITE);
		button_26.setBounds(310, 186, 47, 41);
		contentPane.add(button_26);
		
		button_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_27.setEnabled(false);
		button_27.setIcon(new ImageIcon(Gui.class.getResource("/images/Pferd schwarz.png")));
		button_27.setBackground(Color.WHITE);
		button_27.setBounds(310, 27, 47, 41);
		contentPane.add(button_27);
		
		button_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_28.setEnabled(false);
		button_28.setForeground(Color.WHITE);
		button_28.setBackground(Color.WHITE);
		button_28.setBounds(310, 106, 47, 46);
		contentPane.add(button_28);
		
		button_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_29.setEnabled(false);
		button_29.setBackground(Color.BLACK);
		button_29.setBounds(79, 106, 47, 41);
		contentPane.add(button_29);
		
		button_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_30.setEnabled(false);
		button_30.setBackground(Color.BLACK);
		button_30.setBounds(172, 106, 47, 41);
		contentPane.add(button_30);
		
		button_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_31.setEnabled(false);
		button_31.setForeground(Color.WHITE);
		button_31.setBackground(Color.WHITE);
		button_31.setBounds(125, 106, 47, 41);
		contentPane.add(button_31);
		
		button_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_32.setEnabled(false);
		button_32.setIcon(new ImageIcon(Gui.class.getResource("/images/K\u00F6nigin schwarz.png")));
		button_32.setBackground(Color.BLACK);
		button_32.setBounds(172, 27, 47, 41);
		contentPane.add(button_32);
		
		button_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_33.setEnabled(false);
		button_33.setForeground(Color.WHITE);
		button_33.setBackground(Color.WHITE);
		button_33.setIcon(new ImageIcon(Gui.class.getResource("/images/L\u00E4ufer s.png")));
		button_33.setBounds(125, 27, 47, 41);
		contentPane.add(button_33);
		
		button_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_34.setEnabled(false);
		button_34.setIcon(new ImageIcon(Gui.class.getResource("/images/Pferd schwarz.png")));
		button_34.setBackground(Color.BLACK);
		button_34.setBounds(79, 27, 47, 41);
		contentPane.add(button_34);
		
		button_35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_35.setEnabled(false);
		button_35.setForeground(Color.WHITE);
		button_35.setBackground(Color.WHITE);
		button_35.setIcon(new ImageIcon(Gui.class.getResource("/images/Turm schwarz.png")));
		button_35.setBounds(33, 27, 47, 41);
		contentPane.add(button_35);
		
		button_36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_36.setEnabled(false);
		button_36.setForeground(Color.WHITE);
		button_36.setBackground(Color.WHITE);
		button_36.setBounds(172, 306, 47, 41);
		button_36.setIcon(new ImageIcon(Gui.class.getResource("/images/K\u00F6nigin wei\u00DF.png")));
		contentPane.add(button_36);	
		
		button_37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_37.setEnabled(false);
		button_37.setForeground(Color.BLACK);
		button_37.setBackground(Color.BLACK);
		button_37.setBounds(172, 186, 47, 41);
		contentPane.add(button_37);
		
		button_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_38.setEnabled(false);
		button_38.setBackground(Color.BLACK);
		button_38.setBounds(266, 106, 47, 41);
		contentPane.add(button_38);
		
		button_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_39.setEnabled(false);
		button_39.setForeground(Color.WHITE);
		button_39.setBackground(Color.WHITE);
		button_39.setIcon(new ImageIcon(Gui.class.getResource("/images/K\u00F6nig s.png")));
		button_39.setBounds(221, 27, 47, 41);
		contentPane.add(button_39);
		
		button_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_40.setEnabled(false);
		button_40.setIcon(new ImageIcon(Gui.class.getResource("/images/L\u00E4ufer s.png")));
		button_40.setForeground(Color.BLACK);
		button_40.setBackground(Color.BLACK);
		button_40.setBounds(266, 27, 47, 41);
		contentPane.add(button_40);
		
		button_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_41.setEnabled(false);
		button_41.setForeground(Color.WHITE);
		button_41.setBackground(Color.WHITE);
		button_41.setBounds(172, 147, 47, 41);
		contentPane.add(button_41);
		
		button_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_42.setEnabled(false);
		button_42.setBackground(Color.BLACK);
		button_42.setForeground(Color.BLACK);
		button_42.setBounds(221, 147, 47, 41);
		contentPane.add(button_42);
		
		button_43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_43.setEnabled(false);
		button_43.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_43.setBackground(Color.BLACK);
		button_43.setBounds(33, 66, 47, 41);
		contentPane.add(button_43);
		
		button_44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_44.setEnabled(false);
		button_44.setForeground(Color.WHITE);
		button_44.setBackground(Color.WHITE);
		button_44.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_44.setBounds(79, 66, 47, 41);
		contentPane.add(button_44);
	    
		button_45.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_45.setEnabled(false);
		button_45.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_45.setBackground(Color.BLACK);
		button_45.setBounds(125, 66, 47, 41);
		contentPane.add(button_45);
		
		button_46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_46.setEnabled(false);
		button_46.setForeground(Color.WHITE);
		button_46.setBackground(Color.WHITE);
		button_46.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer schwarz.png")));
		button_46.setBounds(172, 66, 47, 41);
		contentPane.add(button_46);
		
		button_47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_47.setEnabled(false);
		button_47.setForeground(Color.BLACK);
		button_47.setBackground(Color.BLACK);
		button_47.setBounds(125, 227, 47, 41);
		contentPane.add(button_47);
		
		button_48.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_48.setEnabled(false);
		button_48.setForeground(Color.WHITE);
		button_48.setBackground(Color.WHITE);
		button_48.setBounds(79, 227, 47, 41);
		contentPane.add(button_48);
		
		button_49.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_49.setEnabled(false);
		button_49.setForeground(Color.BLACK);
		button_49.setBackground(Color.BLACK);
		button_49.setBounds(33, 227, 47, 41);
		contentPane.add(button_49);
		
		button_50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_50.setEnabled(false);
		button_50.setForeground(Color.BLACK);
		button_50.setBackground(Color.BLACK);
		button_50.setBounds(266, 186, 47, 41);
		contentPane.add(button_50);
		
		button_51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_51.setEnabled(false);
		button_51.setForeground(Color.WHITE);
		button_51.setBackground(Color.WHITE);
		button_51.setBounds(33, 106, 47, 41);
		contentPane.add(button_51);
		
		button_52.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_52.setEnabled(false);
		button_52.setForeground(Color.WHITE);
		button_52.setBackground(Color.WHITE);
		button_52.setBounds(221, 186, 47, 41);
		contentPane.add(button_52);
		
		button_54.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_54.setEnabled(false);
		button_54.setForeground(Color.WHITE);
		button_54.setBackground(Color.WHITE);
		button_54.setBounds(221, 106, 47, 41);
		contentPane.add(button_54);
		
		button_55.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_55.setEnabled(false);
		button_55.setForeground(Color.WHITE);
		button_55.setBackground(Color.WHITE);
		button_55.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_55.setBounds(310, 267, 47, 41);
		contentPane.add(button_55);
		
		
		button_56.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_56.setEnabled(false);
		button_56.setForeground(Color.BLACK);
		button_56.setBackground(Color.BLACK);
		button_56.setBounds(310, 227, 47, 41);
		contentPane.add(button_56);
		
		
		button_57.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_57.setEnabled(false);
		button_57.setForeground(Color.WHITE);
		button_57.setBackground(Color.WHITE);
		button_57.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_57.setBounds(221, 267, 47, 41);
		contentPane.add(button_57);
		
		
		button_58.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_58.setEnabled(false);
		button_58.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_58.setForeground(Color.BLACK);
		button_58.setBackground(Color.BLACK);
		button_58.setBounds(172, 267, 47, 41);
		contentPane.add(button_58);
		
		
		button_59.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_59.setEnabled(false);
		button_59.setForeground(Color.WHITE);
		button_59.setBackground(Color.WHITE);
		button_59.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_59.setBounds(125, 267, 47, 41);
		contentPane.add(button_59);
		
		
		button_60.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_60.setEnabled(false);
		button_60.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_60.setForeground(Color.BLACK);
		button_60.setBackground(Color.BLACK);
		button_60.setBounds(79, 267, 47, 41);
		contentPane.add(button_60);
		
		
		button_61.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_61.setEnabled(false);
		button_61.setForeground(Color.WHITE);
		button_61.setBackground(Color.WHITE);
		button_61.setIcon(new ImageIcon(Gui.class.getResource("/images/Bauer w.png")));
		button_61.setBounds(33, 267, 47, 41);
		contentPane.add(button_61);
		
		
		button_62.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_62.setEnabled(false);
		button_62.setForeground(Color.WHITE);
		button_62.setBackground(Color.WHITE);
		button_62.setBounds(266, 227, 47, 41);
		contentPane.add(button_62);
		
		
		button_63.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_63.setEnabled(false);
		button_63.setForeground(Color.BLACK);
		button_63.setBackground(Color.BLACK);
		button_63.setBounds(221, 227, 47, 41);
		contentPane.add(button_63);
		
		button_64.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_64.setEnabled(false);
		button_64.setForeground(Color.WHITE);
		button_64.setBackground(Color.WHITE);
		button_64.setBounds(172, 227, 47, 41);
		contentPane.add(button_64);
		
		for(int i = 0; i < 8; i++) {
			this.buttonList.add(new ArrayList<JButton>());
		}
		
		buttonList.get(0).add(button_3);
		buttonList.get(0).add(button_2);
		buttonList.get(0).add(button_1);
		buttonList.get(0).add(button_36);
		buttonList.get(0).add(button_4);
		buttonList.get(0).add(button_5);
		buttonList.get(0).add(button_6);
		buttonList.get(0).add(button_7);
		
		buttonList.get(1).add(button_61);
		buttonList.get(1).add(button_60);
		buttonList.get(1).add(button_59);
		buttonList.get(1).add(button_58);
		buttonList.get(1).add(button_57);
		buttonList.get(1).add(button_19);
		buttonList.get(1).add(button_55);
		buttonList.get(1).add(button_8);
		
		buttonList.get(2).add(button_49);
		buttonList.get(2).add(button_48);
		buttonList.get(2).add(button_47);
		buttonList.get(2).add(button_64);
		buttonList.get(2).add(button_63);
		buttonList.get(2).add(button_62);
		buttonList.get(2).add(button_56);
		buttonList.get(2).add(button_10);
	
		buttonList.get(3).add(button_21);
		buttonList.get(3).add(button_22);
		buttonList.get(3).add(button_23);
		buttonList.get(3).add(button_37);
		buttonList.get(3).add(button_52);
		buttonList.get(3).add(button_50);
		buttonList.get(3).add(button_26);
		buttonList.get(3).add(button_15);
		
		buttonList.get(4).add(button_17);
		buttonList.get(4).add(button_65);
		buttonList.get(4).add(button_18);
		buttonList.get(4).add(button_41);
		buttonList.get(4).add(button_42);
		buttonList.get(4).add(button_20);
		buttonList.get(4).add(button_9);
		buttonList.get(4).add(button_11);
		
		buttonList.get(5).add(button_51);
		buttonList.get(5).add(button_29);
		buttonList.get(5).add(button_31);
		buttonList.get(5).add(button_30);
		buttonList.get(5).add(button_54);
		buttonList.get(5).add(button_38);
		buttonList.get(5).add(button_28);
		buttonList.get(5).add(button_12);
		
		buttonList.get(6).add(button_43);
		buttonList.get(6).add(button_44);
		buttonList.get(6).add(button_45);
		buttonList.get(6).add(button_46);
		buttonList.get(6).add(button_24);
		buttonList.get(6).add(button_25);
		buttonList.get(6).add(button_16);
		buttonList.get(6).add(button_13);
		
		buttonList.get(7).add(button_35);
		buttonList.get(7).add(button_34);
		buttonList.get(7).add(button_33);
		buttonList.get(7).add(button_32);
		buttonList.get(7).add(button_39);
		buttonList.get(7).add(button_40);
		buttonList.get(7).add(button_27);
		buttonList.get(7).add(button_14);
		
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
	}
}