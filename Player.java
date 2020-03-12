
public class Player {
/*
* Player est un singleton
*/

	// Attributs
	private String pseudo;
	private Server currentServ;
	private int niveau; //bonjour j'ai rajouté ça

	// Constructeur
	private Player() {
		this.pseudo = null;
		this.currentServ = null;
		this.niveau = 1;
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
	public void setPseudo(String p) {
		this.pseudo = p;
	}

	public void setCurrentServ(Server p) {
		this.currentServ = p;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public Server getCurrentServ() {
		return currentServ;
	}

//rajouté par Louise **********************************************************************
	public void increaselvl()
	{
		this.niveau += 1;
	}

	public int getlvlplayer()
	{
		return this.niveau;
	}




}
