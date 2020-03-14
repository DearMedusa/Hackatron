import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Map extends JPanel {
	
	/*
	* Description de la classe
	*/

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.green);

		//for (int i = 0; i < tableaudeServeurs.length(); i++) {
		//	g.drawOval(i * 50, 50, 50, 50);
		//}
	}

}
