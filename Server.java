public class Server {

	/*
	* Attributs
	*/
	private String name;
	private String[] content;
	private boolean backdoored;
	private Server[] serveursVoisins;
	private String IpAdress;
	private Antivirus Avast; //bonjour j'ai rajouté ça aussi

	/*
	* Constructeurs
	*/
	//Serveur sans antivirus
	public Server(String n, String[] c) {
		this.name = n;
		this.backdoored = false;
		this.content = c;
		this.Avast = null;
		this.IpAdress = Generateur.AdressesIp();
	}

	//Serveur avec antivirus, rajouté par Louise **********************************************************
	public Server(String n, String[] c, String nA, int lvlA)
	{
		this.name = n;
		this.backdoored = false;
		this.content = c;
		this.Avast = new Antivirus(nA, lvlA);
		this.IpAdress = Generateur.AdressesIp();
	}

	/*
	* Getters & Setters
	*/
	public void setVoisins(Server[] voisins) {
		this.serveursVoisins = voisins;
	}

	public Server[] getVoisins() {
		return this.serveursVoisins;
	}

	public String[] getContent() {
		return content;
	}

	public void setContent(String[] content) {
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public String getIp() {
		return this.IpAdress;
	}


//rajouté par Louise ************************************************************************************
	public void setbackdoor(boolean b)
	{
		this.backdoored = b;
	}

	public Antivirus getAntivirus()
	{
		return this.Avast;
	}

}
