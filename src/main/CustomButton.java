package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class CustomButton {

	private Color color;
	private Font font;
	private String text;
	private int width, height, xpos, ypos;
	
	public CustomButton(String s, int xpos, int ypos, int width, int height) {
		this.text = s;
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;
		
		this.font = new Font("Default", Font.BOLD, 24);
		this.color = Color.WHITE;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setFont(Font f) {
		this.font = f;
	}
	
	public Font getFont() {
		return this.font;
	}
			
	public boolean isHovering(MouseEvent me) {
		if(this.xpos <= me.getX() && me.getX() <= (this.xpos+width)) {
			if(this.ypos <= me.getY() && me.getY() <= (this.ypos+height)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean wasClicked(MouseEvent me) {
		if(this.xpos <= me.getX() && me.getX() <= (this.xpos+width)) {
			if(this.ypos <= me.getY() && me.getY() <= (this.ypos+height)) {
				return true;
			}
		}
		return false;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void draw(Graphics2D g) {
		Color color = g.getColor();
		Font font = g.getFont();
		Stroke stroke = g.getStroke();
				
		g.setColor(this.color);
		g.setFont(this.font);
		
		// Draw background
		g.fillRect(xpos, ypos, width, height);
		
		// Draw border
		g.setStroke(new BasicStroke(5));
		g.setColor(new Color(this.color.getRed()-30, this.color.getGreen()-30, this.color.getBlue()-30));
		g.drawRect(xpos, ypos, width, height);
		
		// Draw text
		g.drawString(this.text, xpos + width/2 - (text.length() * 6), this.ypos+(this.height/2)+8);
		
		g.setStroke(stroke);
		g.setColor(color);
		g.setFont(font);
	}
	
}
