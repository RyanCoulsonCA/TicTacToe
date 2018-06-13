package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Maps.MapHandler;

public class GamePanel extends JPanel implements MouseMotionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 500;
	public static final float VERSION = 0.1f;
	
	MapHandler map;
	
	public GamePanel() {
		super();
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		requestFocus();
		
		this.map = new MapHandler();
	}
	
	@Override
    public void paintComponent(Graphics g) {
    	System.out.println("paint");
    	Graphics2D g2 = (Graphics2D) g;
    	Font f = new Font("Default", Font.PLAIN, 14);
    	g.setFont(f);
    	g.setColor(Color.WHITE);

    	this.map.draw(g2);
    	g2.drawString("Current Version " + VERSION, 10,490);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		this.map.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.map.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.map.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.map.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.map.mouseReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.map.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.map.mouseMoved(e);
	}
	
	
}
