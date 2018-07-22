package evolution;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Dnacomponent extends JComponent {
	private String text = "";
	private int gen;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setGen(int gen) {
		this.gen = gen;
	}
}
