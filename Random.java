public class Random {

  /*
  * Classe qui contient des methodes pour generer des nombres aleatoires
  */

  /** Constructeur privé */
  private Random(){}

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
