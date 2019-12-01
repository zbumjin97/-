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

public class MainRoom extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("mainRoomImage.jpg").getImage();
	
	private ImageIcon TPR = new ImageIcon("transparent.png");
	private JButton door1 = new JButton(TPR);
	private JButton door2 = new JButton(TPR);
	private JButton door3 = new JButton(TPR);
	private JButton lock = new JButton(TPR);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);
	
	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);

	private JLabel countup = new JLabel();
	public int j;

	public MainRoom(int k) {
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
						backButton.setVisible(true);
						door1.setVisible(false); door2.setVisible(false); door3.setVisible(false);
						lock.setVisible(false);
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
		
		door1.setBounds(380, 0, 120, 180);
		door1.setBorderPainted(false);
		door1.setContentAreaFilled(false);
		door1.setFocusPainted(false);
		door1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				door1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				door1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new House2(j);
				setVisible(false);
			}
		});
		add(door1);
		
		door2.setBounds(595, 0, 120, 180);
		door2.setBorderPainted(false);
		door2.setContentAreaFilled(false);
		door2.setFocusPainted(false);
		door2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				door2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				door2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new House3(j);
				setVisible(false);
			}
		});
		add(door2);
		
		door3.setBounds(790, 0, 120, 180);
		door3.setBorderPainted(false);
		door3.setContentAreaFilled(false);
		door3.setFocusPainted(false);
		door3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				door3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				door3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new House4(j);
				setVisible(false);
			}
		});
		add(door3);
		
		lock.setBounds(880, 430, 15, 20);
		lock.setBorderPainted(false);
		lock.setContentAreaFilled(false);
		lock.setFocusPainted(false);
		lock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lock.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lock.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new Final(j);
				setVisible(false);
			}
		});
		add(lock);
		
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
				new Intro();
				setVisible(false);
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
