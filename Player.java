
public class Player {
	
/*
* Player est un singleton
*Classe contenant toutes les informations et methodes relatives au joueur
*/

	/**
	*@param pseudo String le pseudo du joueur
	*@param currentServ Server le serveur sur lequel le joueur est actuellement
	*/
	private static String pseudo;
	private static Server currentServ;
	private static int botnet; //niveau du joueur

	/**
	*Constructeur d'un objet Player
	*determine tous les attributs en null
	*/
	private Player() {
		this.pseudo = null;
		this.currentServ = null;
		this.botnet = 1;
	}
	
	/**Singleton*/
	private static class PlayerHolder
	{
		private final static Player Instance = new Player();
	}
	
	/**Ajoute un entier i a l'attribut botnet
	*@param i entier 
	*/
	public static void increaselvl(int i)
	{
		botnet += i;
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

	public static int getlvlplayer()
	{
		return botnet;
	}




}
