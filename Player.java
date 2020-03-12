
public class Player {

	// Attributs
	private String pseudo;
	private Server currentServ;
	private int niveau;

	// Constructeur
	public Player() {
		this.pseudo = null;
		this.currentServ = null;
		this.niveau = 1;
	}

	public Player(String ps) {
		this.pseudo = ps;
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
