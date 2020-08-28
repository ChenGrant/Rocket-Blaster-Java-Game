import java.awt.*;
import javax.swing.*;

public class WelcomePanel extends JPanel{
	Image img1;
	Image img2;
	int maxW;
	int maxH;
	WelcomePanel(int W, int H){
		img1 = new ImageIcon("src\\welcome.png").getImage();
		img2 = new ImageIcon("src\\welcomeBackground.png").getImage();
		maxW = W;
		maxH = H;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img2, 0,0,maxW,maxH,this);
		g.drawImage(img1, 0,0,maxW,maxH,this);
	}
	
}
