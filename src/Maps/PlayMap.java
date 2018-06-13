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
	private BoardComponent[][] components;
	private String turn;
	private ArrayList<BoardComponent> winners;
	private boolean win;
	
	public PlayMap(MapHandler m) {
		super(m);
		
		this.buttons = new ArrayList<CustomButton>();
		this.winners = new ArrayList<BoardComponent>();
		this.components = new BoardComponent[3][3];
		this.turn = "X"; // 0 = X; 1 = O
		this.win = false;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				BoardComponent bc = new BoardComponent(50 + 100*i, 100 + 100*j, 100, 100);
				this.components[i][j] = bc;
			}
		}
	}

	public boolean checkWin(int row, int column) {
		/*
		 * Given the coordinates of the last box clicked, check to see
		 * if the player has won.
		 * 
		 * NOTE: this is super messy, will possibly clean up later
		 */
		
		boolean win = false;
		int consecutive = 0;
		
		// Check rows
		for(int i = 0; i < 3; i++) {
			if(this.components[i][column].getValue().equals(this.turn)) {
				consecutive++;
				winners.add(this.components[i][column]);
			}
		}
				
		if(consecutive == 3) {
			this.win = true;
			return true;
		} else {
			consecutive = 0;
			winners = new ArrayList<BoardComponent>();
		}
		
		// Check columns
		for(int i = 0; i < 3; i++) {
			if(this.components[row][i].getValue().equals(this.turn)) {
				consecutive++;
				winners.add(this.components[row][i]);
			}
		}
				
		if(consecutive == 3) {
			this.win = true;
			return true;
		} else {
			consecutive = 0;
			winners = new ArrayList<BoardComponent>();
		}
		
		// Check top-left diagonal
		for(int i = 0; i < 3; i++) {
			if(this.components[i][i].getValue().equals(this.turn)) {
				consecutive++;
				winners.add(this.components[i][i]);
			}
		}
		
		if(consecutive == 3) {
			this.win = true;
			return true;
		} else {
			consecutive = 0;
			winners = new ArrayList<BoardComponent>();
		}
		
		// Check top-right diagonal
		for(int i = 0; i < 3; i++) {
			if(this.components[i][2-i].getValue().equals(this.turn)) {
				consecutive++;
				winners.add(this.components[i][2-i]);
			}
		}
		
		if(consecutive == 3) {
			this.win = true;
			return true;
		} else {
			consecutive = 0;
			winners = new ArrayList<BoardComponent>();
		}

		return false;
		
	}
	
	public void nextTurn() {
		if(this.turn.equals("X")) {
			this.turn = "O";
		} else {
			this.turn = "X";
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
		
		if(this.turn.equals("X")) {
			g.setColor(Color.ORANGE);
		} else {
			g.setColor(Color.RED);
		}
		
		g.setFont(new Font("Default", Font.PLAIN, 12));
		g.drawString(this.turn + "'s Turn", 175, 70);
		g.setColor(Color.WHITE);
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.components[i][j].draw(g);
			}
		}
		
		g.setFont(font);
		g.setColor(color);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.components[i][j].wasClicked(e) && !this.win) {
					if(this.components[i][j].getValue().equals("n")) {
						if(this.turn == "X") {
							this.components[i][j].setValue("X");
						} else {
							this.components[i][j].setValue("O");
						}
					}
					
					if(this.checkWin(i, j)) {
						for(BoardComponent bc: this.winners) {
							bc.setHighlight(true);
						}
					} else {
						this.nextTurn();
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
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.components[i][j].wasClicked(e)) {
					this.components[i][j].setHover(true);
				} else {
					this.components[i][j].setHover(false);
				}
			}
		}
	}
}
