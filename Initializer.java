public class Initializer {

  /**
	* Description de la classe
	*/

  /**
  * Constructeur
  */
  public Initializer(){}

  /**
  * Méthodes
  */

  /**
  *deux boucles for generant chacune un nombre i de serveurs et fait appel aux methodes de choix de contenu aleatoires provenant de la classe Server
  *@param difficulty : peut être 1, 2 ou 3, defini le nombre total de serveurs a generer
  *@param multiplier et @param multiplier2 : servent a augmenter ou diminuer (selon le niveau de difficulte) le nombre de serveurs et de connexions
  *@return l'attribut tableaudeserveur contenant tous les serveurs du jeu
  */
  public static Server[] GenerationServeurs(int difficulty)
  {
    double multiplier = 0; //multiplier de generateurs

    //regle les valeurs des multipliers en fonction du niveau de difficulte passe en parametre
    switch (difficulty) {
      case 1 :
        multiplier = 0.75;
        break;
      case 2 :
        multiplier = 1;
        break;
      case 3 :
        multiplier = 1.75;
        break;
    }

    int nombredeserveurs = (int)(Random.getRandomInt(5, 45) * multiplier); //Genere un nombre de serveurs compris entre 5 et 45(inclus) multiplie par le double de la difficulte
    int nbrservavecAntivirus = (int)(Random.getRandomInt(5, 15) * multiplier); //Genere des serveurs avec antivirus dans un intervalle compris entre 5 et 15(inclus) multiplie par le double de la difficulte

    int nbrtotal = nombredeserveurs + nbrservavecAntivirus;
    Server[] tableaudeserveur = new Server[nbrtotal]; //creation du tableau de serveurs a remplir

    // génère des serveurs sans Antivirus
    for (int i = 0 ; i < nombredeserveurs ; i++ ) {
      String Nom = "Serveur" + i; //genere le nom du serveur
      tableaudeserveur[i] = new Server(Nom, Generateur.TabNomFichiers());
    }

    //génère des serveurs avec Antivirus
    for ( int i = nombredeserveurs; i < nbrtotal ; i++ ) {
      String Nom = "Serveur" + i; //genere le nom du serveur
      int niveauantivirus = (int)Random.getRandomInt(1, 10); //genere un niveau d'antivirus compris entre 1 et 10
      tableaudeserveur[i] = new Server(Nom, Generateur.TabNomFichiers(), Generateur.NomAntiV(), niveauantivirus);
    }

    //cree les connexions entre les Serveurs
    for (int i = 0 ; i < tableaudeserveur.length ; i++ ) {
      int nbr = Random.getRandomInt(1, 10); //genere un nombre au hasard dans un intervalle donne (a definir)
      //ce nombre sert a determiner le nombre de serveurs connectes au serveur i de la premiere boucle

      Server tmp[] = new Server[nbr]; //tableau de serveurs qui seront connectes au premier serveur i selectionne

      for ( int j = 0 ; j < nbr ; j++ ) {
        int serv = Random.getRandomInt(0, tableaudeserveur.length);//selectionne un serveur au hasard
        tmp[j] = tableaudeserveur[serv]; //l'ajoute dans le tableau
      }
      tableaudeserveur[i].setVoisins(tmp); //cree une connexion entre le premier serveur selectionne et le tableau de serveurs cree
    }

    //retourne le tableau de serveurs (avec et sans antivirus) final
    return tableaudeserveur;
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

  /**Affiche la difficulte a selectionner*/
  public static void SetDifficulte()
  {
    System.out.println("Veuillez choisir un niveau de difficulte :");
    System.out.println("1 : facile");
    System.out.println("2 : normal");
    System.out.println("3 : difficile");
  }

  public static void ConseilDebut()
  {
    System.out.println("Tout d'abord, tapez quelques commandes, comme ifconfig ou map pour connaitre votre position.");
  }

  /**affiche le texte de sortie du jeu*/
  public static void QuitGame()
  {
    System.out.println("Fermeture de votre session Hackatron...");
  }

}
