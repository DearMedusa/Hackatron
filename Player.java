public class Player {

/*
* Player est un singleton
*Classe contenant toutes les informations et methodes relatives au joueur
*/

	/**
	*@param pseudo String le pseudo du joueur
	*@param currentServ Server le serveur sur lequel le joueur est actuellement
	*@param botnet niveau du joueur
	*@param bitcoin nombre de bitcoin que le joueur possède
	*@param Inventory inventaire du Joueur
	*@param life nombre de fois que le joueur peut se permettre de se faire prendre
	*/
	private static String pseudo;
	private static Server currentServ;
	private static int botnet;
	private static double bitcoin;
	private static Inventaire Inventory;
	private static int life;

	/**
	*Constructeur d'un objet Player
	*determine tous les attributs
	*/
	private Player() {
		this.pseudo = null;
		this.currentServ = null;
		this.botnet = 1;
		this.bitcoin = 0;
		this.Inventory = Inventaire.getInstance();
	}

	/**Singleton*/
	private static class PlayerHolder
	{
		private final static Player Instance = new Player();
	}

	/**Getters & Setters*/
	public static Player getInstance()
	{
		return PlayerHolder.Instance;
	}

	public static void setPseudo(String p) {
		pseudo = p;
	}

	public static void setCurrentServ(Server p) {
		currentServ = p;
	}

	public static String getPseudo() {
		return pseudo;
	}

	public static Server getCurrentServ() {
		return currentServ;
	}

	public static int getbnetplayer()
	{
		return botnet;
	}

	public static void increaselvl()
	{
		if (botnet == 10) {
			System.out.println("Vous avez atteint le niveau maximal (10)");
		}
		else {
			botnet += 1;
		}
	}

	public static void increasebitcoin(double nbr)
	{
		bitcoin += nbr;
	}

	public static void decreasebitcoin(double nbr)
	{
		bitcoin += nbr;
	}

	public static double getbitcoin()
	{
		return bitcoin;
	}

	public static void deletebitcoin()
	{
		bitcoin = 0;
	}

	public static Inventaire getInventaire()
	{
		return Inventory;
	}

/** regle la vie en fonction de la difficulte */
	public static void setlife(int difficulty)
	{
		switch (difficulty) {
			case 1:
				life = 20;
				break;
			case 2:
				life = 10;
				break;
			case 3:
				life = 5;
				break;
		}
	}

	public static void decreaselife()
	{
		life -= 1;
	}

	public static int getlife()
	{
		return life;
	}

/**
* Methode servant a acheter des objets au shop (methode appellee par la commande shop())
*@param object nom de l'objet
*@param price prix de l'objet
*/
	public static void buyObject(String object, double price)
	{
		switch (object) {
			case "backdoor" : //si le joueur veut acheter backdoor
				if (Inventory.getbackdoor()){ //cas ou il le possede deja
					System.out.println("ERROR : Vous possedez deja ce materiel");
				}
				else {//cas ou il ne le possede pas encore
					if (bitcoin >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
						Inventory.setbackdoor();
						bitcoin -= price; //on deduit son achat de son portefeuille de bitcoins
						System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande backdoor.");
					}
					else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
				}
				break;
			case "kill" : //si le joueur veut acheter kill
				if (Inventory.getkill()){ //cas ou il le possede deja
					System.out.println("ERROR : Vous possedez deja ce materiel");
				}
				else {//cas ou il ne le possede pas encore
					if (bitcoin >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
						Inventory.setkill();
						bitcoin -= price; //on deduit son achat de son portefeuille de bitcoins
						System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande kill.");
					}
					else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
				}
				break;
				case "steal" : //si le joueur veut acheter kill
					if (Inventory.getsteal()){ //cas ou il le possede deja
						System.out.println("ERROR : Vous possedez deja ce materiel");
					}
					else {//cas ou il ne le possede pas encore
						if (bitcoin >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
							Inventory.setsteal();
							bitcoin -= price; //on deduit son achat de son portefeuille de bitcoins
							System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande steal.");
						}
						else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
					}
					break;
				case "bruteforce" : //si le joueur veut acheter kill
					if (Inventory.getbruteforce()){ //cas ou il le possede deja
						System.out.println("ERROR : Vous possedez deja ce materiel");
					}
					else {//cas ou il ne le possede pas encore
						if (bitcoin >= price){ //s'il possede suffisamment de bitcoins, il peut acheter
							Inventory.setbruteforce();
							bitcoin -= price; //on deduit son achat de son portefeuille de bitcoin
							System.out.println("SUCCES : Vous pouvez maintenant vous servir de la commande bruteforce.");
						}
						else { System.out.println("ERROR : Vous n'avez pas assez de bitcoin pour acheter ce materiel"); } //sinon on display ce msg
						}
					break;
		}
	}

/** COMMANDE DE DEBUG : NE RESTERA PAS */
	public static void DEBUGincreasebotnet()
	{
		botnet = 10;
	}

}
