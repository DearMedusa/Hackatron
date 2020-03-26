public class Store {
  /*
  *Store represente le shop du Jeu
  *c'est la que le joueur pourra acheter des ameliorations
  */

  /**
  * Attributs
  *@param backtrackprice prix que backtrack va couter au Joueur
  *@param killprice prix que kill va couter au joueur
  *@param stealprice prix que steal va couter au joueur
  */
  private static double backtrackprice;
  private static double killprice;
  private static double stealprice;
  private static double bruteforceprice;

  /**
  *Constructeur du Store
  *@param difficulty : selon le niveau de difficulte les objets seront plus ou moins chers
  */
  public Store(int difficulty)
  {
    switch (difficulty) {
      case 1:
        backtrackprice = 0; //backtrack est gratuit si le jeu est en facile
        killprice = 1.456;
        stealprice = 1;
        bruteforceprice = 1.6262;
        break;
      case 2 :
        backtrackprice = 1.2315;
        killprice = 10.26154;
        stealprice = 2.354;
        bruteforceprice = 5.85215;
        break;
      case 3:
        backtrackprice = 3.68915;
        killprice = 20.5158;
        stealprice = 5.1664;
        bruteforceprice = 10.792156;
        break;
    }
  }

  /*
  * Getters
  */

  public static double getbacktrackprice()
  {
    return backtrackprice;
  }

  public static double getkillprice()
  {
    return killprice;
  }

  public static double getstealprice()
  {
    return stealprice;
  }

  public static double getbruteforceprice()
  {
    return bruteforceprice;
  }


  /** Methodes pour la commande shop() */
  public static void menu()
  {
    System.out.println("Marche Noir");
    System.out.println("Veuillez taper le numero de la section qui vous interesse.");
    System.out.println("1- 'backtrack'");
    System.out.println("2- 'Kill'");
    System.out.println("3- 'Steal'");
    System.out.println("4- 'Bruteforce'");
    System.out.println("5- Quitter le Marche Noir");
  }

  private static void descriptionbacktrack()
  {
    System.out.println("backtrack vous permettra de retourner sur le dernier serveur visite.");
    System.out.println("backtrack vous coutera " + backtrackprice + " bitcoins.");
    System.out.println("Voulez vous acquerir backtrack ? y/n");
  }

  private static void descriptionKill()
  {
    System.out.println("Kill aneantira l'antivirus d'un serveur indique pour vous. Vous pourrez ensuite vous y connecter.");
    System.out.println("Kill ne vous coutera que la modique somme de " + killprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Kill ? y/n");
  }

  private static void descriptionSteal()
  {
    System.out.println("Steal recuperera tous les bitcoins du serveur sur lequel vous etes et les transferera sur votre portefeuille.");
    System.out.println("Steal ne vous coutera que la modique somme de " + stealprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Steal ? y/n");
  }

  private static void descriptionBruteforce()
  {
    System.out.println("Bruteforce recuperera le mot de passe de l'utilisateur du serveur sur lequel vous etes. Vous pourrez ensuite telecharger ce que vous voulez.");
    System.out.println("Bruteforce ne vous coutera que la modique somme de " + bruteforceprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Bruteforce ? y/n");
  }

  private static void msg1()
  {
    System.out.println("Merci de votre achat.");
  }

  private static void msg2()
  {
    System.out.println("Vous ne voulez rien ? A la prochaine alors.");
  }

  /**
  * Methode private servant a acheter des objets au shop
  *@param object nom de l'objet
  *@param price prix de l'objet
  */
  	private static void buyObject(String object, double price)
  	{
  		switch (object) {
  			case "backtrack" : //si le joueur veut acheter backtrack
  				if (Player.getInventaire().getbacktrack()){ //cas ou il le possede deja
  					System.out.println("ERROR : Vous possedez deja ce materiel");
  				}
  				else {//cas ou il ne le possede pas encore
  					if (Player.getbitcoin() >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
  						Player.getInventaire().setbacktrack();
  						Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
  						System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande backtrack.");
  					}
  					else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
  				}
  				break;
  			case "kill" : //si le joueur veut acheter kill
  				if (Player.getInventaire().getkill()){ //cas ou il le possede deja
  					System.out.println("ERROR : Vous possedez deja ce materiel");
  				}
  				else {//cas ou il ne le possede pas encore
  					if (Player.getbitcoin() >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
  						Player.getInventaire().setkill();
  						Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
  						System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande kill.");
  					}
  					else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
  				}
  				break;
  				case "steal" : //si le joueur veut acheter kill
  					if (Player.getInventaire().getsteal()){ //cas ou il le possede deja
  						System.out.println("ERROR : Vous possedez deja ce materiel");
  					}
  					else {//cas ou il ne le possede pas encore
  						if (Player.getbitcoin() >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
  							Player.getInventaire().setsteal();
  							Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
  							System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande steal.");
  						}
  						else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
  					}
  					break;
  				case "bruteforce" : //si le joueur veut acheter kill
  					if (Player.getInventaire().getbruteforce()){ //cas ou il le possede deja
  						System.out.println("ERROR : Vous possedez deja ce materiel");
  					}
  					else {//cas ou il ne le possede pas encore
  						if (Player.getbitcoin() >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
  							Player.getInventaire().setbruteforce();
  							Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoin
  							System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande bruteforce.");
  						}
  						else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
  						}
  					break;
  		}
  	}


      public static void choicesDESC(String S){
        switch (S) {
          case "1":
            descriptionbacktrack();
            break;
          case "2":
            descriptionKill();
            break;
          case "3":
            descriptionSteal();
            break;
          case "4":
            descriptionBruteforce();
            break;
          default:
            System.out.println("ERROR : veuillez reessayer");
            break;
        }
      }

      public static void choicesBUY(String choix1, String choix2){

        switch(choix2){

          case "y":
            switch (choix1) {
              case "1":
                buyObject("backtrack", backtrackprice);
                msg1();
                break;
              case "2":
                buyObject("kill", killprice);
                msg1();
                break;
              case "3":
                buyObject("steal", stealprice);
                msg1();
                break;
              case "4":
                buyObject("bruteforce", bruteforceprice);
                msg1();
                break;
              default:
                msg2();
                break;
            }
            break;

          default:
            msg2();
            break;
        }

      }




}
