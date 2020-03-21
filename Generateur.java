import java.lang.*;

public class Generateur {

  /**
  *Est appele au lancement du jeu
  *cree des serveurs
  *genere des strings pour la creation d'objets
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
* @param MotsDePasses tableau de strings
* @param AdressesIp tableau de strings
* @param NomsDeFichiers tableau de strings
* @param NomsAntivirus tableau de strings
*/

/** Tableau de string contenant des mots de passes possibles pour une instance de serveur */
  private static String MotsDePasses[] = {
    "123456789", "felix", "incorrect", "baseball", "soleil", "welcome",
    "motdepasse", "1234", "azertyuiop", "football", "iloveyou", "qwerty",
    "master", "sunshine", "shadow", "jesus", "admin", "flower", "starwars",
    "abc123", "login", "solo", "letmein", "passw0rd", "superman", "azerty",
    "princess", "hello", "freedom", "00000", "ashley", "11111", "photoshop",
    "whatever", "batman", "trustno1", "qwerty123", "ninja", "dragon", "access",
    "66666", "bailey", "mustang", "charlie", "donald", "loulou", "bonjour",
    "nicolas", "doudou", "marseille", "qazwsx"
  };

/** Tableau de string contenant des adresses ip possibles pour une instance de serveur */
  private static String AdressesIp[] = {
    "71.118.230.239", "127.65.147", "154.117.86.28", "238.198.19.23",
    "234.51.105.44", "222.99.190.115", "132.149.99.134", "127.9.166.26",
    "187.251.11.49", "68.87.193.218", "42.47.41.61", "27.164.13.62",
    "15.230.14.18", "147.102.220.166", "7.184.160.173", "244.24.234.159",
    "135.165.108.190", "55.167.71.65", "205.104.176.24", "15.26.248.151",
    "11.7.30.109", "121.12.15.194", "156.120.65.21", "189.164.17.24",
    "44.206.17.186", "249.30.124.157", "215.141.0.164", "154.136.101.197",
    "215.100.140.5", "134.43.173.81", "110.211.78.168" ,"46.170.0.155",
    "174.120.58.77", "243.213.11.31", "129.106.39.127", "58.107.163.13",
    "182.27.221.114", "21.255.184.145", "172.114.125.224", "11.200.200.243",
    "62.35.203.9", "163.30.29.29", "209.95.239.3", "191.1.39.191",
    "151.87.33.190", "119.155.167.63", "156.8.250.124", "85.190.141.199",
    "127.253.58.38", "49.235.76.241", "158.207.75.129", "238.108.200.4",
    "29.122.67.249", "85.89.211.164", "121.7.104.171", "129.174.202.118",
    "185.230.35.4", "180.145.231.175", "151.190.213.109", "122.226.94.24",
    "219.255.219.194", "71.171.148.250", "250.184.251.22", "84.180.23.218",
    "179.154.43.116", "34.138.195.204", "237.86.60.0", "255.30.117.162",
    "83.225.253.188", "221.245.166.13", "14.19.8.122", "21.218.48.56",
    "215.161.212.114", "69.175.87.44", "15.2.126.206", "0.134.46.37",
    "69.148.79.92", "88.163.6.247", "198.182.33.246", "93.187.83.172"
  };

