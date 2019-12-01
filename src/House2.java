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

public class House2 extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("house2.jpg").getImage();
	
	private ImageIcon asciiImage = new ImageIcon("asciiImage.jpg");
	private JLabel asciiChart = new JLabel(asciiImage);
	
	private ImageIcon TPR = new ImageIcon("transparent.png");
	private JButton asciiButton = new JButton(TPR);
	
	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);
	
	private JLabel countup = new JLabel();
	public int j;
	
	public House2(int k) {
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
					j =i;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(i >= 6000) {
						background = new ImageIcon("failBackground.jpg").getImage();
						asciiButton.setVisible(false);
						asciiChart.setVisible(false);
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
		
		asciiButton.setBounds(620, 220, 70, 125);
		asciiChart.setBounds(400, 100, 499, 506);
		asciiButton.setBorderPainted(false);
		asciiButton.setContentAreaFilled(false);
		asciiButton.setFocusPainted(false);
		asciiChart.setVisible(false);
		asciiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				asciiButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				asciiButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				asciiChart.setVisible(true);
				asciiButton.setVisible(false);
			}
		});
		add(asciiButton);
		add(asciiChart);
		
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
				else if(asciiChart.isVisible()) {
					asciiChart.setVisible(false);
					asciiButton.setVisible(true);
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

