package source;
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
	int CHOICE = Rng.getRandomInt(0, 2); //Choisi quelle serie d'events va se produire
	
	if (CHOICE == 0)
	{
		int rng1 = Rng.getRandomInt(0, 50); // X (= nbr d'events) chances sur 50 qu'il y ai un event aleatoire
		switch (rng1) {
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
	else 
	{
		int rng2 = Rng.getRandomInt(0, 100); // X (= nbr d'events) chances sur 50 qu'il y ai un event aleatoire
		switch (rng2) {
			case 1 :
				HackedByMamanFleur();
				  break;
			case 2 :
				GiftFromMamanFleur();
				break;
		}
	}
  }


  /*Methodes*/
  //Note : l'affichage est a revoir
  //TODO : trouver d'autres idees d'events

  /**Supprime tous les bitcoins du joueur*/
  private static void VolDeBitcoins()
  {
    System.out.println("Vous n'avez pas ete suffisamment prudent :");
    System.out.println("Un autre hacker vous a vole tous vos Bitcoin");
    Player.deletebitcoin();
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
    double bitcoin = GenerationArguments.Bitcoin();
    if(Player.getbitcoin() > bitcoin){ //si le joueur possede plus de bitcoins qu'il ne va en perdre
      System.out.println("Le prix du bitcoin s'effondre, vous perdez " + bitcoin + " bitcoins");
      Player.decreasebitcoin(bitcoin);
    }
    else {
      System.out.println("Le prix du bitcoin s'effondre, vous perdez tous vos bitcoins");
      Player.deletebitcoin();
    }
    System.out.println("Vous possedez : " + Player.getbitcoin() + " bitcoins");
  }

  /**Fait gagner 1 niveau de botnet au joueur*/
  private static void GainBotnet()
  {
    System.out.println("En allant sur YuToube, vous tombez sur une video explicative.");
    System.out.println("Grace a elle, vous renforcez votre botnet");
    Player.increaselvl();
  }
  
  /**HACKED BY MAMANFLEUR*/
  private static void HackedByMamanFleur()
  {
	  System.out.println("H4CKED BY MAMANFLEUR");
	  System.out.println(GenerationArguments.Mamanfleur());
	  VolDeBitcoins();
  }
  
  /**GIFT MAMANFLEUR*/
  private static void GiftFromMamanFleur()
  {
	  System.out.println("MESSAGE FROM MAMANFLEUR");
	  System.out.println("Petit cadeau pas pique des hannetons pour toi jeune apprenti ~0~");
	  Inventaire.setkill();
	  System.out.println("Vous pouvez maintenant desactiver des antivirus.");
  }


}
