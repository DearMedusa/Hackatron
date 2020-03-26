public class Events {
  /**
  * Cette classe servira a creer des evenements aleatoires au cours du jeu
  */

  /*Constructeur*/
  private Events(){}

  /*Getter aleatoire*/
  //Appelle un evenement aleatoire de la classe event
  public static void EventAleatoire()
  {
    int rng = Rng.getRandomInt(0, 50); // X (= nbr d'events) chances sur 50 qu'il y ai un event aleatoire
    switch (rng) {
      case 1:
        VolDeBitcoins();
        break;
      case 2:
        GainBitcoin();
        break;
      case 3:
        PerteBitcoin();
        break;
      case 4:
        GainBotnet();
        break;
    }
  }


  /*Methodes*/
  //Note : l'affichage est a revoir
  //TODO : trouver d'autres idees d'events

  /**Supprime tous les bitcoins du joueur*/
  private static void VolDeBitcoins()
  {
    System.out.println("Vous n'avez pas suffisamment ete prudent :");
    System.out.println("Un autre hacker vous a vole tous vos Bitcoin");
    Player.deletebitcoin();
    System.out.println("Vous possedez : " + Player.getbitcoin() + " bitcoins");
  }

  /**Fait gagner un nombre aleatoire (entre 0 et 1) de bitcoin au joueur*/
  private static void GainBitcoin()
  {
    if(Player.getbitcoin() < 0){ //si le joueur possede des Bitcoins
      double bitcoin = GenerationArguments.Bitcoin();
      System.out.println("Le prix du bitcoin a augmente de 200%, vous gagnez " + bitcoin + " bitcoins");
      Player.increasebitcoin(bitcoin);
      System.out.println("Vous possedez : " + Player.getbitcoin() + " bitcoins");
    }
  }

  /**Fait perdre un nombre aleatoire (entre 0 et 1) de bitcoin au joueur*/
  private static void PerteBitcoin()
  {
    if(Player.getbitcoin() < 0){ //si le joueur possede des Bitcoins
      double bitcoin = GenerationArguments.Bitcoin();
      System.out.println("Le prix du bitcoin s'effrondre, vous perdez " + bitcoin + " bitcoins");
      if (bitcoin > Player.getbitcoin()){ //si le nbr de bitcoins perdus est sup au nbr de bitcoins possedes
        Player.deletebitcoin();
      }
      else {
        Player.decreasebitcoin(bitcoin);
      }
      System.out.println("Vous possedez : " + Player.getbitcoin() + " bitcoins");
    }
  }

  /**Fait gagner 1 niveau de botnet au joueur*/
  private static void GainBotnet()
  {
    System.out.println("En allant sur YuToube, vous tombez sur une video explicative.");
    System.out.println("Grace a elle, vous gagnez 1 niveau de botnet");
    Player.increaselvl();
  }


}
