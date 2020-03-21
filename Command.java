import java.util.Scanner;

public class Command {

	/* COMMANDE POUR LA BETA TESTEUSE QUE JE SUIS */
	public static void DEBUG(){
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Que voulez vous faire ?");
		System.out.println("1 : Augmenter le botnet du joueur");
		System.out.println("2 : Quitter le menu debug");

		while (running) {
			int choix = sc.nextInt();
			//affichage
			System.out.println("Que voulez vous faire ?");
			System.out.println("1 : Augmenter le botnet du joueur");
			System.out.println("2 : Quitter le menu debug");

			// interactions
			switch (choix) {
			case 1:
				Player.increaselvl();
				System.out.println("Le botnet a ete correctement augmente");
				break;
			case 2:
				running = false;
				break;
			}
		}
	}

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
		System.out.println("ls: affiche ua liste des fichiers présents sur le serveur courant");
		System.out.println("backdoor: installe une backdoor sur le serveur courant pour y contourner la securite");
		System.out.println("download: liste les fichiers disponibles, l'user choisit ensuite celui qu'il veut dl (1 chance sur 6 d'augmenter son niveau de botnet)");
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
		if(Player.getCurrentServ().hasmdp()){
			System.out.println(Player.getCurrentServ().getmdp());
		}
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
		Server[] voisins = Player.getCurrentServ().getVoisins();

		//**************************************************************************
		//Cette partie est chargee de recuperer le numero du serveur dans le tableau qui correspond au mot cle entre par l'user
		int numServeur = -1;
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
			System.out.println("veuillez reessayer :");
		}
		else {
			//postionnement du joueur
			if (voisins[numServeur].hasAntivirus()){ //si le serveur a un antivirus, le joueur doit d'abord le desactiver pour pouvoir s'y connecter
				System.out.println("ERROR : Vous ne pouvez pas vous connecter : ");
				System.out.println("ce serveur dispose d'un antivirus : desactivez le puis essayez de vous reconnecter");
			}
			else { //dans le cas contraire, on positionne le joueur au serveur adequat
				Player.setCurrentServ(voisins[numServeur]);
				System.out.println("Vous etes desormais connecte au " + voisins[numServeur].getName());
			}
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
	*affiche la liste des fichiers que le serveur sur lequel le joueur est positionne possede
	*demande quel numero de fichier le joueur veut, et le telecharge
	*si le fichier s'appelle "sudoku.java", affiche le message de victoire au joueur
	*/

	public static void download() {
		Scanner sc = new Scanner(System.in);
		//affiche la liste des fichiers
		System.out.println("Quel fichier voulez vous telecharger ?");
		String[] contenu = Player.getCurrentServ().getContent();
		for (int i = 0 ; i < contenu.length ; i++ ) { //parcours le tableau et affiche son contenu
			int n = i +1;
			System.out.println(n + " : " + contenu[i]);
		}

		int choix = sc.nextInt(); //recupere le choix de l'utilisateur

		if (choix >= 0 && choix <= contenu.length) { //l'int doit être compris dans l'intervalle donne [0;contenu.length], sinon
			System.out.println("Telechargement de :" + contenu[choix-1]);

			if(contenu[choix-1].equals("Sudoku.java")){ //condition de victoire
				System.out.println("Vous avez trouve le fichier, vous avez gagne. Bravo" + Player.getPseudo() + "!");
			}
			else { //en cas de fichier random osef
				System.out.println("Le fichier a bien ete telecharge.");
				int chance = Random.getRandomInt(0, 7); //0 est inclus et 7 exclu, donc intervalle [0;6]
				if (chance == 3){ //augmente le niveau du joueur (1 chance sur 6)
					System.out.println("Vous avez gagné 1 niveau de botnet suite a cette action");
					Player.increaselvl();
				}
			}
		}
		else { //on affiche un message d'erreur a l'utilisateur
			System.out.println("ERROR : ce fichier n'existe pas, veuillez reessayer");
		}
	}

	public static void kill(String word2)
	{
		Server[] voisins = Player.getCurrentServ().getVoisins();
		//**************************************************************************
		//Cette partie est chargee de recuperer le numero du serveur dans le tableau qui correspond au mot cle entre par l'user
		int numServeur = -1;
		boolean error = true;

		for (int i = 0 ; i < voisins.length ; i++ ) {
			if (word2.equals(voisins[i].getName())) {
				numServeur = i; //recupere la position du serveur dans le tableau
				error = false; //il n'y a pas eu d'erreur, donc on positionne la boolean sur false
				break;
			}
		}
		//**************************************************************************
		//si l'user a fait une faute de frappe, on arrete la et il doit retaper la commande
		if(error == true){
			System.out.println("ERROR : ce serveur n'existe pas, veuillez reessayer");
		}
		//sinon on passe a la partie desactivation
		else {
			Antivirus A = voisins[numServeur].getAntivirus(); //récupère l'antivirus

			if (A != null){ //check si le serveur a effectivement un antivirus

				if(A.getlvl() <= Player.getbnetplayer()){ //check si le lvl de l'antivirus n'est pas sup a celui du joueur
					A.disable(); //désactive l'antivirus
					System.out.println("Cet antivirus etait de force " + A.getlvl());
					System.out.println("Vous avez gagné 1 niveau de botnet suite a cette action");
					Player.increaselvl();
				}
				else { //si le lvl du joueur est trop faible, il ne peut pas desactiver l'antivirus
					System.out.println("Vous ne pouvez pas desactiver cet antivirus, votre botnet est trop faible");
				}
			}

			else { //si le serveur n'a pas d'antivirus, on affiche un msg d'erreur
				System.out.println("FATAL ERROR : Ce serveur n'a pas d'antivirus");
			}
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
