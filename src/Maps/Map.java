package Maps;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Map implements MouseListener, MouseMotionListener {

	protected MapHandler map;
	
	public Map(MapHandler m) {
		this.map = m;
	}
	
	public abstract void draw(Graphics2D g);
	
}
