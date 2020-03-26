public class Rng {
  /*
  * Definit tous les elements aleatoires (ou presque) du Jeu
  * en fonction de la difficulte
  * est un singleton
  */

  private static int min; //borne inferieure de la methode getRandomInt()
  private static int max; //borne superieure de la methode getRandomInt()

  /*Constructeur*/
  private Rng(){
    min = 0;
    max = 0;
  }

  /*Singleton*/
  private static class RngHolder
  {
    private final static Rng Instance = new Rng();
  }

  public static Rng getInstance()
  {
    return RngHolder.Instance;
  }

  /*Setter*/
  public static void SetDifficulty(int difficulty){
    switch (difficulty) { // ATTENTION : VALEURS ARBITRAIRES
      case 1: //1 chance sur 30
        min = 0;
        max = 30;
        break;
      case 2: //1 chance sur 20
        min = 0;
        max = 20;
        break;
      case 3 : //1 chance sur 10
        min = 0;
        max = 10;
        break;
    }
  }

  /*Getter*/
  public static boolean getRng() //return true si le joueur est repere
  {
    int random = getRandomInt(min, max);
    if (random == 1) {
      return true;
    }
    else {
      return false;
    }
  }


  /*Methodes*/
  public static void msgRepere(){
    System.out.println("Vous avez ete repere !"); //Affichage a revoir
    Player.decreaselife();
    System.out.println("Il vous reste " + Player.getlife() + "tentatives");
  }

    // On renvoie un nombre aléatoire entre 0 (inclus) et 1 (exclus)
  public static double getRandom() {
    return Math.random();
  }

  // On renvoie un entier aleatoire entre une valeur min (incluse)
  // et une valeur max (exclue).
  public static int getRandomInt(int min, int max) {
    return ((int) (getRandom() * (max - min)) + min);
  }
}
