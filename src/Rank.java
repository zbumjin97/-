import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rank extends JFrame {
	
	File f = new File("Clear.txt");

	private String [] Rankname=new String[8];
	private int [] Ranktime	= new int[8];

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);

	private JLabel Ranking1 = new JLabel();
	private JLabel Ranking2 = new JLabel();
	private JLabel Ranking3 = new JLabel();
	private JLabel Ranking4 = new JLabel();
	private JLabel Ranking5 = new JLabel();
	private JLabel Ranking6 = new JLabel();
	private JLabel Ranking7 = new JLabel();
	
	private JLabel Ranking11 = new JLabel();
	private JLabel Ranking22 = new JLabel();
	private JLabel Ranking33 = new JLabel();
	private JLabel Ranking44 = new JLabel();
	private JLabel Ranking55 = new JLabel();
	private JLabel Ranking66 = new JLabel();
	private JLabel Ranking77 = new JLabel();

	private Image background = new ImageIcon("ClearBackground(Rank).png").getImage();

	public Rank()  throws Exception {
		setUndecorated(true);
		setTitle("Escape");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		Scanner input = new Scanner(f);
		
		int a=0;
		
		while(input.hasNext()) {
			
			String setname = input.next();
			int setsecond = input.nextInt();
			
			Rankname[a]= setname;
			Ranktime[a]	= setsecond;
			a++;
			
		}
		input.close();
		
		Ranking1.setText("1.st             "+Rankname[0]);
		Ranking1.setBounds(150, 150, 500, 60);
		Ranking1.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking1.setVisible(true);
		
		add(Ranking1);
		
		Ranking11.setText(Integer.toString(Ranktime[0])+"   段");
		Ranking11.setBounds(900, 150, 200, 60);
		Ranking11.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking11.setVisible(true);
		
		add(Ranking11);
		
		Ranking2.setText("2.nd            "+Rankname[1]);
		Ranking2.setBounds(150, 220, 500, 60);
		Ranking2.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking2.setVisible(true);
		
		add(Ranking2);
		
		Ranking22.setText(Integer.toString(Ranktime[1])+"   段");
		Ranking22.setBounds(900, 220, 200, 60);
		Ranking22.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking22.setVisible(true);
		
		add(Ranking22);
		
		Ranking3.setText("3.rd            "+Rankname[2]);
		Ranking3.setBounds(150, 290, 500, 60);
		Ranking3.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking3.setVisible(true);
		
		add(Ranking3);
		
		Ranking33.setText(Integer.toString(Ranktime[2])+"   段");
		Ranking33.setBounds(900, 290, 200, 60);
		Ranking33.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking33.setVisible(true);
		
		add(Ranking33);
		
		Ranking4.setText("4.th             "+Rankname[3]);
		Ranking4.setBounds(150, 360, 500, 60);
		Ranking4.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking4.setVisible(true);
	
		add(Ranking4);
		
		Ranking44.setText(Integer.toString(Ranktime[3])+"   段");
		Ranking44.setBounds(900, 360, 200, 60);
		Ranking44.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking44.setVisible(true);
		
		add(Ranking44);
		
		Ranking5.setText("5.th             "+Rankname[4]);
		Ranking5.setBounds(150, 430, 500, 60);
		Ranking5.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking5.setVisible(true);
	
		add(Ranking5);
		
		Ranking55.setText(Integer.toString(Ranktime[4])+"   段");
		Ranking55.setBounds(900, 430, 200, 60);
		Ranking55.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking55.setVisible(true);
		
		add(Ranking55);
		
		Ranking6.setText("6.th             "+Rankname[5]);
		Ranking6.setBounds(150,500, 500, 60);
		Ranking6.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking6.setVisible(true);
		
		add(Ranking6);
		
		Ranking66.setText(Integer.toString(Ranktime[5])+"   段");
		Ranking66.setBounds(900, 500, 200, 60);
		Ranking66.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking66.setVisible(true);
		
		add(Ranking66);
		
		Ranking7.setText("7.th             "+Rankname[6]);
		Ranking7.setBounds(150, 570, 500, 60);
		Ranking7.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking7.setVisible(true);
		
		add(Ranking7);
		
		Ranking77.setText(Integer.toString(Ranktime[6])+"   段");
		Ranking77.setBounds(900, 570, 200, 60);
		Ranking77.setFont(new Font("Serif", Font.BOLD, 55));
		Ranking77.setVisible(true);
		
		add(Ranking77);
		
		backButton.setBounds(50, 600, 125, 100);
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
				//System.exit(0);
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
