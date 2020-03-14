public class Initializer {

  /*
	* Description de la classe
	*/

  /*
  * Attributs
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
  *
  */
  public Server[] Serveurs()
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

    //retourne le tableau avec les serveurs créés
    return Serv;
  }

  public static void Logo()
  {
    System.out.println("  _    _          _____ _  __       _______ _____   ____  _   _ \r\n"
    + " | |  | |   /\\   / ____| |/ /    /\\|__   __|  __ \\ / __ \\| \\ | |\r\n"
    + " | |__| |  /  \\ | |    | ' /    /  \\  | |  | |__) | |  | |  \\| |\r\n"
    + " |  __  | / /\\ \\| |    |  <    / /\\ \\ | |  |  _  /| |  | | . ` |\r\n"
    + " | |  | |/ ____ \\ |____| . \\  / ____ \\| |  | | \\ \\| |__| | |\\  |\r\n"
    + " |_|  |_/_/    \\_\\_____|_|\\_\\/_/    \\_\\_|  |_|  \\_\\\\____/|_| \\_|");
  }

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

  public static void NomUser()
  {
    System.out.println("Votre nom d'utilisateur a ete defini a: " + Player.getPseudo());
  }

  public static void QuitGame()
  {
    System.out.println("Fermeture de votre session Hackatron...");
  }

}
