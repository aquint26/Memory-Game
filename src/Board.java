import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static Card select1, select2;

	public static ArrayList<Card> cards = new ArrayList<Card>();
	public static Color[] colors = {Color.red, Color.red, Color.blue, Color.blue, Color.yellow,
			Color.yellow, Color.green, Color.green, Color.orange, Color.orange, Color.cyan,
			Color.cyan, Color.pink, Color.pink, Color.magenta, Color.magenta};
	
	public Board() {
		this.setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
		ArrayList<Color> c = new ArrayList<Color>(Arrays.asList(colors));
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cards.add(new Card(50 + 150 * i, 50 + 150 * j, c.remove((int)(Math.random() * c.size()))));
			}
		}
		this.addMouseListener(new Mouse());
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
		for (Card c : cards) {
			c.draw(g);
		}
	}
	
	public static void check() {
		if (select1 == null || select2 == null) {
			return;
		}
		
		if (select1.equals(select2)) {
			select1.remove();
			select2.remove();
		} else {
			select1.flip();
			select2.flip();
		}
		
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {}
		Window.repaint();
		
		select1 = null;
		select2 = null;
		
		boolean done = true;
		for (Card c : cards) {
			if (!c.removed)
				done = false;
		}
		if (done) System.exit(1);
	}
	
}
