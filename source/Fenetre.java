package source;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenetre{

	/*
	* Classe qui creer une fenetre JFrame lui donne un nom et une taille
	*definit sa couleur d'arriere plan
	*creer un objet map
	*afficher dans la fenetre, l objet map cree
	*/

	public Fenetre() {

		JFrame frame = new JFrame("Carte du Reseau");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Map map = new Map();
		map.setPreferredSize(new Dimension(825,605));
		map.setBackground(Color.black);
		frame.setResizable(false);
		frame.setContentPane(map);;
		frame.pack();
		frame.setVisible(true);
	}
}
