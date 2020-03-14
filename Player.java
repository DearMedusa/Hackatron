
public class Player {
/*
* Player est un singleton
*/

	// Attributs
	private static String pseudo;
	private static Server currentServ;
	private static int botnet; //niveau du joueur

	// Constructeur
	private Player() {
		this.pseudo = null;
		this.currentServ = null;
		this.botnet = 1;
	}

	private static class PlayerHolder
	{
		private final static Player Instance = new Player();
	}

	public static Player getInstance()
	{
		return PlayerHolder.Instance;
	}

	//Getters & Setters
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

	public static void increaselvl()
	{
		botnet += 1;
	}

	public static int getlvlplayer()
	{
		return botnet;
	}




}
