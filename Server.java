public class Server {

	/**
	* Classe contenant le contenu et les methodes relatives aux serveurs du jeu
	*/

	/**
	* Attributs
	*@param name String nom du serveur
	*@param content tableau de String contenant les fichiers contenu dans le serveur
	*@param backdoored boolean
	*@param serveursVoisins tableau de serveurs auxquels est relie le serveur
	*@param IpAdress String ip du serveur
	*@param avast Antivirus du serveur
	*@param hasavast boolean : true si le serveur a un antivirus
	*@param mdp Mot de passe du serveur
	*@param hasmdp boolean : défini si le serveur a ou non un mdp
	*@param bitcoin nombre de bitcoin que le serveur possede
	*@param hasbitcoin boolean : defini si le serveur a des bitcoins
	*/
	private String name;
	private String nameuser;
	private String[] content;
	private boolean backdoored;
	private Server[] serveursVoisins;
	private String IpAdress;
	private Antivirus Avast;
	private boolean hasAvast;
	private String mdp;
	private boolean hasmdp;
	private double bitcoin;

	/**
	* Constructeur de serveur sans antivirus
	*@param n String nom du serveur
	*@param c tableau de string contenu du serveur
	*/
	public Server(String n, String nuser, String[] c) {
		this.name = n;
		this.nameuser = nuser;
		this.backdoored = false;
		this.content = c;
		this.Avast = null;
		this.hasAvast = false;
		this.IpAdress = GenerationArguments.AdressesIp();
		this.hasmdp =  false;
		this.bitcoin = 0;
	}

	/**
	* Methode qui cree un antivirus pour un serveur existant
	*@param nom nom de l'antivirus
	*@param niveau niveau de l'antivirus
	*/
	public void creerAntivirus(String nom, int niveau)
	{
		this.Avast = new Antivirus(nom, niveau);
		this.hasAvast = true;
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

	public String getUsername()
	{
		return this.nameuser;
	}

	public String getIp() {
		return this.IpAdress;
	}

	public void setbackdoor(boolean b)
	{
		this.backdoored = b;
	}

	public Antivirus getAntivirus()
	{
		return this.Avast;
	}

	public boolean hasAntivirus()
	{
		return this.hasAvast;
	}

	public void setmdp()
	{
		this.mdp = GenerationArguments.mdp();
		this.hasmdp = true;
	}

	public boolean hasmdp()
	{
		return this.hasmdp;
	}

	public String getmdp()
	{
		return this.mdp;
	}

	public double getbitcoin()
	{
		return this.bitcoin;
	}

	public void setbitcoin(double bitcoin)
	{
		this.bitcoin += bitcoin;
	}

	public void decreasebitcoin(double nbr)
	{
		this.bitcoin -= nbr;
	}

}
