import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Rocket {
	Image img;
	boolean alive;
	double imgW;
	double imgH;
	double x;
	double y;
	double dx;
	double dy;
	double maxW;
	double maxH;
	int health;
	Rocket(double maxW, double maxH) {
		imageIcon(1);
		this.maxH = maxH;
		this.maxW = maxW;
		imgW = 150;
		imgH = 100;
		x = 20;
		y = maxH / 2;
		dx = 0;
		dy = 0;
		health = 100;
		alive = true;
	}
	public void imageIcon(int n) {
		img = new ImageIcon("src\\"+n+".png").getImage();
	}
	public void move() {
		x += dx;
		if (x < 0) {
			x = 0;
		}
		if (x + imgW > maxW) {
			x = maxW - imgW;
		}
		y += dy;
		if (y < 0) {
			y = 0;
		}
		if (y + imgH +20> maxH) {
			y = maxH - imgH-20;
		}
	}
	public Rectangle bounds() {
		return (new Rectangle ((int)x, (int)y, (int)imgW, (int)imgH));
	}
}
