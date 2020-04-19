package source;
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
  *@param bruteforceprice prix que bruteforce va couter au joueur
  *@param botnetprice cout de l'augmentation du niveau de botnet
  */
  private static double backtrackprice;
  private static double killprice;
  private static double stealprice;
  private static double bruteforceprice;
  private static double botnetprice;
  
  private static int lastlvlbotnet = 1;

  /**
  *Constructeur du Store
  *@param difficulty : selon le niveau de difficulte les objets seront plus ou moins chers
  */
  public Store(int difficulty)
  {
    switch (difficulty) {
      case 1:
        backtrackprice = 0; //backtrack est gratuit si le jeu est en facile
        killprice = 4.456;
        stealprice = 1;
        bruteforceprice = 2.6262;
        botnetprice = 3.2569;
        break;
      case 2 :
        backtrackprice = 1.2315;
        killprice = 10.26154;
        stealprice = 5.354;
        bruteforceprice = 7.85215;
        botnetprice = 12.5488;
        break;
      case 3:
        backtrackprice = 3.68915;
        killprice = 20.5158;
        stealprice = 7.1664;
        bruteforceprice = 10.792156;
        botnetprice = 25.4892;
        break;
    }
  }
  
  /**
   * Methode publique appelle a chaque fois que le joueur lance la commande shop, modifie les prix du store
   * augmente le prix du botnet 
   */
  public static void ChangePrice()
  {
	  double price = Rng.getRandom() * 2;
	  if (Player.getbnetplayer() >= lastlvlbotnet ) {
		  botnetprice += price;
	  }
  }
  /** recupere le dernier lvl de botnet du joueur (juste apres qu'il aie quitte le shop)*/
  public static void setlastlevelbotnet()
  {
	  lastlvlbotnet = Player.getbnetplayer();
  }


