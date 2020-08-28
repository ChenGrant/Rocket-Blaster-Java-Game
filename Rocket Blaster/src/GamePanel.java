import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener {
	Image bg = new ImageIcon("src\\background.png").getImage();
	Image health = new ImageIcon("src\\health.png").getImage();
	Image healthImg = new ImageIcon("src\\100.png").getImage();
	Image scoreImg = new ImageIcon("src\\score.png").getImage();
	Rocks r1;
	boolean rocketCollision = false;
	boolean left, right, up, down;
	int numOfRocks = 1;
	Rocket rocket;
	ArrayList<Laser> laser = new ArrayList<Laser>();
	ArrayList<Rocks> rocks = new ArrayList<Rocks>();
	int score = 0;
	int maxW;
	int maxH;

	GamePanel(int maxW, int maxH) {
		this.maxH = maxH;
		this.maxW = maxW;
		right = false;
		up = false;
		down = false;
		left = false;
		r1 = new Rocks(maxW, maxH);
		rocks.add(r1);
		rocket = new Rocket(maxW, maxH);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		collision();
		g.drawImage(bg, 0, 0, maxW, maxH, this);
		g.drawImage(health, 0, -30, 200, 150, this);
		if (rocket.health == 100) {
			g.drawImage(healthImg, 180, -30, 200, 150, this);
		}
		else if (rocket.health != 0) {
			g.drawImage(healthImg, 180, -25, 130, 135, this);
		}
		else {
			g.drawImage(healthImg, 180, -30, 130, 150, this);
		}
		g.drawImage(scoreImg, 0, 30, 170, 150, this);
		
		String str = score + "";
		String fileName = "src\\digits\\";
		int x = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Image digit = new ImageIcon(fileName + c + ".png").getImage();
			g.drawImage(digit, 150 + 50 * x, 45, 170, 110, this);
			x++;
		}

		for (int i = 0; i < laser.size(); i++) {
			if (laser.get(i).show) {
				if (rocket.alive)
					laser.get(i).move();
				if (laser.get(i).show)
					g.drawImage(laser.get(i).img, (int) laser.get(i).x, (int) laser.get(i).y, (int) laser.get(i).imgW,
							(int) laser.get(i).imgH, this);
			}

		}
		
		for (int i = 0; i < numOfRocks; i++) {

			if (rocket.alive) {
				rocks.get(i).move();
			}

			g.drawImage(rocks.get(i).img, (int) rocks.get(i).x, (int) rocks.get(i).y, (int) rocks.get(i).imgW,
					(int) rocks.get(i).imgH, this);
		}
		
		if (rocket.alive) {
			rocket.move();
			if (left)
				rocket.dx=-3;
			if (right)
				rocket.dx=3;
			if (up)
				rocket.dy=-3;
			if (down)
				rocket.dy=3;
			
			if (!left&&!right)
				rocket.dx=0;
			if (!up&&!down)
				rocket.dy=0;
		}
		g.drawImage(rocket.img, (int) rocket.x, (int) rocket.y, (int) rocket.imgW, (int) rocket.imgH, this);
		repaint();

	}

	public void createRock() {
		numOfRocks++;
		Rocks r = new Rocks(maxW, maxH);
		rocks.add(r);
	}

	public void collision() {
		Rectangle r1 = rocket.bounds();
		ArrayList<Rectangle> rockBounds = new ArrayList<Rectangle>();
		ArrayList<Rectangle> laserBounds = new ArrayList<Rectangle>();
		for (int i = 0; i < numOfRocks; i++) {
			rockBounds.add(rocks.get(i).bounds());
			if (rockBounds.get(i).intersects(r1)) {
				rocket.health = rocket.health - 20;
				healthImg = new ImageIcon("src\\" + rocket.health + ".png").getImage();
				if (rocket.health == 0) {
					rocket.alive = false;
				}
				rocks.get(i).reset();
			}
		}
		boolean break2 = false;
		for (int i = 0; i < laser.size(); i++) {
			laserBounds.add(laser.get(i).bounds());
			for (int z = 0; z < numOfRocks; z++) {
				if (laserBounds.get(i).intersects(rockBounds.get(z)) && laser.get(i).show) {
					score++;
					if (score % 5 == 0) {
						createRock();
					}
					rocks.get(z).reset();
					laser.remove(i);
					laserBounds.remove(i);
					break2 = true;
					break;
				}
			}
			if (break2)
				break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (rocket.alive) {
			switch (key) {
				case KeyEvent.VK_LEFT: {
					left = true;
					break;
				}
				case KeyEvent.VK_RIGHT: {
					right = true;
					break;
				}
				case KeyEvent.VK_DOWN: {
					down = true;
					break;
				}
				case KeyEvent.VK_UP: {
					up = true;
					break;
				}
				case KeyEvent.VK_SPACE: {
					Laser l = new Laser((int) rocket.x, (int) rocket.imgW, (int) rocket.y, (int) rocket.imgH, maxW);
					laser.add(l);
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_LEFT: {
				left = false;
				break;
			}
			case KeyEvent.VK_RIGHT: {
				right = false;
				break;
			}
			case KeyEvent.VK_DOWN: {
				down = false;
				break;
			}
			case KeyEvent.VK_UP: {
				System.out.print("hi");
				up = false;
				break;
			}
			case KeyEvent.VK_SPACE: {
				Laser l = new Laser((int) rocket.x, (int) rocket.imgW, (int) rocket.y, (int) rocket.imgH, maxW);
				laser.add(l);
			}
		}
	}

}