  /** Tableau de string contenant des contenus possibles pour une instance de serveur */
  private static String NomsDeFichiers[] = {
    "NePasOuvrirEnPublic.png", "NotesDuDS.xl", "MoiQuiDanse.mp4",
    "ChienQuiDort.gif", "HistoiresDeJojo.html", "AvisDesHaters.trash",
    "KaamelottIntegrale.zip", "ImagesDeCanard.png", "RickAstley.mp3",
    "Fontrite.exe", "PhotosVacancesArdeche.zip", "MamanOuvrePasStp.rar",
    "Skymir.exe", "MyWaifu.html", "arg.php", "jedetesteledevweb.php",
    "index.html", "style.css", "IMG_20160521_115949.jpg", "Coursdecom.docx",
    "IMG_24849821_1459872.png", "IMG_2521_15049.gimp", "heeeeeheheheeh.jpg",
    "Paint.exe", "NSFW.gif", "tousmesamis.doc", "monchien.jpg", "jajaja.gif",
    "PhotosMaman.zip", "DiplômeduBac.png", "CV.pdf", "LettredeMotivation.pdf",
    "Annonce.pdf", "SCAN_CarteVitale.png", "SCAN_IBAN-CIC.png", "Terraria.exe",
    "Steam.crack", "LeagueOfGelends.exe", "CheatsGTAV.txt", "Antman.mkv",
    "Discrod.exe", "Fable.exe", "KingdomComeDeliverance.exe",
    "GoatSilumator.exe", "user.settings.bak", "VLCMediaPlayer.exe",
    "GithubDesktop.exe", "uRottent.exe", "Ampps-3.9-x86_64-setup", ".git",
    "MinecraftLauncher.exe", "PhpStorm 2019.3.3 x64.exe", "Divers.dir",
    "jdk-13.0.2.dir", "Recovery.txt", "chat.gif", "main.java", "Magicien.java",
    "etudiant.o", "etudiant.h", "etudiant.c", "tab.php", "Magicien.class",
    "BatmanVSuperman.avi", "LeChateauAmbulant.avi", "GOT_EP6_S3.mkv",
    "factureecranpc.pdf", "factureanimalcrossing.pdf", "factureEDF.pdf",
    "mememario.gif", "Autosave.qs", "DONTKILLMEPLZ.plr.bak", "ConsortModGrow.package",
    "NOOB-LAND-2.wld.bak", "SkyrimPrefs", "ccmerged.package", "Resource.cfg",
    "Autosave1_26D2A541_0_44726F2752612D52692748616D_Tamriel_000505_20200311200413_81_1.ess",
    "JezaAnimations.package", "Sunset Valley_0x0859db3c.nhd", "Sheltered.exe",
    "input.settings", "CheckPoint_53db8_7e406800_538d23a.sav", "Random.java",
    "Rockstar-Games-Launcher", "eclipse-java-2019-12-R-win32-x86_64.rar",
    "blender-2.81a-windows64", "MSI_Kombustor4_Setup_v4.1.3.0_x64",
    "php-7.4.3.tar.bz2", "NeverGonnaGiveYouUp.mp3", "Womanizer.mp4",
    "LoveIsGone_Guetta.mp3", "CarelessWhispers.avi", ".gitignore"
  };

  /** Tableau de string contenant des noms possibles pour une une instance d'antivirus d'une instance de serveur */
  private static String NomsAntivirus[] = {
    "Avast", "McAffee",
    "Ad-Aware", "AVG Antivirus",
    "Bitdefender", "Kapersky",
    "Norton", "Windows Defender"
  };


/**
* Méthodes
*/

/** Retourne un mot de passe de la liste de manière aléatoire */
  public static String mdp()
  {
    return MotsDePasses[Random.getRandomInt(0, MotsDePasses.length)];
  }

  /** Retourne une adresse ip de la liste de manière aléatoire */
  public static String AdressesIp()
  {
    return AdressesIp[Random.getRandomInt(0, AdressesIp.length)];
  }

  /** Retourne un tableau (de longueur aléatoire défnie dans un intervalle) de noms de fichier de la liste de manière aléatoire */
  public static String[] TabNomFichiers()
  {
    int Longueurdutableau = Random.getRandomInt(1, 7); //minimum 1 fichier
    String Tab[] = new String[Longueurdutableau]; //Contient les noms de fichiers

    for (int i = 0 ; i < Longueurdutableau; i++ ) {
      /*
      * Remplis le tableau avec des noms de fichiers aléatoires sélectionnés
      * dans l'attribut de la table Generateur
      */
      Tab[i] = NomsDeFichiers[Random.getRandomInt(0, NomsDeFichiers.length)];
    }

    return Tab;
  }

  /** @return un nom d'antivirus aleatoire provenant de la liste NomAntivirus */
  public static String NomAntiV()
  {
    return NomsAntivirus[Random.getRandomInt(0, NomsAntivirus.length)];
  }


}
