package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class BoardComponent {

	private int xpos, ypos, width, height;
	private String value;
	private boolean hover, highlight;
	
	public BoardComponent(int x, int y) {
		this.xpos = x;
		this.ypos = y;
		this.width = this.height = 100;
		this.value = "n";
	}
	
	public BoardComponent(int x, int y, int w, int h) {
		this.xpos = x;
		this.ypos = y;
		this.width = w;
		this.height = h;
		this.value = "n";
	}
	
	public void setValue(String s) {
		/*
		 * Set the component's value to the given character.
		 * Typically would be X or O. 'n' means not set.
		 */
		this.value = s;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setHover(boolean b) {
		this.hover = b;
	}
	
	public void setHighlight(boolean b) {
		this.highlight = b;
	}
	
	public boolean wasClicked(MouseEvent me) {
		if(this.xpos <= me.getX() && me.getX() <= (this.xpos+width)) {
			if(this.ypos <= me.getY() && me.getY() <= (this.ypos+height)) {
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics2D g) {
		Font f = g.getFont();
		Color c = g.getColor();
		
		g.setFont(new Font("Default", Font.PLAIN, 48));
		FontMetrics fm = g.getFontMetrics();
				
		if(this.hover&&this.value.equals("n")) {
			g.setColor(new Color(50,50,50));
		} else {
			g.setColor(new Color(38,38,38));
		}
		
		g.fillRect(xpos+1, ypos+1, width-2, height-2);
		
		if(this.value.equals("X")) {
			g.setColor(Color.ORANGE);
		} else if(this.value.equals("O")) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.WHITE);
		}
		
		if(!this.value.equals("n")) {
			g.drawString(this.value, this.xpos + (width - fm.stringWidth(this.value))/2, this.ypos+height/2 + 20);
		}
		
		if(this.highlight) {
			g.setColor(Color.YELLOW);
			g.drawRect(xpos+1, ypos+1, width-2, height-2);
		}
		
		g.setFont(f);
		g.setColor(c);
	}
}
