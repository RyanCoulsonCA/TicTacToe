package Maps;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MapHandler {

	private ArrayList<Map> maps;
	private int state;
	
	// Map Codes
	public static final int MENU = 0;
	public static final int GAME = 1;
	public static final int WIN = 2;
	
	public MapHandler() {
		this.maps = new ArrayList<Map>();
		this.state = MENU;
		
		this.maps.add(new MenuMap(this));
	}
	
	public void draw(Graphics2D g) {
		this.maps.get(this.state).draw(g);
	}
	
	public void mouseClicked(MouseEvent me) {
		this.maps.get(this.state).mouseClicked(me);
	}

	public void mouseEntered(MouseEvent me) {
		this.maps.get(this.state).mouseEntered(me);
	}

	public void mouseExited(MouseEvent me) {
		this.maps.get(this.state).mouseExited(me);
	}

	public void mousePressed(MouseEvent me) {
		this.maps.get(this.state).mousePressed(me);
	}

	public void mouseReleased(MouseEvent me) {
		this.maps.get(this.state).mouseReleased(me);
	}
	
	public void mouseMoved(MouseEvent me) {
		this.maps.get(this.state).mouseMoved(me);
	}
	
	public void mouseDragged(MouseEvent me) {
		this.maps.get(this.state).mouseDragged(me);
	}
}
