import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Laser {
	Image img;
	int imgW;
	int imgH;
	int x;
	int y;
	int dx;
	int maxW;
	boolean show;

	Laser(int Rocketx, int RocketImageWidth, int Rockety, int RocketImageHeight, int W) {
		img = new ImageIcon("src\\laser.png").getImage();
		x = Rocketx + RocketImageWidth / 2;
		y = Rockety + RocketImageHeight / 3 - 10;
		maxW = W;
		show = true;
		imgW = 70;
		imgH = 60;

	}

	public void move() {
		x += dx;
		dx = 5;
		if (x + imgW > maxW)
			show = false;
	}
	public Rectangle bounds() {
		return (new Rectangle ((int)x, (int)y, (int)imgW, (int)imgH));
	}
}
