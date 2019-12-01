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

public class Final extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("final.jpg").getImage();
	
	private ImageIcon TPR = new ImageIcon("transparent.png");
	private JButton arrowButton1 = new JButton(TPR);
	private JButton arrowButton2 = new JButton(TPR);
	private JButton arrowButton3 = new JButton(TPR);
	
	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);
	
	private ImageIcon Image0 = new ImageIcon("0.jpg"); private ImageIcon Image1 = new ImageIcon("1.png");
	private ImageIcon Image2 = new ImageIcon("2.png"); private ImageIcon Image3 = new ImageIcon("3.png");
	private ImageIcon Image4 = new ImageIcon("4.png"); private ImageIcon Image5 = new ImageIcon("5.png");
	private ImageIcon Image6 = new ImageIcon("6.png"); private ImageIcon Image7 = new ImageIcon("7.png");
	private ImageIcon Image8 = new ImageIcon("8.png"); private ImageIcon Image9 = new ImageIcon("9.png");

	private JLabel lb0_0 = new JLabel(Image0); private JLabel lb0_1 = new JLabel(Image1); private JLabel lb0_2 = new JLabel(Image2);
	private JLabel lb0_3 = new JLabel(Image3); private JLabel lb0_4 = new JLabel(Image4); private JLabel lb0_5 = new JLabel(Image5);
	private JLabel lb0_6 = new JLabel(Image6); private JLabel lb0_7 = new JLabel(Image7); private JLabel lb0_8 = new JLabel(Image8);
	private JLabel lb0_9 = new JLabel(Image9);
	
	private JLabel lb1_0 = new JLabel(Image0); private JLabel lb1_1 = new JLabel(Image1); private JLabel lb1_2 = new JLabel(Image2);
	private JLabel lb1_3 = new JLabel(Image3); private JLabel lb1_4 = new JLabel(Image4); private JLabel lb1_5 = new JLabel(Image5);
	private JLabel lb1_6 = new JLabel(Image6); private JLabel lb1_7 = new JLabel(Image7); private JLabel lb1_8 = new JLabel(Image8);
	private JLabel lb1_9 = new JLabel(Image9);
	
	private JLabel lb2_0 = new JLabel(Image0); private JLabel lb2_1 = new JLabel(Image1); private JLabel lb2_2 = new JLabel(Image2);
	private JLabel lb2_3 = new JLabel(Image3); private JLabel lb2_4 = new JLabel(Image4); private JLabel lb2_5 = new JLabel(Image5);
	private JLabel lb2_6 = new JLabel(Image6); private JLabel lb2_7 = new JLabel(Image7); private JLabel lb2_8 = new JLabel(Image8);
	private JLabel lb2_9 = new JLabel(Image9);
	
	private JLabel countup = new JLabel();
	private int num = 0;
	public int j;
		
	public Final(int k) {			
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
						arrowButton1.setVisible(false);arrowButton2.setVisible(false);arrowButton3.setVisible(false);
						lb0_0.setVisible(false); lb0_1.setVisible(false); lb0_2.setVisible(false); lb0_3.setVisible(false); lb0_4.setVisible(false);
						lb0_5.setVisible(false); lb0_6.setVisible(false); lb0_7.setVisible(false); lb0_8.setVisible(false); lb0_9.setVisible(false);
						lb1_0.setVisible(false); lb1_1.setVisible(false); lb1_2.setVisible(false); lb1_3.setVisible(false); lb1_4.setVisible(false);
						lb1_5.setVisible(false); lb1_6.setVisible(false); lb1_7.setVisible(false); lb1_8.setVisible(false); lb1_9.setVisible(false);
						lb2_0.setVisible(false); lb2_1.setVisible(false); lb2_2.setVisible(false); lb2_3.setVisible(false); lb2_4.setVisible(false);
						lb2_5.setVisible(false); lb2_6.setVisible(false); lb2_7.setVisible(false); lb2_8.setVisible(false); lb2_9.setVisible(false);
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
		
		arrowButton1.setBounds(450, 405, 95, 90);
		lb0_0.setBounds(475, 417, 62, 69); lb0_0.setVisible(true);
		lb0_1.setBounds(475, 417, 62, 69); lb0_1.setVisible(false);
		lb0_2.setBounds(475, 417, 62, 69); lb0_2.setVisible(false);
		lb0_3.setBounds(475, 417, 62, 69); lb0_3.setVisible(false);
		lb0_4.setBounds(475, 417, 62, 69); lb0_4.setVisible(false);
		lb0_5.setBounds(475, 417, 62, 69); lb0_5.setVisible(false);
		lb0_6.setBounds(475, 417, 62, 69); lb0_6.setVisible(false);
		lb0_7.setBounds(475, 417, 62, 69); lb0_7.setVisible(false);
		lb0_8.setBounds(475, 417, 62, 69); lb0_8.setVisible(false);
		lb0_9.setBounds(475, 417, 62, 69); lb0_9.setVisible(false);
		arrowButton1.setBorderPainted(false);
		arrowButton1.setContentAreaFilled(false);
		arrowButton1.setFocusPainted(false);
		arrowButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				arrowButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				arrowButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb0_1.isVisible())		{ lb0_1.setVisible(false); lb0_2.setVisible(true); }
				else if (lb0_2.isVisible())	{ lb0_2.setVisible(false); lb0_3.setVisible(true); }
				else if (lb0_3.isVisible())	{ lb0_3.setVisible(false); lb0_4.setVisible(true); num++; 
												if(num == 3) {new NameInput(j/20); setVisible(false);}}
				else if (lb0_4.isVisible())	{ lb0_4.setVisible(false); lb0_5.setVisible(true); num--; }
				else if (lb0_5.isVisible())	{ lb0_5.setVisible(false); lb0_6.setVisible(true); }
				else if (lb0_6.isVisible())	{ lb0_6.setVisible(false); lb0_7.setVisible(true); }
				else if (lb0_7.isVisible())	{ lb0_7.setVisible(false); lb0_8.setVisible(true); }
				else if (lb0_8.isVisible())	{ lb0_8.setVisible(false); lb0_9.setVisible(true); }
				else if (lb0_9.isVisible())	{ lb0_9.setVisible(false); lb0_0.setVisible(true); }
				else						{ lb0_0.setVisible(false); lb0_1.setVisible(true); }
			}
		});
		add(arrowButton1); add(lb0_0); add(lb0_1); add(lb0_2); add(lb0_3); add(lb0_4); add(lb0_5); add(lb0_6); add(lb0_7); add(lb0_8); add(lb0_9);
		
		arrowButton2.setBounds(555, 405, 105, 90);
		lb1_0.setBounds(588, 417, 62, 69); lb1_0.setVisible(true);
		lb1_1.setBounds(588, 417, 62, 69); lb1_1.setVisible(false);
		lb1_2.setBounds(588, 417, 62, 69); lb1_2.setVisible(false);
		lb1_3.setBounds(588, 417, 62, 69); lb1_3.setVisible(false);
		lb1_4.setBounds(588, 417, 62, 69); lb1_4.setVisible(false);
		lb1_5.setBounds(588, 417, 62, 69); lb1_5.setVisible(false);
		lb1_6.setBounds(588, 417, 62, 69); lb1_6.setVisible(false);
		lb1_7.setBounds(588, 417, 62, 69); lb1_7.setVisible(false);
		lb1_8.setBounds(588, 417, 62, 69); lb1_8.setVisible(false);
		lb1_9.setBounds(588, 417, 62, 69); lb1_9.setVisible(false);
		arrowButton2.setBorderPainted(false);
		arrowButton2.setContentAreaFilled(false);
		arrowButton2.setFocusPainted(false);
		arrowButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				arrowButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				arrowButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb1_1.isVisible())		{ lb1_1.setVisible(false); lb1_2.setVisible(true); }
				else if (lb1_2.isVisible())	{ lb1_2.setVisible(false); lb1_3.setVisible(true); }
				else if (lb1_3.isVisible())	{ lb1_3.setVisible(false); lb1_4.setVisible(true); }
				else if (lb1_4.isVisible())	{ lb1_4.setVisible(false); lb1_5.setVisible(true); }
				else if (lb1_5.isVisible())	{ lb1_5.setVisible(false); lb1_6.setVisible(true); }
				else if (lb1_6.isVisible())	{ lb1_6.setVisible(false); lb1_7.setVisible(true); }
				else if (lb1_7.isVisible())	{ lb1_7.setVisible(false); lb1_8.setVisible(true); num++; 
												if(num == 3) {new NameInput(j/20); setVisible(false);}}
				else if (lb1_8.isVisible())	{ lb1_8.setVisible(false); lb1_9.setVisible(true); num--; }
				else if (lb1_9.isVisible())	{ lb1_9.setVisible(false); lb1_0.setVisible(true); }
				else						{ lb1_0.setVisible(false); lb1_1.setVisible(true); }
			}
		});
		add(arrowButton2); add(lb1_0); add(lb1_1); add(lb1_2); add(lb1_3); add(lb1_4); add(lb1_5); add(lb1_6); add(lb1_7); add(lb1_8); add(lb1_9);
		
		arrowButton3.setBounds(670, 405, 95, 90);
		lb2_0.setBounds(697, 417, 62, 69); lb2_0.setVisible(true);
		lb2_1.setBounds(697, 417, 62, 69); lb2_1.setVisible(false);
		lb2_2.setBounds(697, 417, 62, 69); lb2_2.setVisible(false);
		lb2_3.setBounds(697, 417, 62, 69); lb2_3.setVisible(false);
		lb2_4.setBounds(697, 417, 62, 69); lb2_4.setVisible(false);
		lb2_5.setBounds(697, 417, 62, 69); lb2_5.setVisible(false);
		lb2_6.setBounds(697, 417, 62, 69); lb2_6.setVisible(false);
		lb2_7.setBounds(697, 417, 62, 69); lb2_7.setVisible(false);
		lb2_8.setBounds(697, 417, 62, 69); lb2_8.setVisible(false);
		lb2_9.setBounds(697, 417, 62, 69); lb2_9.setVisible(false);
		arrowButton3.setBorderPainted(false);
		arrowButton3.setContentAreaFilled(false);
		arrowButton3.setFocusPainted(false);
		arrowButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				arrowButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				arrowButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (lb2_1.isVisible())		{ lb2_1.setVisible(false); lb2_2.setVisible(true); }
				else if (lb2_2.isVisible())	{ lb2_2.setVisible(false); lb2_3.setVisible(true); }
				else if (lb2_3.isVisible())	{ lb2_3.setVisible(false); lb2_4.setVisible(true); }
				else if (lb2_4.isVisible())	{ lb2_4.setVisible(false); lb2_5.setVisible(true); num++; 
												if(num == 3) {new NameInput(j/20); setVisible(false);}}
				else if (lb2_5.isVisible())	{ lb2_5.setVisible(false); lb2_6.setVisible(true); num--; }
				else if (lb2_6.isVisible())	{ lb2_6.setVisible(false); lb2_7.setVisible(true); }
				else if (lb2_7.isVisible())	{ lb2_7.setVisible(false); lb2_8.setVisible(true); }
				else if (lb2_8.isVisible())	{ lb2_8.setVisible(false); lb2_9.setVisible(true); }
				else if (lb2_9.isVisible())	{ lb2_9.setVisible(false); lb2_0.setVisible(true); }
				else						{ lb2_0.setVisible(false); lb2_1.setVisible(true); }
			}
		});
		add(arrowButton3); add(lb2_0); add(lb2_1); add(lb2_2); add(lb2_3); add(lb2_4); add(lb2_5); add(lb2_6); add(lb2_7); add(lb2_8); add(lb2_9);
		
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
					new MainRoom(j);
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

