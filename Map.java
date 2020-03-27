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
		int h = getHeight()-50;
		int w = getWidth()-50;
		
		//créer un cercle par serveur et affiche son nom
		for (int i = 0; i < GenerationServeurs.getTabServer().length; i++) {
			int coordXCercle = random.nextInt(w-30);
			int coordYCercle = random.nextInt(h-30);
			if (GenerationServeurs.getTabServer()[i].hasAntivirus()) {
				g.setColor(Color.red);
			}else if(GenerationServeurs.getTabServer()[i] ==Player.getCurrentServ()){
				g.setColor(Color.blue);
			}else {
				g.setColor(Color.green);
			}
			g.drawOval(coordXCercle, coordYCercle, 50,50);
			g.drawString(GenerationServeurs.getTabServer()[i].getName(),coordXCercle,coordYCercle);
			
			//parcours tous les voisins du serveur i
			for(int j = 0; j < GenerationServeurs.getTabServer()[i].getVoisins().length;j++) {
				g.drawLine(coordXCercle, coordYCercle, h/2, w/2);
			}
		}
		
		
	}

}
