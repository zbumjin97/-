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

public class House4 extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("house4.jpg").getImage();
	
	private ImageIcon TPR = new ImageIcon("transparent.png");
	private JButton questionButton = new JButton(TPR);
	private JButton boxButton = new JButton(TPR);
	
	private ImageIcon arrowImage = new ImageIcon("arrowImage.jpg");
	private JLabel arrowHint = new JLabel(arrowImage);
	
	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);
	
	private JLabel countup = new JLabel();
	public int j;
	
	public House4(int k) {
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
						questionButton.setVisible(false);
						boxButton.setVisible(false);
						arrowHint.setVisible(false);
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
		
		questionButton.setBounds(955, 80, 140, 170);
		questionButton.setBorderPainted(false);
		questionButton.setContentAreaFilled(false);
		questionButton.setFocusPainted(false);
		questionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				questionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				questionButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new House4Question(j);
				setVisible(false);
			}
		});
		add(questionButton);
		
		boxButton.setBounds(490, 325, 65, 125);
		boxButton.setBorderPainted(false);
		boxButton.setContentAreaFilled(false);
		boxButton.setFocusPainted(false);
		arrowHint.setBounds(550, 200, 133, 335);
		arrowHint.setVisible(false);
		boxButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boxButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boxButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				arrowHint.setVisible(true);
				boxButton.setVisible(false);
				questionButton.setVisible(false);
			}
		});
		add(boxButton); add(arrowHint);
		
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
				else if(arrowHint.isVisible()) {
					arrowHint.setVisible(false);
					boxButton.setVisible(true);
					questionButton.setVisible(true);
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

