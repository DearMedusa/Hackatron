import java.util.*;

public class GenerationServeurs {
  /**
  * Classe qui est chargee de generer le tableau de serveurs
  * est un singleton
  */

  /**
  * Attributs
  *@param tab : liste de server
  *@param multiplier : multiplier de serveurs (avec et sans antivirus)
  *@param multiplier2 : multiplier de serveurs avec bitcoin
  *@param multiplier3 : multiplier de serveurs avec mots de passes
  */
  private static List<Server> tab;
  private static double multiplier;
  private static double multiplier2;
  private static double multiplier3;

  /**
  * Constructeur private
  */
  private GenerationServeurs()
  {
    tab = null;
  }

  /** Singleton */
  private static class GenerationServeursHolder
  {
    private final static GenerationServeurs Instance = new GenerationServeurs();
  }


  /**
  * Getters & Setters
  */

  public static GenerationServeurs getInstance()
  {
    return GenerationServeursHolder.Instance;
  }

  /**
  *Cree le tableau de serveurs
  *deux boucles for generant chacune un nombre i de serveurs et fait appel aux methodes de choix de contenu aleatoires provenant de la classe Server
  *@param difficulty : peut être 1, 2 ou 3, defini le nombre total de serveurs a generer
  *@param multiplier, @param multiplier2 et @param multiplier3: servent a augmenter ou diminuer (selon le niveau de difficulte) les attributs donnes
  *@return l'attribut tab contenant tous les serveurs du jeu
  */
  public static void Create(int difficulty)
  {
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
    //**************************************************************************
    int nombredeserveurs = (int)(Rng.getRandomInt(15, 50) * multiplier); //Genere un nombre de serveurs compris entre 15 et 50(exclu) multiplie par le double de la difficulte
    int nbrservavecAntivirus = (int)(Rng.getRandomInt(5, 20) * multiplier); //Genere des serveurs avec antivirus dans un intervalle compris entre 5 et 20(exclu) multiplie par le double de la difficulte
    int nbrtotal = nombredeserveurs + nbrservavecAntivirus;
    tab = new ArrayList<Server>(nbrtotal);
    //**************************************************************************
    // génère des serveurs sans Antivirus
    for (int i = 0 ; i < nbrtotal ; i++ ) {
      String Nom = "serveur" + i; //genere le nom du serveur
      Server tmp = new Server(Nom, GenerationArguments.NomUser(), GenerationArguments.TabNomFichiers());
      tab.add(tmp);
    }

    //selectionne des serveurs au hasard et leur cree un antivirus de nom et niveau aleatoire
    for ( int i = 0; i < nbrservavecAntivirus ; i++ ) {
      int niveauantivirus = Rng.getRandomInt(1, 10); //genere un niveau d'antivirus compris entre 1 et 10
      int serveuraleatoire = Rng.getRandomInt(1, tab.size()); //selectionne un serveur dans le tableau, excluant le serveur0
      tab.get(serveuraleatoire).creerAntivirus(GenerationArguments.NomAntiV(), niveauantivirus);
    }
    //**************************************************************************
    //cree des serveurs qui possedent des bitcoins
    int nbrServAvecBitcoin = (int)(Rng.getRandomInt(15, 40) * multiplier2); //entre 15 et 40 (exclu) * le multiplier possederont des bitcoins
    for (int i = 0; i < nbrServAvecBitcoin ; i++ ) {
      int numtmp = Rng.getRandomInt(1, tab.size()); //selectionne un serveur aleatoirement, en dehors du serveur0
      double tmpbitcoin = GenerationArguments.Bitcoin();
      tab.get(numtmp).setbitcoin(tmpbitcoin);
    }
    //**************************************************************************
    //cree les connexions entre les Serveurs
    for (int i = 1 ; i < tab.size() ; i++ ) {
      int nbr = Rng.getRandomInt(3, 10); //genere un nombre au hasard dans un intervalle donne (a definir)
      //ce nombre sert a determiner le nombre de serveurs connectes au serveur i de la premiere boucle

      Server tmp[] = new Server[nbr]; //tableau de serveurs qui seront connectes au premier serveur i selectionne

      for ( int j = 0 ; j < nbr ; j++ ) {
        int serv = Rng.getRandomInt(0, tab.size());//selectionne un serveur au hasard
        tmp[j] = tab.get(serv); //l'ajoute dans le tableau
      }
      tab.get(i).setVoisins(tmp); //cree une connexion entre le premier serveur selectionne et le tableau de serveurs cree
    }

    //cas particulier pour serveur0 :
    //il est imperatif qu'il aie au moins 5 connexions (en esperant qu'aucun des 1ers serv n'a d'antivirus sinon impossible de jouer) mais pas trop non plus sinon c'est trop facile
    int nombredeconnexions = Rng.getRandomInt(5, 10); //l'intervalle [5;9] me semble un bon compromis, independamment de la difficulte
    Server tmp2[] = new Server[nombredeconnexions + 1];//tableau de serveurs qui sera connecte au serveur0
    for (int i = 0 ; i <= nombredeconnexions ; i++ ) {
      int serv = Rng.getRandomInt(0, tab.size());//selectionne un serveur au hasard
      tmp2[i] = tab.get(serv); //l'ajoute dans le tableau
    }
    tab.get(0).setVoisins(tmp2); //cree une connexion entre serveur0 et le tableau de serveurs cree

    //**************************************************************************
    //cree des serveurs avec mots de passes
    int nombredeservAvecmdp = (int)(Rng.getRandomInt(10, tab.size()) * multiplier3);  //retourne un nombre aleatoire de serveurs entre 10 et la longueur du tableau

    //boucle for qui va creer un mot de passe pour un nombre donne (defini par nombredeservAvecmdp) de serveurs (qui seront selectionne aleatoirement)
    for (int i = 0; i < nombredeservAvecmdp ; i++ ) {
      int servAleatoire = Rng.getRandomInt(1, tab.size()); //selectionne un nombre entre 1 (serveur0 ne doit pas avoir de mdp) et la longueur du tableau
      tab.get(servAleatoire).setmdp(); //cree un mot de passe pour le serveur donne
    }

    //**************************************************************************
    //CREATION DU SERVEUR GAGNANT
    int serveurgagnant = Rng.getRandomInt(1, tab.size()); //selectionne un des serveurs du tableau sauf serveur0
    tab.get(serveurgagnant).creerAntivirus(GenerationArguments.NomAntiV(), 10); //lui cree un antivirus de niveau 10
    tab.get(serveurgagnant).setUsername("Roegel");//Defini le nom de l'user sur "Roegel"
    tab.get(serveurgagnant).setmdp("OnCodeEnFrancaisIci"); //lui cree un mot de passe personnalise
    tab.get(serveurgagnant).setSpecificContent("Sudoku.java", 0); //Cree le fichier gagnant a la position 0 de son Content[]
  }

  /** Permet d'acceder au tableau de serveur depuis n'importe quelle classe et de creer un objet Server[] si besoin*/
  public static List<Server> getTabServer()
  {
    return tab;
  }
}
