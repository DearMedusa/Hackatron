import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenetre{

	/*
	* Classe qui creer une fenetre JFrame lui donne un nom et une taille
	*definit sa couleur d'arriere plan
	*creer un objet map
	*afficher dans la fenetre, lobjet map cree
	*/

	public Fenetre() {

		JFrame frame = new JFrame("Carte du Réseau");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Map map = new Map();
		map.setPreferredSize(new Dimension(600,480));
		map.setBackground(Color.black);

		frame.setContentPane(map);;
		frame.pack();
		frame.setVisible(true);
	}
}
