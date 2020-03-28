import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class Map extends JPanel {

	/*
	 * Description de la classe
	 */

	public void paintComponent(Graphics g) {
		Random random = new Random();
		super.paintComponent(g);
		int h = getHeight() - 50;
		int w = getWidth() - 50;

		// créer un cercle par serveur et affiche son nom
		for (int i = 0; i < GenerationServeurs.getTabServer().length; i++) {
			
			int coordXCercle = random.nextInt(w);//coordonnees aleatoire
			int coordYCercle = random.nextInt(h);
			int lastServX = coordXCercle;
			int lastServY = coordYCercle;
			
			if (GenerationServeurs.getTabServer()[i].hasAntivirus()) {//si le serveur a un antivirus
				g.setColor(Color.red);//l'afficher en rouge
				
			} else if (GenerationServeurs.getTabServer()[i] == Player.getCurrentServ()) {
				g.setColor(Color.blue);//s'il s'agit du serveur du joueur le mettre en bleu
				
			} else if (GenerationServeurs.getTabServer()[i] == Player.getLastServer()) {
				 lastServX = coordXCercle;
				 lastServY = coordYCercle;
				 
			} else {
				g.setColor(Color.green);
			}
			g.drawOval(coordXCercle, coordYCercle, 50, 50);
			g.drawLine(coordXCercle, coordYCercle, lastServX, lastServY);
			g.drawString(GenerationServeurs.getTabServer()[i].getName(), coordXCercle, coordYCercle);
			
		}

	}

}
