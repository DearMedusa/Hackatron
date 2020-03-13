import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenetre{
	
	public Fenetre() {
		
		JFrame frame = new JFrame("Carte du Réseau");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Map map = new Map();
		map.setPreferredSize(new Dimension(600,480));
		
		frame.setContentPane(map);;
		frame.pack();
		frame.setVisible(true);
	}
}
