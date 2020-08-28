import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Exit extends JPanel implements ActionListener{
	Image background = new ImageIcon("src\\background.png").getImage();
	JButton exit, lol;
	int maxW, maxH;
	Exit(int W, int H){
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setPreferredSize(new Dimension(800, 100));
		lol = new JButton("Home");
		lol.addActionListener(this);
		lol.setPreferredSize(new Dimension(800, 100));
		maxW = W;
		maxH =H;
		this.add(exit);
		this.add(lol);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0,0,maxW, maxH, this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==exit) {
			System.exit(1);
		}
	}

}
