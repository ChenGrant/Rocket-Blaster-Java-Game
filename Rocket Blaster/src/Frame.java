import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu menu;
	JMenuItem m1, m2,m3,m4;
	int maxW = 1400;
	int maxH = 730;
	static int panelNum = 1;
	GamePanel gp;
	int gameSkin = 1;
	WelcomePanel wp;
	Exit exit;
	InstructionsPanel ip;
	Container c = getContentPane();

	Frame() {
		super("Rocket Blaster");
		exit = new Exit(maxW, maxH);
		ip = new InstructionsPanel(maxW, maxH);
		gp = new GamePanel(maxW, maxH);
		wp = new WelcomePanel(maxW, maxH-50);
		wp.setSize(maxW, maxH);
		
		c.setLayout(null);
		c.setBackground(Color.blue);
		c.add(wp);
		setUpMenu(panelNum);
	}
	
	public void setUpMenu(int panelNum1) {
		this.setJMenuBar(null);
		mb = new JMenuBar();
		menu = new JMenu("Menu");
		m1 = new JMenuItem("Welcome Screen");
		m2 = new JMenuItem("Settings and Instructions");
		m3 = new JMenuItem("Game Screen");
		m4 = new JMenuItem("Exit");
		
		if (panelNum1!=1) {
			menu.add(m1);
			m1.addActionListener(this);
		}
		
		if (panelNum1!=2) {
			menu.add(m2);
			m2.addActionListener(this);
		}
		
		if (panelNum1!=3) {
			menu.add(m3);
			m3.addActionListener(this);
		}
		
		if (panelNum1!=4) {
			menu.add(m4);
			m4.addActionListener(this);
		}
		
		mb.add(menu);
		this.setJMenuBar(mb);
		this.setSize(maxW, maxH);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent f) {
		if (f.getSource()==m1 || f.getSource()==exit.lol) {
			panelNum=1;
			c.removeAll();
			wp = new WelcomePanel(maxW, maxH-50);
			wp.setSize(maxW, maxH);
			c.add(wp);
			setUpMenu(panelNum);
		}
		
		if (f.getSource()==m2) {
			panelNum=2;
			c.removeAll();
			ip.setSize(maxW, maxH);
			ip.b1.addActionListener(ip);
			ip.b2.addActionListener(ip);
			ip.b3.addActionListener(ip);
			ip.b1.setFocusable(false); 
			ip.b2.setFocusable(false);
			ip.b3.setFocusable(false);
			c.add(ip);
			setUpMenu(panelNum);
			
		}
		
		if (f.getSource()==m3) {
			panelNum=3;
			c.removeAll();
			gp = new GamePanel(maxW, maxH);
			gp.rocket.imageIcon(ip.skin);
			gp.setSize(maxW, maxH);
			gp.setFocusable(true);
			gp.requestFocusInWindow();
			addKeyListener(gp);
			c.add(gp);
			setUpMenu(panelNum);
		}
		
		if (f.getSource()==m4) {
			panelNum = 4;
			c.removeAll();
			exit.setSize(maxW,maxH);
			exit.exit.addActionListener(exit);
			exit.lol.addActionListener(this);
			exit.exit.setFocusable(false);
			exit.lol.setFocusable(false);
			c.add(exit);
			setUpMenu(panelNum);
		}

	}
}
