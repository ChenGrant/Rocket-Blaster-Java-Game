import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class InstructionsPanel extends JPanel implements ActionListener{
	Image img;
	int H;
	int W;
	int skin = 1;
	JButton b1,b2,b3;
	
	InstructionsPanel(int maxW, int maxH){
		H = maxH;
		W = maxW;
	    img = new ImageIcon("src\\background.png").getImage();
		b1 = new JButton(new ImageIcon("src\\1.png"));
		b1.setPreferredSize(new Dimension(100, 100));
		this.add(b1);
		
		b2 = new JButton(new ImageIcon("src\\2.png"));
		b2.setPreferredSize(new Dimension(100, 100));
		this.add(b2);
		
		b3 = new JButton(new ImageIcon("src\\3.png"));
		b3.setPreferredSize(new Dimension(100, 100));
		this.add(b3);
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0,0,W, H, this);
	}
	
	public void actionPerformed(ActionEvent g) {
		if (g.getSource()==b1) {
			skin = 1;
		}
		
		if (g.getSource()==b2) {
			skin = 2;
		}
		
		if (g.getSource()==b3) {
			skin = 3;
		}
		
	}
}
