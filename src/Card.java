import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Card {
	
	boolean flipped = false;
	boolean removed = false;
	Color color;
	int x;
	int y;
	int width = 100;
	int height = 100;
	
	public Card(int xcoord, int ycoord, Color c) {
		x = xcoord;
		y = ycoord;
		color = c;
	}
	
	public boolean contains(int mousex, int mousey) {
		if (mousex < x || mousey < y || mousex > x + width || mousey > y + height) 
			return false;
		return true;
	}
	
	public void flip() {
		if(!removed)
			flipped = !flipped;
	}
	
	public void remove() {
		removed = !removed;
	}
	
	public void draw(Graphics g) {
		if(removed) {
			g.setColor(Color.gray);
		} else if(!flipped) {
			g.setColor(Color.white);
		}else {
			g.setColor(color);
		}
		
		g.fillRect(x, y, width, height);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
		
}
