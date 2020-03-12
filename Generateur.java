public class Generateur {

//rajoutée par Louise ****************************************************************

/*
* ça me faisait rire ça
* je pense qu'on pourra ptet s'en servir pour désactver les antivirus,
* tu sais le coup des trucs à taper, histoire que ça donne des commandes randoms à taper

  private static String[] hackerlife = {
    "nbtstat -A",
    "net view",
    "net use",
    "ls",
    "kill",
    "rm"
  };
*/

//je me suis fait kiffer j'ai mis des mdp débiles
  private static String[] motsdepasses= {
    "123456789",
    "felix",
    "15121998",
    "54000Nancy",
    "incorrect",
    "motdepasse",
    "1234",
    "azertyuiop"
  };

  private static String S;



/*
* Le but c'est de sélectionner un mot de passe au pif en fait, je sais pas à quoi ça
* pourrait nous servir, mais moi je dis pq pas
*/
  public Generateur()
  {
    S = "bonjour je génère des trucs";
  }

  public String generemdp()
  {
    return motsdepasses[(int)Math.random() * ( motsdepasses.length - 0 )];
    /*
    * le truc en param du dessus c'est pour sélectionner un nombre entre 0 et la longueur max du
    * tableau, pour sélectionner une valeur au pif
    * (je sais pas du tout si ça marche j'ai pas testé)
    */
  }



}
