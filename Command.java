import java.util.Scanner;

public class Command {

	// Attributs
	private String word1;
	private String word2;

	// Constructeur
	public Command() {
		this.word1 = null;
		this.word2 = null;
	}

	public Command(String w1, String w2) {
		this.word1 = w1;
		this.word2 = w2;
	}

	public void input(Player p, Scanner sc) {
		System.out.print(p.getPseudo() + "@ :");
		String[] mots = sc.nextLine().split(" ");
		if (mots.length > 1) {
		    this.setWord1(mots[0]); // set first word
		    this.setWord2(mots[1]); // set second word
		} else if (mots.length == 1) {
			this.setWord1(mots[0]); // set word
		}
	}

	// commandes
	public static void ls(Server s, Player p) {
		System.out.println("***********************************************************************");
		System.out.println("Contenu du serveur " + p.getCurrentServ().getName() + ": ");
		for (int i = 0; i < s.getContent().length; i++) {
			System.out.println(s.getContent()[i]);
		}
	}

	public static void help() {
		System.out.println("**COMMAND LIST*********************************************************");
		System.out.println("ifconfig: affiche des informations sur l'état actuel du joueur");
		System.out.println("ls: affiche une liste des fichiers présents sur le serveur courant");
		System.out.println("backdoor: installe une backdoor sur le serveur courant pour y contourner la sécurité");
		System.out.println("download X: télécharge le fichier X sur du serveur courant");
		System.out.println("connect X: se connecte au serveur voisin X");
		System.out.println("bruteforce: affiche une partie du mot de passe d'un serveur");
		System.out.println("botnet:");
		System.out.println("quit: ferme la session Hackatron");
	}

	public static void backdoor(Server Serv) {
		System.out.println("[================]100% Backdoor installée avec succès");
		serv.setbackdoor();
	}

	public static void bruteforce() {
		System.out.println("Placeholder bruteforce");
	}

	public static void ifconfig(Player p) {
		System.out.println("***********************************************************************");
		System.out.println("Actuellement connecté à :" + p.getCurrentServ().getName());
		System.out.println("IP adress: 127.65.147");
		System.out.println("Serveurs Connectés: ");
		Server[] voisins = p.getCurrentServ().getVoisins();//affiche la liste des serveurs connectés au serveur courant
		for(int i = 0; i<voisins.length;i++) {
			System.out.println("-"+ voisins[i].getName());
		}
		System.out.println("***********************************************************************");
	}

	public static void connect(Player p, String word2) {
		System.out.println("Placeholder connect");
		System.out.println("Deuxieme mot: " + word2);
		Server[] voisins = p.getCurrentServ().getVoisins();
		p.setCurrentServ(voisins[Integer.valueOf(word2)-1]);
	}

	public static void map() {
		System.out.println("Placeholder map, creates new window w/ network map");
	}

	public static void download(Player p, int i) {
		String[] contenu = p.getCurrentServ().getContent();
		System.out.println("Telechargement de :" + contenu[i]);
	}

//Rajouté par Louise ***********************************************************************************************************************
	public void kill(Serveur Serv, Player p)
	{
		Antivirus A = Serv.getAntivirus();
		if(A.getlvl() <= p.getlvlplayer()){
			A.killAvast();
		}
		else {
			System.out.println("Vous ne pouvez pas desactiver cet antivirus");
		}
	}

	// Getters & Setters
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
