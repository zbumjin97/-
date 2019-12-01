import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Intro extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("introBackground(Title).jpg").getImage();

	private ImageIcon TPR = new ImageIcon("transparent.png");
	private JButton startButton = new JButton(TPR);
	private JButton enterButton = new JButton(TPR);
	
	private ImageIcon rankImage = new ImageIcon("rankImage.png");
	private JButton rankingButton = new JButton(rankImage);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);

	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);
	
	public Intro() {
		setUndecorated(true);
		setTitle("Escape");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		startButton.setBounds(492, 585, 300, 80);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				background = new ImageIcon("IntroBackground.png").getImage();
				enterButton.setVisible(true);
				backButton.setVisible(true);
				startButton.setVisible(false);
				rankingButton.setVisible(false);
			}
		});
		add(startButton);
		
		enterButton.setBounds(445, 570, 396, 66);
		enterButton.setBorderPainted(false);
		enterButton.setContentAreaFilled(false);
		enterButton.setFocusPainted(false);
		enterButton.setVisible(false);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				enterButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new MainRoom(0);
				setVisible(false);
			}
		});
		add(enterButton);
		
		rankingButton.setBounds(50, 580, 220, 90);
		rankingButton.setBorderPainted(false);
		rankingButton.setContentAreaFilled(false);
		rankingButton.setFocusPainted(false);
		rankingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rankingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Rank R = new Rank();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		add(rankingButton);
		
		new Quit(quitButton);
		add(quitButton);
		
		backButton.setBounds(20, 600, 125, 116);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setVisible(false);
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
				background = new ImageIcon("introBackground(Title).jpg").getImage();
				enterButton.setVisible(false);
				backButton.setVisible(false);
				startButton.setVisible(true);
				rankingButton.setVisible(true);
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
