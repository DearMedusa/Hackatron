public class Inventaire {

  /**
  * Inventaire est un singleton
  * contient les informations sur les objets que le joueur possede
  */

  private static boolean backdoor; //false si le joueur n'a pas achete cette competence (shop)
  private static boolean kill; //false si le joueur n'a pas achete cette competence (shop)
  private static boolean steal; //false si le joueur n'a pas achete cette competence (shop)
  private static boolean bruteforce; //false si le joueur n'a pas achete cette competence (shop)

/*
* Constructeur
*/
  private Inventaire() {
    this.backdoor = false;
    this.kill = false;
    this.steal = false;
    this.bruteforce = false;
  }

  /** Singleton */
  private static class InventaireHolder
  {
    private final static Inventaire Instance = new Inventaire();
  }

  /*
  * Getters & Setters
  */

  public static Inventaire getInstance()
  {
    return InventaireHolder.Instance;
  }

  public static void setbackdoor()
  {
    backdoor = true;
  }

  public static boolean getbackdoor()
  {
    return backdoor;
  }

  public static void setkill()
  {
    kill = true;
  }

  public static boolean getkill()
  {
    return kill;
  }

  public static void setsteal()
  {
    steal = true;
  }

  public static boolean getsteal()
  {
    return steal;
  }

  public static void setbruteforce()
  {
    bruteforce = true;
  }

  public static boolean getbruteforce(){
    return bruteforce;
  }


}
