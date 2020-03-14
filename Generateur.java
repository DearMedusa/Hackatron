public class Generateur {

  /**
  *Est appele au lancement du jeu
  *creer des serveurs 
  */

  /** Génère des Strings de manière aléatoire */
    private Generateur(){}

/*
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

/**
* Attributs
@param MotsDePasses tableau de strings
@param AdressesIp tableau de strings
*/

/** Tableau de string contenant des mots de passes possibles pour une instance de serveur */
  private static String[] MotsDePasses = {
    "123456789", "felix", "15121998", "54000Nancy", "incorrect",
    "motdepasse", "1234", "azertyuiop"
  };

/** Tableau de string contenant des adresses ip possibles pour une instance de serveur */
  private static String[] AdressesIp = {
    "71.118.230.239", "127.65.147", "154.117.86.28", "238.198.19.23",
    "234.51.105.44", "222.99.190.115", "132.149.99.134", "127.9.166.26",
    "187.251.11.49", "68.87.193.218", "42.47.41.61", "27.164.13.62",
    "15.230.14.18", "147.102.220.166", "7.184.160.173", "244.24.234.159",
    "135.165.108.190", "55.167.71.65", "205.104.176.24", "15.26.248.151",
    "11.7.30.109", "121.12.15.194", "156.120.65.21", "189.164.17.24"
  };

  /** Tableau de string contenant des contenus possibles pour une instance de serveur */
  private static String[] NomsDeFichiers = {
    "NePasOuvrirEnPublic.png", "NotesDuDS.xl", "MoiQuiDanse.mp4",
    "ChienQuiDort.gif", "HistoiresDeJojo.html", "AvisDesHaters.trash",
    "KaamelottIntegrale.zip", "ImagesDeCanard.png", "RickAstley.mp3",
    "Fortnite.exe", "PhotosVacancesArdeche.zip", "MamanOuvrePasStp.rar",
    "Skyrim.exe", "MyWaifu.html", "arg.php", "jedetesteledevweb.php",
    "index.html", "style.css", "IMG_20160521_115949.jpg", "New.docx",
    "IMG_24849821_1459872.png", "IMG_2521_15049.gimp", "SansTitre.jpg",
    "Paint.exe", "NSFW.gif", "tousmesamis.doc", "monchien.jpg",
    "PhotosMaman.zip", "DiplômeduBac.png", "CV.pdf", "LettredeMotivation.pdf",
    "Annonce.pdf", "SCAN_CarteVitale.png", "SCAN_IBAN-CIC.png", "Terraria.exe",
    "Steam.crack", "LeagueOfLegends.exe", "CheatsGTAV.txt",
    "MinecraftLauncher.exe", "PhpStorm 2019.3.3 x64.exe", "Divers.dir",
    "jdk-13.0.2.dir", "Recovery.txt", "chat.gif", "main.java", "Magicien.java",
    "etudiant.o", "etudiant.h", "etudiant.c", "tab.php", "Magicien.class"
  };

  /** Tableau de string contenant des noms possibles pour une une instance d'antivirus d'une instance de serveur */
  private static String[] NomsAntivirus = {
    "Avast", "McAffee",
    "Ad-Aware", "AVG Antivirus",
    "Bitdefender", "Kapersky",
    "Norton", "Windows Defender"
  };


/*
* Méthodes
*/

/** Retourne un mot de passe de la liste de manière aléatoire */
  public static String mdp()
  {
    return MotsDePasses[(int)Math.random() * ( MotsDePasses.length - 0 )];
    /*
    * le truc en param du dessus c'est pour sélectionner un nombre entre 0 et la longueur max du
    * tableau, pour sélectionner une valeur au pif
    * (je sais pas du tout si ça marche j'ai pas testé)
    */
  }

  /** Retourne une adresse ip de la liste de manière aléatoire */
  public static String AdressesIp()
  {
    return AdressesIp[(int)Math.random() * ( AdressesIp.length - 0 )];
  }

  /*
  * Retourne un tableau (de longueur aléatoire défnie dans un intervalle)
  * de noms de fichier de la liste de manière aléatoire
  */
  public static String[] TabNomFichiers()
  {
    int Longueurdutableau = (int)Math.random() * ( 7 - 1 ); //minimum 1 fichier
    String[] Tab = null; //Contient les noms de fichiers

    for (int i = 0 ; i <= Longueurdutableau; i++ ) {
      /*
      * Remplis le tableau avec des noms de fichiers aléatoires sélectionnés
      * dans l'attribut de la table Generateur
      */
      Tab[i] = NomsDeFichiers[(int)Math.random() * ( NomsDeFichiers.length - 0 )];
    }

    return Tab;
  }

  /** @return un nom d'antivirus aleatoire provenant de la liste NomAntivirus */
  public static String NomAntiV()
  {
    return NomsAntivirus[(int)Math.random() * ( NomsAntivirus.length - 0 )];
  }




}
