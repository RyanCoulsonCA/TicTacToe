package Maps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import main.CustomButton;

public class MenuMap extends Map {
	
	private ArrayList<CustomButton> buttons;
	
	public MenuMap(MapHandler m) {
		super(m);
		
		this.buttons = new ArrayList<CustomButton>();
	}

	@Override
	public void draw(Graphics2D g) {
		this.buttons = new ArrayList<CustomButton>();
		
		Color color = g.getColor();
		Font font = g.getFont();
		
		g.setFont(new Font("Default", Font.BOLD, 32));
		g.setColor(new Color(35, 35, 35));
		g.fillRect(0, 0, 400, 500);
		
		g.setColor(Color.WHITE);
		g.drawString("Tic Tac Toe", 110, 50);
		
		CustomButton button = new CustomButton("Start", 100, 120, 200, 50);
		button.setColor(Color.GRAY);
		this.buttons.add(button);
		button.draw(g);
		
		button = new CustomButton("Multiplayer", 100, 200, 200, 50);
		button.setColor(Color.GRAY);
		this.buttons.add(button);
		button.draw(g);
		
		button = new CustomButton("Quit", 100, 280, 200, 50);
		button.setColor(Color.GRAY);
		this.buttons.add(button);
		button.draw(g);
		
		g.setFont(font);
		g.setColor(color);
	}
	
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < this.buttons.size(); i++) {
			CustomButton b = this.buttons.get(i);
			if(b.wasClicked(e)) {
				if(b.getText().equals("Quit")) {
					System.exit(0);
				}
			}
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

}
