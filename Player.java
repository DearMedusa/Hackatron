public class Player {

/*
* Player est un singleton
*Classe contenant toutes les informations et methodes relatives au joueur
*/

	/**
	*@param pseudo String le pseudo du joueur
	*@param currentServ Server le serveur sur lequel le joueur est actuellement
	*@param botnet niveau du joueur
	*@param bitcoin nombre de bitcoin que le joueur possede
	*@param Inventory inventaire du Joueur
	*@param life nombre de fois que le joueur peut se permettre de se faire prendre
	*@param lastServer Server le serveur sur lequel le joueur etait avant
	*/
	private static String pseudo;
	private static Server currentServ;
	private static int botnet;
	private static double bitcoin;
	private static Inventaire Inventory;
	private static int life;
	private static Server lastServer;

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
		this.lastServer = null;
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

	/** regle la vie en fonction de la difficulte (appellee par main)*/
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
			System.out.println("Votre botnet a atteint le niveau maximal (10)");
		}
		else {
			botnet += 1;
		}
	}
	
	public static void defaultlvl()
	{
		botnet = 1;
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
	
	public static void setBitcoin(double n) {
		bitcoin = n;
	}

	public static void deletebitcoin()
	{
		bitcoin = 0;
	}

	public static Inventaire getInventaire()
	{
		return Inventory;
	}

	public static void decreaselife()
	{
		life -= 1;
	}

	public static int getlife()
	{
		return life;
	}

	public static Server getLastServer()
	{
		return lastServer;
	}

	public static void setLastServer(Server serv)
	{
		lastServer = serv;
	}


}
