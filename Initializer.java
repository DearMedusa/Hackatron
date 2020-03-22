import java.util.*;

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
  *@param multiplier, @param multiplier2 et @param multiplier3: servent a augmenter ou diminuer (selon le niveau de difficulte) les attributs donnes
  *@return l'attribut tableaudeserveur contenant tous les serveurs du jeu
  */
  public static Server[] GenerationServeurs(int difficulty)
  {
    double multiplier = 0; //multiplier de serveurs
    double multiplier2 = 0; //multiplier de serveurs avec bitcoin
    double multiplier3 = 0; //multiplier de serveurs avec mots de passes

    //regle les valeurs des multipliers en fonction du niveau de difficulte passe en parametre
    switch (difficulty) {
      case 1 :
        multiplier = 0.75;
        multiplier2 = 1.25;
        multiplier3 = 0.75;
        break;
      case 2 :
        multiplier = 1;
        multiplier2 = 1;
        multiplier3 = 1;
        break;
      case 3 :
        multiplier = 1.75;
        multiplier2 = 0.75;
        multiplier3 = 1.75;
        break;
    }

    int nombredeserveurs = (int)(Random.getRandomInt(5, 45) * multiplier); //Genere un nombre de serveurs compris entre 5 et 45(inclus) multiplie par le double de la difficulte
    int nbrservavecAntivirus = (int)(Random.getRandomInt(5, 15) * multiplier); //Genere des serveurs avec antivirus dans un intervalle compris entre 5 et 15(inclus) multiplie par le double de la difficulte

    int nbrtotal = nombredeserveurs + nbrservavecAntivirus;
    Server[] tableaudeserveur = new Server[nbrtotal]; //creation du tableau de serveurs a remplir

    //**************************************************************************
    // génère des serveurs sans Antivirus
    for (int i = 0 ; i < nbrtotal ; i++ ) {
      String Nom = "serveur" + i; //genere le nom du serveur
      tableaudeserveur[i] = new Server(Nom, Generateur.NomUser() ,Generateur.TabNomFichiers());
    }

    //selectionne des serveurs au hasard et leur cree un antivirus de nom et niveau aleatoire
    for ( int i = 0; i < nbrservavecAntivirus ; i++ ) {
      int niveauantivirus = Random.getRandomInt(1, 10); //genere un niveau d'antivirus compris entre 1 et 10
      int serveuraleatoire = Random.getRandomInt(1, tableaudeserveur.length); //selectionne un serveur dans le tableau, excluant le serveur0
      tableaudeserveur[serveuraleatoire].creerAntivirus(Generateur.NomAntiV(), niveauantivirus);
    }

    //**************************************************************************
    //cree des serveurs qui possedent des bitcoins
    int nbrServAvecBitcoin = (int)(Random.getRandomInt(15, 40) * multiplier2); //entre 15 et 40 (exclu) * le multiplier possederont des bitcoins
    for (int i = 0; i < nbrServAvecBitcoin ; i++ ) {
      int numtmp = Random.getRandomInt(1, tableaudeserveur.length); //selectionne un serveur aleatoirement, en dehors du serveur0
      double tmpbitcoin = Generateur.Bitcoin();
      tableaudeserveur[numtmp].setbitcoin(tmpbitcoin);
    }

    //**************************************************************************
    //cree les connexions entre les Serveurs
    for (int i = 1 ; i < tableaudeserveur.length ; i++ ) {
      int nbr = Random.getRandomInt(1, 10); //genere un nombre au hasard dans un intervalle donne (a definir)
      //ce nombre sert a determiner le nombre de serveurs connectes au serveur i de la premiere boucle

      Server tmp[] = new Server[nbr]; //tableau de serveurs qui seront connectes au premier serveur i selectionne

      for ( int j = 0 ; j < nbr ; j++ ) {
        int serv = Random.getRandomInt(0, tableaudeserveur.length);//selectionne un serveur au hasard
        tmp[j] = tableaudeserveur[serv]; //l'ajoute dans le tableau
      }
      tableaudeserveur[i].setVoisins(tmp); //cree une connexion entre le premier serveur selectionne et le tableau de serveurs cree
    }

    //cas particulier pour serveur0 :
    //il est imperatif qu'il aie au moins 5 connexions (en esperant qu'aucun des 1ers serv n'a d'antivirus sinon impossible de jouer) mais pas trop non plus sinon c'est trop facile
    int nombredeconnexions = Random.getRandomInt(5, 10); //l'intervalle [5;9] me semble un bon compromis, independamment de la difficulte
    Server tmp2[] = new Server[nombredeconnexions + 1];//tableau de serveurs qui sera connecte au serveur0
    for (int i = 0 ; i <= nombredeconnexions ; i++ ) {
      int serv = Random.getRandomInt(0, tableaudeserveur.length);//selectionne un serveur au hasard
      tmp2[i] = tableaudeserveur[serv]; //l'ajoute dans le tableau
    }
    tableaudeserveur[0].setVoisins(tmp2); //cree une connexion entre serveur0 et le tableau de serveurs cree

    //**************************************************************************
    //cree des serveurs avec mots de passes
    int nombredeservAvecmdp = (int)(Random.getRandomInt(10, tableaudeserveur.length) * multiplier3);  //retourne un nombre aleatoire de serveurs entre 10 et la longueur du tableau

    //boucle for qui va creer un mot de passe pour un nombre donne (defini par nombredeservAvecmdp) de serveurs (qui seront selectionne aleatoirement)
    for (int i = 0; i < nombredeservAvecmdp ; i++ ) {
      int servAleatoire = Random.getRandomInt(1, tableaudeserveur.length); //selectionne un nombre entre 1 (serveur0 ne doit pas avoir de mdp) et la longueur du tableau
      tableaudeserveur[servAleatoire].setmdp(); //cree un mot de passe pour le serveur donne
    }

    //**************************************************************************
    //retourne le tableau de serveurs (avec et sans antivirus/mot de passe) final
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
        int chance = Random.getRandomInt(0, 11); //0 est inclus et 11 exclu, donc intervalle [0;10]
        if (chance == 3){ //augmente le niveau du joueur (1 chance sur 10)
          System.out.println("Vous avez gagné 1 niveau de botnet suite a cette action");
          Player.increaselvl();
        }
      }
    }
    else { //on affiche un message d'erreur a l'utilisateur
      System.out.println("ERROR : ce fichier n'existe pas, veuillez reessayer");
    }
  }

}
