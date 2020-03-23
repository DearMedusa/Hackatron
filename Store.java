public class Store {
  /*
  *Store represente le shop du Jeu
  *c'est la que le joueur pourra acheter des ameliorations
  */

  /**
  * Attributs
  *@param backdoorprice prix que backdoor va couter au Joueur
  *@param killprice prix que kill va couter au joueur
  *@param stealprice prix que steal va couter au joueur
  */
  private static double backdoorprice;
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
        backdoorprice = 0; //backdoor est gratuit si le jeu est en facile
        killprice = 1.456;
        stealprice = 0; //steal est gratuit pour l'instant, a voir si on trouve d'autres moyens pour obtenir des bitcoins dans le jeu que juste les voler (minage ?)
        bruteforceprice = 1.6262;
        break;
      case 2 :
        backdoorprice = 1.2315;
        killprice = 10.26154; //les valeur sont completements arbitraires pour l'instant
        stealprice = 0;
        bruteforceprice = 5.85215;
        break;
      case 3:
        backdoorprice = 3.68915;
        killprice = 20.5158; //valeurs a revoir apres avoir teste le jeu pour voir si c'est jouable ou non
        stealprice = 0;
        bruteforceprice = 10.792156;
        break;
    }
  }

  /*
  * Getters
  */

  public static double getbackdoorprice()
  {
    return backdoorprice;
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

  public static void menu()
  {
    System.out.println("Marche Noir");
    System.out.println("Veuillez taper le numero de la section qui vous interesse.");
    System.out.println("1- 'Backdoor'");
    System.out.println("2- 'Kill'");
    System.out.println("3- 'Steal'");
    System.out.println("4- 'Bruteforce'");
  }

  public static void descriptionBackdoor()
  {
    System.out.println("Backdoor vous permettra de FJAIEOGJAEIGEAJGOAIEJGEO.");
    System.out.println("Backdoor vous coutera " + backdoorprice + " bitcoins.");
    System.out.println("Voulez vous acquerir backdoor ? y/n");
  }

  public static void descriptionKill()
  {
    System.out.println("Kill aneantira l'antivirus d'un serveur indique pour vous. Vous pourrez ensuite vous y connecter.");
    System.out.println("Kill ne vous coutera que la modique somme de " + killprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Kill ? y/n");
  }

  public static void descriptionSteal()
  {
    System.out.println("Steal recuperera tous les bitcoins du serveur sur lequel vous etes et les transferera sur votre portefeuille.");
    System.out.println("Steal ne vous coutera que la modique somme de " + stealprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Steal ? y/n");
  }

  public static void descriptionBruteforce()
  {
    System.out.println("Bruteforce recuperera le mot de passe de l'utilisateur du serveur sur lequel vous etes. Vous pourrez ensuite telecharger ce que vous voulez.");
    System.out.println("Bruteforce ne vous coutera que la modique somme de " + bruteforceprice + " bitcoins.");
    System.out.println("Voulez vous acquerir Bruteforce ? y/n");
  }

  public static void msg1()
  {
    System.out.println("Merci de votre achat.");
  }

  public static void msg2()
  {
    System.out.println("Vous ne voulez rien ? A la prochaine alors.");
  }



}
