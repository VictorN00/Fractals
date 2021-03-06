import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JuliaRunner extends JFrame {
	
	private static final long serialVersionUID = -1313598947673000176L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;

	public JuliaRunner() {
		super("Julia Set");
		setBackground(Color.BLACK);
		setSize(WIDTH + 15, HEIGHT + 39);
		Julia julia = new Julia(WIDTH, HEIGHT, -.016, .828, 100);
		add(julia);
		KeyAdapter key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int k = -1;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					dispose(); break;
				case KeyEvent.VK_W:
					k = 0; break;
				case KeyEvent.VK_A:
					k = 1; break;
				case KeyEvent.VK_S:
					k = 2; break;
				case KeyEvent.VK_D:
					k = 3; break;
				}
				if (k != -1)
					julia.move(k);
			}
		};
		addKeyListener(key);
		validate();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JuliaRunner();
	}
	
}
