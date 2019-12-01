import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameInput extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon("ClearBackground(input).png").getImage();
	
	private ImageIcon inputImage = new ImageIcon("inputImage.png");
	private JButton Input = new JButton(inputImage);
	
	private ImageIcon quitImage = new ImageIcon("quitButton.jpg");
	private JButton quitButton = new JButton(quitImage);
	
	private ImageIcon backImage = new ImageIcon("backImage.png");
	private JButton backButton = new JButton(backImage);
	
	private JLabel Title = new JLabel();
	private JLabel Title1 = new JLabel();
	private JLabel Title2 = new JLabel();

	private JTextField Naming = new JTextField();

	public NameInput(int Time)
	{
		setUndecorated(true);
		setTitle("Escape");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
			
		Title.setText(Integer.toString(Time));
		Title.setFont(new Font("Serif", Font.BOLD, 50));
		Title.setForeground(Color.WHITE);
		Title.setBounds(500, 180, 600, 60);
		Title.setVisible(true);
		
		add(Title);
		
		Title1.setText(" 초 만에");
		Title1.setFont(new Font("", Font.BOLD, 50));
		Title1.setForeground(Color.WHITE);
		Title1.setBounds(720, 180, 600, 60);
		Title1.setVisible(true);
		
		add(Title1);
		
		Title2.setText("탈출에 성공하셨습니다!");
		Title2.setFont(new Font("", Font.BOLD, 50));
		Title2.setForeground(Color.WHITE);
		Title2.setBounds(370, 270, 600, 60);
		Title2.setVisible(true);
		
		add(Title2);
		
		
		Naming.setBounds(500, 470, 300, 70);
		Naming.setFont(new Font("", Font.BOLD, 40));
		Naming.setVisible(true);
		
		add(Naming);
		
		
		Input.setBounds(540, 550, 220,73);
		Input.setVisible(true);
		Input.setBorderPainted(false);
		Input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Input.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Input.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				String Name= Naming.getText();
				try {
					new NameSave(Name,Time);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
				try {
					new Rank();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				}
			}
		});
		add(Input);
		
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
				new Intro();
				setVisible(false);
			}
		});
		add(backButton);
		
		new Quit(quitButton);
		add(quitButton);
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
