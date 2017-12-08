import java.awt.Graphics;

import javax.swing.JFrame;

public class Window {

public static final int HEIGHT = 650, WIDTH = 650;
	
	public static Board b = new Board();

	public Window() {
		JFrame frame = new JFrame("Memory Game");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(b);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void repaint() {
		Graphics g = b.getGraphics();
		b.paint(g);
	}
	
	public static void main(String[] args) {
		new Window();
	}
	
}
