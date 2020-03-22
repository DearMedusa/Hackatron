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

}
