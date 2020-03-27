import java.util.*;

public class GenerationAffichage {

  /**
	* Description de la classe
	*/

  /**
  * Constructeur
  */
  public GenerationAffichage(){}

  /**
  * Méthodes
  */

  /**Affiche le logo du jeu*/
  public static void Logo()
  {
    System.out.println("  _    _          _____ _  __       _______ _____   ____  _   _ \r\n"
    + " | |  | |   /\\   / ____| |/ /    /\\|__   __|  __ \\ / __ \\| \\ | |\r\n"
    + " | |__| |  /  \\ | |    | ' /    /  \\  | |  | |__) | |  | |  \\| |\r\n"
    + " |  __  | / /\\ \\| |    |  <    / /\\ \\ | |  |  _  /| |  | | . ` |\r\n"
    + " | |  | |/ ____ \\ |____| . \\  / ____ \\| |  | | \\ \\| |__| | |\\  |\r\n"
    + " |_|  |_/_/    \\_\\_____|_|\\_\\/_/    \\_\\_|  |_|  \\_\\\\____/|_| \\_|");
  }

  /**Affiche le texte d'introduction du jeu*/
  public static void Introduction()
  {
    System.out.println("Bienvenue sur Hackatron 3000, le meilleur logiciel de piratage connu");
		System.out.println("***********************************************************************");
		System.out.println(
						"Votre objectif est de telecharger Sudoku.java, vous savez que ce fichier est situe quelque part sur le reseau ");
		System.out.println("Utilisez les commandes donnees pour parcourir les serveurs et trouver le fichier");
		System.out.println("Faites attention, certains serveurs sont proteges par des antivirus");
		System.out.println("Tapez help pour obtenir des informations sur les commandes disponibles");
		System.out.println("***********************************************************************");
		System.out.print("Saisissez votre nom d'utilisateur: ");
  }

  /**Affiche le pseudo choisit par le joueur*/
  public static void NomUser()
  {
    System.out.println("Votre nom d'utilisateur a ete defini a: " + Player.getPseudo());
  }

  /**Affiche la difficulte a selectionner*/
  public static void SetDifficulte()
  {
    System.out.println("Veuillez choisir un niveau de difficulte :");
    System.out.println("1 : facile");
    System.out.println("2 : normal");
    System.out.println("3 : difficile");
  }

  /**affiche le texte de sortie du jeu*/
  public static void QuitGame()
  {
    System.out.println("Fermeture de votre session Hackatron...");
  }

  /** affichage de la commande download */
  public static void download()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Quel fichier voulez vous telecharger ?");
    String[] contenu = Player.getCurrentServ().getContent();
    for (int i = 0 ; i < contenu.length ; i++ ) { //parcours le tableau et affiche son contenu
      int n = i +1;
      System.out.println(n + " : " + contenu[i]);
    }

    int choix = sc.nextInt(); //recupere le choix de l'utilisateur

    if (choix >= 0 && choix <= contenu.length) { //l'int doit être compris dans l'intervalle donne [0;contenu.length], sinon
      System.out.println("Telechargement de :" + contenu[choix-1]);

      if(contenu[choix-1].equals("Sudoku.java")){ //condition de victoire
        System.out.println("Vous avez trouve le fichier, vous avez gagne. Bravo" + Player.getPseudo() + "!");
      }
      else { //en cas de fichier random osef
        System.out.println("Le fichier a bien ete telecharge.");
        if (Rng.getRng()){ //augmente le niveau du joueur en fonction de la rng
          System.out.println("Vous avez gagné 1 niveau de botnet suite a cette action");
          Player.increaselvl();
        }
      }
    }
    else { //on affiche un message d'erreur a l'utilisateur
      System.out.println("ERROR : ce fichier n'existe pas, veuillez reessayer");
    }
  }

  /*Affiche un semblant de temps de chargement*/
  public static void tempsdechargement()
  {
    System.out.println("Processing ...");
    System.out.print("[");
    for ( int i = 0 ; i < 15 ; i++ ) {
      System.out.print("=");
    }
    System.out.print("]\n");
    System.out.println("Done !");
  }

  /*Previent le joueur s'il est repere et lui donne son compteur de pv*/
  public static void msgRepere(){
    System.out.println("Vous avez ete repere !"); //Affichage a revoir
    Player.decreaselife();
    System.out.println("Il vous reste " + Player.getlife() + " tentatives");
  }

}