/*Methodes privees appellees par les methodes publiques de Store pour l'affichage*/

  /*Description des competences que le joueur peut acquerir*/
  private static void descriptionBotnet()
  {
    System.out.println("Le botnet vous permet de desactiver les antivirus.");
    System.out.println("Prix : " + botnetprice + " bitcoins.");
    System.out.println("Voulez vous augmenter votre niveau de botnet ? y/n");
  }

  private static void descriptionbacktrack()
  {
    System.out.println("backtrack vous permettra de retourner sur le dernier serveur visite.");
    System.out.println("Prix : " + backtrackprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Backtrack ? y/n");
  }

  private static void descriptionKill()
  {
    System.out.println("Kill aneantira l'antivirus d'un serveur specifique. Vous pourrez ensuite vous y connecter.");
    System.out.println("Prix: " + killprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Kill ? y/n");
  }

  private static void descriptionSteal()
  {
    System.out.println("Steal recuperera tous les bitcoins du serveur sur lequel vous etes et les transferera sur votre portefeuille.");
    System.out.println("Prix: " + stealprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Steal ? y/n");
  }

  private static void descriptionBruteforce()
  {
    System.out.println("Bruteforce recuperera le mot de passe de l'utilisateur du serveur sur lequel vous etes. Vous pourrez ensuite telecharger ce que vous voulez.");
    System.out.println("Prix: " + bruteforceprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Bruteforce ? y/n");
  }

  /*Messages par defaut*/
  /*achat qui s'est bien deroule*/
  private static void msg1()
  {
    System.out.println("Merci de votre visite.");
  }

  /*le joueur ne veut rien*/
  private static void msg2()
  {
    System.out.println("Vous ne voulez rien ? A la prochaine alors.");
  }

  /**
  * Methode servant a acheter des objets au shop
  *@param object nom de l'objet
  *@param price prix de l'objet
  */
  	private static void buyObject(String object, double price)
  	{
  		switch (object) {
        case "botnet" : //si le joueur veut acquerir un niv de botnet
          if (Player.getbnetplayer() == 10) { //s'il a deja atteint le niveau max
            System.out.println("ERROR : Vous etes deja au niveau maximal");
          }
          else { //sinon
            if (Player.getbitcoin() > price) { //verification si le joueur a assez de bitcoins
              Player.increaselvl();
              Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
              System.out.println("SUCCES : Votre niveau de botnet a ete augmente.");
            }
            else {
              System.out.println("ERROR : Vous n'avez pas assez de bitcoin"); //sinon on display ce msg
            }
          }
          break;
  			case "backtrack" : //si le joueur veut acheter backtrack
  				if (Inventaire.getbacktrack()){ //cas ou il le possede deja
  					System.out.println("ERROR : Vous possedez deja ce programme");
  				}
  				else {//cas ou il ne le possede pas encore
  					if (Player.getbitcoin() > price){ //s'il possede suffisamment de bitcoins, il peut acheter
  						Inventaire.setbacktrack();
  						Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
  						System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande backtrack.");
  					}
  					else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce programme"); } //sinon on display ce msg
  				}
  				break;
  			case "kill" : //si le joueur veut acheter kill
  				if (Inventaire.getkill()){ //cas ou il le possede deja
  					System.out.println("ERROR : Vous possedez deja ce programme");
  				}
  				else {//cas ou il ne le possede pas encore
  					if (Player.getbitcoin() > price){ //s'il possede suffisamment de bitcoins, il peut acheter
  						Inventaire.setkill();
  						Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
  						System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande kill.");
  					}
  					else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce programme"); } //sinon on display ce msg
  				}
  				break;
  				case "steal" : //si le joueur veut acheter kill
  					if (Inventaire.getsteal()){ //cas ou il le possede deja
  						System.out.println("ERROR : Vous possedez deja ce programme");
  					}
  					else {//cas ou il ne le possede pas encore
  						if (Player.getbitcoin() > price){ //s'il possede suffisamment de bitcoins, il peut acheter
  							Inventaire.setsteal();
  							Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoins
  							System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande steal.");
  						}
  						else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce programme"); } //sinon on display ce msg
  					}
  					break;
  				case "bruteforce" : //si le joueur veut acheter kill
  					if (Inventaire.getbruteforce()){ //cas ou il le possede deja
  						System.out.println("ERROR : Vous possedez deja ce programme");
  					}
  					else {//cas ou il ne le possede pas encore
  						if (Player.getbitcoin() > price){ //s'il possede suffisamment de bitcoins, il peut acheter
  							Inventaire.setbruteforce();
  							Player.decreasebitcoin(price); //on deduit son achat de son portefeuille de bitcoin
  							System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande bruteforce.");
  						}
  						else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce programme"); } //sinon on display ce msg
  						}
  					break;
  		}
  	}

/*Methodes publiques utilisees par la classe Command et la methode shop()*/
      /*Affiche le menu du shop*/
      public static void menu()
      {
        System.out.println("---------------Marche Noir:---------------");
        System.out.println("Veuillez taper le numero de la section qui vous interesse.");
        System.out.println("1- 'backtrack'");
        System.out.println("2- 'Kill'");
        System.out.println("3- 'Steal'");
        System.out.println("4- 'Bruteforce'");
        System.out.println("5- 'Botnet'");
        System.out.println("6- Quitter le Marche Noir");
      }

      /**
      * Methode qui permet de choisir quel objet le joueur veut acheter
      * @param choix son choix
      */
      public static void choicesDESC(String choix){
        switch (choix) {
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
          case "5":
            descriptionBotnet();
            break;
          default: //en cas d'erreur d'input
            System.out.println("ERROR : veuillez reessayer");
            break;
        }
      }

      /**
      * Methode qui permet au joueur d'acheter
      * @param choix1 choix qu'il a fait precedemment (quel objet il desire acquerir)
      * @param choix2 choix d'achat (y ou n)
      */
      public static void choicesBUY(String choix1, String choix2){

        switch(choix2){

          case "y"://si le joueur veut acheter
            switch (choix1) { //en fonction de son choix precedent
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
              case "5":
                buyObject("botnet", botnetprice);
                msg1();
                break;
              default: //si il y a eu une erreur d'input
                msg2();
                break;
            }
            break;

          default:
            msg2(); //si le joueur ne veut rien acheter
            break;
        }
      }

}
