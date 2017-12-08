import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		for (Card c : Board.cards) {
			if (c.contains(x, y)) {
				if (!c.flipped && !c.removed) {
					c.flip();
					Window.repaint();
					Board.select2 = Board.select1;
					Board.select1 = c;
					Board.check();
					return;
				}
			}
		}
	}
	
}
