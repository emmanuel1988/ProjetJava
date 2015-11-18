package drawing;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe abstraite de type forme dessinable.
 */
public abstract class Shape {
	
	protected Point origin;
	private static final int INCREMENT = 8;
	private static final int D_HEIGHT = 500;
	int y = D_HEIGHT;
	boolean draw = false;
	boolean down = false;
	int randomDelayedStart;
	public Shape()
	{
		this.randomDelayedStart=randomDelayedStart;
	}
	
	public void setOrigin(Point p)
	{
		origin = p;
	}
	public void move() {
        if (draw) {
            if (y <= 50) {
                down = true;
            }

            if (down) {
                y += INCREMENT;
            } else {
                y -= INCREMENT;
            }
        }
    }
	public void decreaseDelay() {
        if (randomDelayedStart <= 0) {
            draw = true;
        } else {
            randomDelayedStart -= 1;
        }
    }
	
	/**
	 * dessine la forme sur un Graphics
	 */
	public abstract void paint(Graphics g);
	
	/**
	 * renvoie true si la forme occupe sur le point donnŽ
	 */
	public abstract boolean isOn(Point p);
}
