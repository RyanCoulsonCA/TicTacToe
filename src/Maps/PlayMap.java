package Maps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import main.BoardComponent;
import main.CustomButton;

public class PlayMap extends Map {
	
	private ArrayList<CustomButton> buttons;
	private ArrayList<BoardComponent> components;
	private int turn;
	
	public PlayMap(MapHandler m) {
		super(m);
		
		this.buttons = new ArrayList<CustomButton>();
		this.components = new ArrayList<BoardComponent>();
		this.turn = 0; // 0 = X; 1 = O
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				BoardComponent bc = new BoardComponent(50 + 100*i, 100 + 100*j, 100, 100);
				this.components.add(bc);
			}
		}
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

		for(BoardComponent bc: this.components) {
			bc.draw(g);
		}
		
		g.setFont(font);
		g.setColor(color);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < this.components.size(); i++) {
			if(this.components.get(i).wasClicked(e)) {
				if(this.components.get(i).getValue().equals("n")) {
					if(this.turn == 0) {
						this.components.get(i).setValue("X");
						this.turn = 1;
					} else {
						this.components.get(i).setValue("O");
						this.turn = 0;
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(int i = 0; i < this.components.size(); i++) {
			if(this.components.get(i).wasClicked(e)) {
				this.components.get(i).setHover(true);
			} else {
				this.components.get(i).setHover(false);
			}
		}
	}
}
