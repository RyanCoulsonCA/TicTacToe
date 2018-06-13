package Maps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class MenuMap extends Map {
	
	public MenuMap(MapHandler m) {
		super(m);
	}

	@Override
	public void draw(Graphics2D g) {
		Color color = g.getColor();
		Font font = g.getFont();
		
		g.setFont(new Font("Default", Font.BOLD, 32));
		g.setColor(new Color(50, 50, 50));
		g.fillRect(0, 0, 400, 500);
		
		g.setColor(Color.WHITE);
		g.drawString("Tic Tac Toe", 110, 50);
		
		g.setFont(font);
		g.setColor(color);
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

}
