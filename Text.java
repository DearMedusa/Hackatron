public class Text {

//rajoutée par Louise ****************************************************

  public Text(){}

  public void Logo()
  {
    System.out.println("  _    _          _____ _  __       _______ _____   ____  _   _ \r\n"
    + " | |  | |   /\\   / ____| |/ /    /\\|__   __|  __ \\ / __ \\| \\ | |\r\n"
    + " | |__| |  /  \\ | |    | ' /    /  \\  | |  | |__) | |  | |  \\| |\r\n"
    + " |  __  | / /\\ \\| |    |  <    / /\\ \\ | |  |  _  /| |  | | . ` |\r\n"
    + " | |  | |/ ____ \\ |____| . \\  / ____ \\| |  | | \\ \\| |__| | |\\  |\r\n"
    + " |_|  |_/_/    \\_\\_____|_|\\_\\/_/    \\_\\_|  |_|  \\_\\\\____/|_| \\_|");
  }

  public void Introduction()
  {
    System.out.println("Bienvenue sur Hackatron 3000, le meilleur logiciel de piratage connu");
		System.out.println("***********************************************************************");
		System.out.println(
						"Votre objectif est de telecharger Sudoku.java, vous savez que ce fichier est situe quelque part sur le reseau ");
		System.out.println("Utilisez les commandes donnees pour parcourir les serveurs et trouver le fichier");
		System.out.println("Faites attention, certains serveurs sont proteges par des antivirus");
		System.out.println("Tapez help pour obtenir des informations sur les commandes disponibles");
		System.out.println("***********************************************************************");
		System.out.print("Saisissez votre nom d'utilisateur: ");
  }

  public void NomUser(Player p)
  {
    System.out.println("Votre nom d'utilisateur a ete defini a: " + p.getPseudo());
  }

  public void QuitGame()
  {
    System.out.println("Fermeture de votre session Hackatron...");
  }

}
