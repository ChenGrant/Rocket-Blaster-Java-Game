import java.awt.*;

import javax.swing.ImageIcon;

public class Rocks {
	Image img;
	double imgW;
	double imgH;
	double maxW;
	double maxH;
	double x;
	double y;
	double dx;

	Rocks(int maxW, int maxH) {
		img = new ImageIcon("src\\rocks.png").getImage();
		imgW = 50;
		imgH = 50;
		this.maxH = maxH;
		this.maxW = maxW;
		x = maxW;
		y = randomY(maxH);
		dx = randomDX();
	}

	public void move() {
		x += dx;
		if (x < 0) {
			reset();
		}
	}
	public void reset() {
		x = maxW-imgW;
		dx = randomDX();
		y = randomY((int) maxH);
	}
	public double randomY(int maxH) {
		double y = (maxH - imgH - 50) * Math.random();
		return y;

	}

	public double randomDX() {
		dx = -(3 * Math.random() + 4);
		return dx;
	}
	public Rectangle bounds() {
		return (new Rectangle ((int)x, (int)y, (int)imgW, (int)imgH));
	}
}
