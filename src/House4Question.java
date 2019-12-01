import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class House4Question extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("house4Question.jpg").getImage();
	
	private ImageIcon TPR = new ImageIcon("transparent.png");
	
	private ImageIcon answerImage = new ImageIcon("answerImage.jpg");
	private JLabel answer = new JLabel(answerImage);
	
	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);
	
	private ImageIcon rightImage = new ImageIcon("rightImage.jpg"); private ImageIcon upImage = new ImageIcon("upImage.jpg");
	private ImageIcon leftImage = new ImageIcon("leftImage.jpg"); private ImageIcon downImage = new ImageIcon("downImage.jpg");

	private JButton hint1 = new JButton(TPR); private JButton hint2 = new JButton(TPR);
	private JButton hint3 = new JButton(TPR); private JButton hint4 = new JButton(TPR);
	
	private JLabel lb1_1 = new JLabel(rightImage); private JLabel lb1_2 = new JLabel(upImage);
	private JLabel lb1_3 = new JLabel(leftImage); private JLabel lb1_4 = new JLabel(downImage);
	
	private JLabel lb2_1 = new JLabel(rightImage); private JLabel lb2_2 = new JLabel(upImage);
	private JLabel lb2_3 = new JLabel(leftImage); private JLabel lb2_4 = new JLabel(downImage);
	
	private JLabel lb3_1 = new JLabel(rightImage); private JLabel lb3_2 = new JLabel(upImage);
	private JLabel lb3_3 = new JLabel(leftImage); private JLabel lb3_4 = new JLabel(downImage);
	
	private JLabel lb4_1 = new JLabel(rightImage); private JLabel lb4_2 = new JLabel(upImage);
	private JLabel lb4_3 = new JLabel(leftImage); private JLabel lb4_4 = new JLabel(downImage);
	
	private JLabel countup = new JLabel();
	private int num = 0;
	public int j;
	
	void complete() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		lb1_2.setVisible(false); lb2_3.setVisible(false); lb3_1.setVisible(false); lb4_3.setVisible(false);
		hint1.setVisible(false); hint2.setVisible(false); hint3.setVisible(false); hint4.setVisible(false);
		answer.setVisible(true);
	}
	
	public House4Question(int k) {
		setUndecorated(true);
		setTitle("Escape");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		class MyThread extends Thread{
			public void run() {
				for(int i=k;i<1200000;i++) {
					countup.setText(String.format("%02d:%02d",((i/20)-(i/20)%60)/60,(i/20)%60));
					j=i;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(i >= 6000) {
						background = new ImageIcon("failBackground.jpg").getImage();
						hint1.setVisible(false);hint2.setVisible(false);hint3.setVisible(false);hint4.setVisible(false);
						lb1_1.setVisible(false);lb1_2.setVisible(false);lb1_3.setVisible(false);lb1_4.setVisible(false);
						lb2_1.setVisible(false);lb2_2.setVisible(false);lb2_3.setVisible(false);lb2_4.setVisible(false);
						lb3_1.setVisible(false);lb3_2.setVisible(false);lb3_3.setVisible(false);lb3_4.setVisible(false);
						lb4_1.setVisible(false);lb4_2.setVisible(false);lb4_3.setVisible(false);lb4_4.setVisible(false);
						countup.setVisible(false);
					}
				}
			}
		}
		
		countup.setSize(200,100);
		countup.setLocation(50,0);
		countup.setFont(new Font("serif",Font.ROMAN_BASELINE,50));
		countup.setForeground(Color.RED);
		add(countup);
		(new MyThread()).start();
		
		answer.setBounds(500, 200, 525, 307);
		answer.setVisible(false);
		
		hint1.setBounds(607, 270, 55, 50);
		lb1_1.setBounds(607, 270, 55, 60); lb1_1.setVisible(false);
		lb1_2.setBounds(607, 270, 54, 54); lb1_2.setVisible(false);
		lb1_3.setBounds(607, 270, 53, 61); lb1_3.setVisible(false);
		lb1_4.setBounds(607, 270, 59, 54); lb1_4.setVisible(false);
		hint1.setBorderPainted(false);
		hint1.setContentAreaFilled(false);
		hint1.setFocusPainted(false);
		hint1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hint1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hint1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb1_1.isVisible())		{ lb1_1.setVisible(false); lb1_2.setVisible(true); num++; 
												if(num == 4) complete();}
				else if (lb1_2.isVisible())	{ lb1_2.setVisible(false); lb1_3.setVisible(true); num--; }
				else if (lb1_3.isVisible())	{ lb1_3.setVisible(false); lb1_4.setVisible(true); }
				else						{ lb1_4.setVisible(false); lb1_1.setVisible(true); }
			}
		});
		add(hint1); add(lb1_1); add(lb1_2); add(lb1_3); add(lb1_4);
		
		hint2.setBounds(698, 282, 55, 50);
		lb2_1.setBounds(698, 282, 55, 60); lb2_1.setVisible(false);
		lb2_2.setBounds(698, 282, 54, 54); lb2_2.setVisible(false);
		lb2_3.setBounds(698, 282, 53, 61); lb2_3.setVisible(false);
		lb2_4.setBounds(698, 282, 59, 54); lb2_4.setVisible(false);
		hint2.setBorderPainted(false);
		hint2.setContentAreaFilled(false);
		hint2.setFocusPainted(false);
		hint2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hint2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hint2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb2_1.isVisible())		{ lb2_1.setVisible(false); lb2_2.setVisible(true); }
				else if (lb2_2.isVisible())	{ lb2_2.setVisible(false); lb2_3.setVisible(true); num++;  
												if(num == 4) complete();}
				else if (lb2_3.isVisible())	{ lb2_3.setVisible(false); lb2_4.setVisible(true); num--; }
				else						{ lb2_4.setVisible(false); lb2_1.setVisible(true); }
			}
		});
		add(hint2); add(lb2_1); add(lb2_2); add(lb2_3); add(lb2_4);
		
		hint3.setBounds(790, 290, 55, 50);
		lb3_1.setBounds(790, 290, 55, 60); lb3_1.setVisible(false);
		lb3_2.setBounds(790, 290, 54, 54); lb3_2.setVisible(false);
		lb3_3.setBounds(790, 290, 53, 61); lb3_3.setVisible(false);
		lb3_4.setBounds(790, 290, 59, 54); lb3_4.setVisible(false);
		hint3.setBorderPainted(false);
		hint3.setContentAreaFilled(false);
		hint3.setFocusPainted(false);
		hint3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hint3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hint3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb3_1.isVisible())		{ lb3_1.setVisible(false); lb3_2.setVisible(true); num--;}
				else if (lb3_2.isVisible())	{ lb3_2.setVisible(false); lb3_3.setVisible(true); }
				else if (lb3_3.isVisible())	{ lb3_3.setVisible(false); lb3_4.setVisible(true); }
				else						{ lb3_4.setVisible(false); lb3_1.setVisible(true); num++; 
												if(num == 4) complete();}
			}
		});
		add(hint3); add(lb3_1); add(lb3_2); add(lb3_3); add(lb3_4);
		
		hint4.setBounds(879, 300, 55, 50);
		lb4_1.setBounds(879, 300, 55, 60); lb4_1.setVisible(false);
		lb4_2.setBounds(879, 300, 54, 54); lb4_2.setVisible(false);
		lb4_3.setBounds(879, 300, 53, 61); lb4_3.setVisible(false);
		lb4_4.setBounds(879, 300, 59, 54); lb4_4.setVisible(false);
		hint4.setBorderPainted(false);
		hint4.setContentAreaFilled(false);
		hint4.setFocusPainted(false);
		hint4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hint4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hint4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb4_1.isVisible())		{ lb4_1.setVisible(false); lb4_2.setVisible(true); }
				else if (lb4_2.isVisible())	{ lb4_2.setVisible(false); lb4_3.setVisible(true); num++; 
												if(num == 4) complete();}
				else if (lb4_3.isVisible())	{ lb4_3.setVisible(false); lb4_4.setVisible(true); num--; }
				else						{ lb4_4.setVisible(false); lb4_1.setVisible(true); }
			}
		});
		add(hint4); add(lb4_1); add(lb4_2); add(lb4_3); add(lb4_4); add(answer);
		
		new Quit(quitButton);
		add(quitButton);

		backButton.setBounds(20, 600, 125, 116);
		backButton.setVisible(true);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(countup.isVisible() == false) {
					new Intro();
					setVisible(false);
				}
				else {
					new House4(j);
					setVisible(false);
				}
				
			}
		});
		add(backButton);
	}	
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}

