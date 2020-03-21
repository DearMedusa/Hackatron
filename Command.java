import java.util.Scanner;

public class Command {

	/*
	* Classe qui gere le traitement et l'execution des commandes que le joueur input
	*/

	/*
	* Attributs
	*@param word1 String, le premier mot de la commande
	*@param word2 String, le deuxième mot de la commande
	*/
	private String word1;
	private String word2;

	/*
	* Constructeur qui créer une commande avec ses paramètres null
	*/
	public Command() {
		this.word1 = null;
		this.word2 = null;
	}

	/*
	*Methode Input
	*Affiche le pseudo du joueur
	*Récupère l'input de l'utilisateur
	*le stock dans un tableau "mots"
	*Definit mots[0] comme étant l'attribut word1
	*Definit mots[1] comme étant l'attribut word2 si l'input contient un espace
	*/

	public void input(Scanner sc) {
		System.out.print(Player.getPseudo() + "@ :");
		String[] mots = sc.nextLine().split(" ");
		if (mots.length > 1) {
		    this.setWord1(mots[0]); // set first word
		    this.setWord2(mots[1]); // set second word
		} else if (mots.length == 1) {
			this.setWord1(mots[0]); // set word
		}
	}

	/*
	* Fonctionnement des Commandes du Jeu
	*/

	/*
	*Récupère le serveur actuel du Joueur
	*Affiche chaque element du tableau "contenu" grace à une boucle for
	*/

	public static void ls() {
		System.out.println("***********************************************************************");
		System.out.println("Contenu du serveur " + Player.getCurrentServ().getName() + ": ");
		for (int i = 0; i < Player.getCurrentServ().getContent().length; i++) {
			System.out.println(Player.getCurrentServ().getContent()[i]);
		}
	}

	/*
	*Affiche une liste  des commandes possibles et une breve explication à leur sujet
	*/

	public static void help() {
		System.out.println("**COMMAND LIST*********************************************************");
		System.out.println("ifconfig: affiche des informations sur l'etat actuel du joueur");
		System.out.println("ls: affiche une liste des fichiers présents sur le serveur courant");
		System.out.println("backdoor: installe une backdoor sur le serveur courant pour y contourner la securite");
		System.out.println("download X: telecharge le fichier X sur du serveur courant");
		System.out.println("connect X: se connecte au serveur voisin X");
		System.out.println("bruteforce: affiche une partie du mot de passe d'un serveur");
		System.out.println("kill:");
		System.out.println("quit: ferme la session Hackatron");
	}

	/*
	*Recupere le serveur actuel du Joueur
	*Definit son attribut "backdoor" comme etant vrai
	*/

	public static void backdoor() {
		System.out.println("[================]100% Backdoor installee avec succes");
		Player.getCurrentServ().setbackdoor(true);
	}

	/*
	*A FAIRE
	*En fonction de la stat "bnet" du joueur, affiche un certain nombre des lettres du mdp du serveur actuel
	*/

	public static void bruteforce() {
		System.out.println("Placeholder bruteforce");
	}


	/*
	*Recupere le serveur actuel du Joueur
	*Affiche l'attribut adresse ip du serveur
	*affiche les serveurs connectes au serveur actuel
	*affiche l'attribut bnet du Joueur
	*/

	public static void ifconfig() {
		System.out.println("***********************************************************************");
		System.out.println("Actuellement connecté à :" + Player.getCurrentServ().getName());
		System.out.println("IP adress: " + Player.getCurrentServ().getIp()); //Placeholder, à changer
		System.out.println("Serveurs Connectés: ");
		Server[] voisins = Player.getCurrentServ().getVoisins();//affiche la liste des serveurs connectés au serveur courant
		for(int i = 0; i<voisins.length;i++) {
			System.out.println("-"+ voisins[i].getName());
		}
		System.out.println("Niveau du botnet : "+Player.getbnetplayer());
		System.out.println("***********************************************************************");
	}


	/*
	*Recupere le serveur actuel du Joueur
	*@param word2 de la Commande
	*change l'attribut currentServ du joueur comme etant le serveur word2
	*/

	public static void connect(String word2) {
		System.out.println("Placeholder connect");
		System.out.println("Deuxieme mot: " + word2);
		Server[] voisins = Player.getCurrentServ().getVoisins();

		//**************************************************************************
		//Cette partie est chargee de recuperer le numero du serveur dans le tableau qui correspond au mot cle entre par l'user
		int numServeur = -1; //si je definis pas cette variable il me met une erreur le compilateur alors pas le choix
		boolean error = true;

		for (int i = 0 ; i < voisins.length ; i++ ) {
			if (word2.equals(voisins[i].getName())) {
				numServeur = i; //recupere la position du serveur dans le tableau
				error = false; //il n'y a pas eu d'erreur, donc on positionne la boolean sur false
				break;
			}
		}
		//**************************************************************************
		//retour utilisateur
		//si le joueur a fait une faute de frappe par ex, un message d'errreur apparait
		if (error == true){
			System.out.println("ERROR :");
			System.out.println("Vous avez fait une faute de frappe ou entre un nom de serveur auquel vous n'avez pas acces");
			System.out.println("Veuillez reessayer");
		}
		else { //dans le cas contraire, on positionne le joueur au serveur adequat
			Player.setCurrentServ(voisins[numServeur]);
		}
	}

	/*
	*Creer un objet fenetre
	*/

	public static void map() {
		System.out.println("Ouverture de la fenetre du reseau...");
		Fenetre n = new Fenetre();
	}

	/*
	*@param i int
	*affiche le contenu numero i du serveur actuel
	*si le contenu i est egal au string "sudoku.java" la partie est gagnee
	*/

	public static void download(int i) {
		String[] contenu = Player.getCurrentServ().getContent();
		System.out.println("Telechargement de :" + contenu[i-1]);
		if(contenu[i-1].equals("Sudoku.java")){
			System.out.println("Vous avez trouve le fichier, vous avez gagne. Bravo" + Player.getPseudo() + "!");
		}
	}

	public void kill(Server Serv)
	{
		Antivirus A = Serv.getAntivirus(); //récupère l'antivirus
		if (A != null){ //check si le serveur a effectivement un antivirus
			if(A.getlvl() <= Player.getbnetplayer()){
				A.disable(); //désactive l'antivirus
			}
			else {
				System.out.println("Vous ne pouvez pas desactiver cet antivirus");
			}
		}
		else {
			System.out.println("FATAL ERROR : Ce serveur n'a pas d'antivirus");
		}
	}

	/*
	* Getters & Setters
	*/
	public String getWord1() {
		return this.word1;
	}

	public String getWord2() {
		return this.word2;
	}

	public void setWord1(String s) {
		this.word1 = s;
	}

	public void setWord2(String s) {
		this.word2 = s;
	}

}
