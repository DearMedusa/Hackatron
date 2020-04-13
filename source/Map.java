package source;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class Map extends JPanel {

	/*
	 * Classe qui gere l'affichage du reseau apres execution de la commande "map"
	 */

	public void paintComponent(Graphics g) {
		Random random = new Random();
		super.paintComponent(g);
		int h = getHeight() - 70;
		int w = getWidth() - 70;

		// créer un cercle par serveur et affiche son nom
		for (int i = 0; i < GenerationServeurs.getTabServer().size(); i++) {

			int coordXCercle = random.nextInt(w);//coordonnees aleatoires
			int coordYCercle = random.nextInt(h);
			int lastServX,currentServX = 0;
			int lastServY,currentServY = 0;

			if (GenerationServeurs.getTabServer().get(i).hasAntivirus()) {//si le serveur a un antivirus
				g.setColor(Color.red);//l'afficher en rouge

			} else if (GenerationServeurs.getTabServer().get(i) == Player.getCurrentServ()) {
				g.setColor(Color.blue);//s'il s'agit du serveur du joueur le mettre en bleu
				currentServX = coordXCercle;
				currentServY = coordYCercle;

			} else if (GenerationServeurs.getTabServer().get(i) == Player.getLastServer()) {
				 lastServX = coordXCercle;
				 lastServY = coordYCercle;
				 g.drawLine(currentServX, currentServY, lastServX, lastServY);

			} else {
				g.setColor(Color.green);
			}
			g.drawOval(coordXCercle, coordYCercle, 50, 50);
			g.drawString(GenerationServeurs.getTabServer().get(i).getName(), coordXCercle, coordYCercle);











		}

	}

}