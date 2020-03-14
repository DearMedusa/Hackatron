public class Initializer {

  /*
	* Description de la classe
	*/

  /*
  * @param tableaudeServ Server est un tableau contenant tous les serveurs du jeu
  * @param difficulty int est un entier qui determine la frequence de serveurs proteges
  */
  private Server[] tableaudeServ;
  private int difficulty;

  /*
  * Constructeur privé
  */
  private Initializer(){}

  /*
  * Méthodes
  */

  /*
  *deux boucles for generant chacune un nombre i de serveurs et fait appel aux methodes de choix de contenu aleatoir provenant de la classe Server
  *@return l'attribut tableaudeserveur contenant tous les serveurs du jeu
  */
  public Server[] GenerationServeurs()
  {
    Server[] Serv = null;

    // génère des serveurs sans Antivirus
    for (int i = 0 ; i < 15 ; i++ ) {
      String Nom = "Serveur" + i + 1;
      Serv[i] = new Server(Nom, Generateur.TabNomFichiers());
    }

    //génère des serveurs avec Antivirus
    for ( int i = 15; i < 21 ; i++ ) {
      String Nom = "Serveur" + i + 1;
      Serv[i] = new Server(Nom, Generateur.TabNomFichiers(), Generateur.NomAntiV(), (i+1));
    }
    return Serv;
  }

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

  /**affiche le texte de sortie du jeu*/		
  public static void QuitGame()
  {
    System.out.println("Fermeture de votre session Hackatron...");
  }

}
