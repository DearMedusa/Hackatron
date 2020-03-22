import java.util.Scanner;

public class Command {

	/* DEBUG COMMANDE POUR LA BETA TESTEUSE QUE JE SUIS */
	public static void DEBUG(){
		boolean running = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Que voulez vous faire ?");
		System.out.println("1 : Augmenter le botnet du joueur");
		System.out.println("2 : Voir les bitcoins du currentServ");
		System.out.println("3 : ajouter 10 bitcoins au joueur");
		System.out.println("4 : Voir le mot de passe du currentServ");
		System.out.println("5 : Debloquer toutes les competences");
		System.out.println("6 : Quitter le menu debug");

		while (running) {
			int choix = sc.nextInt();
			//affichage
			System.out.println("Que voulez vous faire ?");
			System.out.println("1 : Augmenter le botnet du joueur");
			System.out.println("2 : Voir les bitcoins du currentServ");
			System.out.println("3 : ajouter 10 bitcoins au joueur");
			System.out.println("4 : Voir le mot de passe du currentServ");
			System.out.println("5 : Debloquer toutes les competences");
			System.out.println("6 : Quitter le menu debug");

			// interactions
			switch (choix) {
			case 1:
				Player.DEBUGincreasebotnet();
				System.out.println("Le botnet est maintenant de " + Player.getbnetplayer());
				break;
			case 2:
				System.out.println("Le serveur courant possede : "	+ Player.getCurrentServ().getbitcoin() + " bitcoins");
				break;
			case 3 :
				Player.steal(10);
				System.out.println("Vous possedez maintenant " + Player.getbitcoin() + " bitcoins");
				break;
			case 4 :
				if (Player.getCurrentServ().hasmdp()){
					System.out.println("Le mot de passe du serveur est : " + Player.getCurrentServ().getmdp());
				} else { System.out.println("Ce serveur n'a pas de mot de passe"); };
				break;
			case 5 :
				Player.getInventaire().setkill();
				Player.getInventaire().setsteal();
				Player.getInventaire().setbackdoor();
				Player.getInventaire().setbruteforce();
				System.out.println("Faire ifconfig pour verifier que tout a bien ete debloque");
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.println("ERREUR : commande inonnue");
				break;
			}
		}
	}

	/******************************DEBUT DE LA CLASSE******************************************************************************/

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
		System.out.println("bruteforce: affiche le mot de passe d'un serveur s'il en possede un");
		System.out.println("kill: desactive l'antivirus si le niveau de botnet est suffisant");
		System.out.println("steal: vole les bitcoins du serveur courant");
		System.out.println("shop : permet d'acheter des ameliorations");
		System.out.println("quit: ferme la session Hackatron");
	}

	/*
	*Recupere le serveur actuel du Joueur
	*Definit son attribut "backdoor" comme etant vrai
	*/
	public static void backdoor() {
		if (Player.getInventaire().getbackdoor()){
			System.out.println("[================]100% Backdoor installee avec succes");
			Player.getCurrentServ().setbackdoor(true);
		}
		else {
			System.out.println("ERROR : Vous n'avez pas le materiel necessaire pour pouvoir effectuer cette action");
		}
	}

	/*
	* competence achetable : affiche le mot de passe du serveur (necessaire pour pouvoir telecharger les fichiers presents sur celui ci)
	*/
	public static void bruteforce() {
		if (Player.getInventaire().getbruteforce()){ //verifie si le joueur a bruteforce sur true dans on inventaire
			if(Player.getCurrentServ().hasmdp()){ //verifie si le serveur a un mot de passe
				System.out.println("Processing...");
				int aleat = Random.getRandomInt(5, 30);
				for (int i = 0; i < aleat ; i++){ //affichage pur et dur, pour l'immersion
					System.out.print("*");
				}
				System.out.println(" Done");
				System.out.println("Le mot de passe est : " + Player.getCurrentServ().getmdp()); //affiche le mot de passe du serveur
			}
			else { System.out.println("ERROR : ce serveur n'a pas de mot de passe"); } //message d'erreur
		}
		else { System.out.println("ERROR : Vous n'avez pas le materiel necessaire pour pouvoir effectuer cette action"); } //message d'erreur

	}


	/*
	*Recupere le serveur actuel du Joueur
	*Affiche l'attribut adresse ip du serveur
	*affiche les serveurs connectes au serveur actuel
	*affiche l'attribut bnet du Joueur
	*affiche l'etat de l'inventaire du joueur (competences + bitcoins)
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
		System.out.println("Nombre de bitcoins possedes : "+Player.getbitcoin());
		System.out.println("Vous possedez les competences suivantes : ");
		System.out.println("(true = vous pouvez vous servir de cette commande / false : achetez le materiel necessaire (commande : shop) pour la debloquer)");
		System.out.println("backdoor : " + Player.getInventaire().getbackdoor());
		System.out.println("kill : " + Player.getInventaire().getkill());
		System.out.println("steal : " + Player.getInventaire().getsteal());
		System.out.println("bruteforce : " + Player.getInventaire().getbruteforce());
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
			System.out.println("ERROR : ce serveur n'existe pas");
		}
		else {
			//postionnement du joueur
			if (voisins[numServeur].hasAntivirus()){ //si le serveur a un antivirus, le joueur doit d'abord le desactiver pour pouvoir s'y connecter
				if(voisins[numServeur].getAntivirus().getStatut()){ //l'antivirus doit etre disable
					System.out.println("ERROR : Vous ne pouvez pas vous connecter : ");
					System.out.println("ce serveur dispose d'un antivirus : desactivez le puis essayez de vous reconnecter");
				}
				else {//si l'antivirus est disable, on positionne le joueur au serveur demande
					Player.setCurrentServ(voisins[numServeur]);
					System.out.println("Vous etes desormais connecte au " + voisins[numServeur].getName());
				}
			}
			else { //dans le cas contraire, on positionne le joueur au serveur demande
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
	* UTILISATION DE INITIALIZER : contient les lignes de codes necessaire a l'execution
	*/
	public static void download() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bonjour " + Player.getCurrentServ().getUsername() + " !");//affichage du nom de l'user du serveur

		if (Player.getCurrentServ().hasmdp()){ //si le serveur a un mdp, le joueur doit le taper pour pouvoir telecharger les fichiers
			System.out.println("Mot de passe ?");
			String mdp = sc.nextLine();

			if (Player.getCurrentServ().getmdp().equals(mdp)){ //si le joueur a entre le bon mot de passe
				Initializer.download();
			}
			else { System.out.println("ERROR : le mot de passe est incorrect, veuillez reessayer"); }
		}
		else { //si le serveur n'est pas protege par un mot de passe
			Initializer.download();
		}

	}

	/**
	* Methode servant a desactiver les antivirus d'un serveur entre en parametre @param word2
	*/
	public static void kill(String word2)
	{
		if (Player.getInventaire().getkill()){ //VERIFICATION si le joueur a bien la competence requise pour effectuer cette action
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
		else { //message d'erreur
			System.out.println("ERROR : Vous n'avez pas le materiel necessaire pour pouvoir effectuer cette action");
		}
	}

/**Methode qui sert a voler les bitcoins du serveur courant*/
	public static void steal()
	{
		if (Player.getCurrentServ().getbitcoin() == 0){
			System.out.println("ERROR : ce serveur ne possede pas de bitcoins");
		}
		else {
			if (Player.getInventaire().getsteal()){
				double nombredebitcoin = Player.getCurrentServ().getbitcoin(); //recupere le nbr de bitcoin que le serveur possede
				Player.steal(nombredebitcoin); //augmente l'attribut bitcoin de player
				Player.getCurrentServ().decreasebitcoin(nombredebitcoin); //diminue l'attribut bitcoin de serveur
				System.out.println("Vous avez vole " + nombredebitcoin + " bitcoins");
				System.out.println("Vous possedez maintenant " + Player.getbitcoin() + " bitcoins");
			}
			else {
				System.out.println("ERROR : Vous n'avez pas le materiel necessaire pour pouvoir effectuer cette action");
			}
		}
	}

	/**Methode qui permet d'acceder au shop du jeu // TODO : trouver un moyen de catch les erreurs humaines type faute de frappe dans le nextInt() et nextLine()*/
	public static void shop()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenue au shop online du H4cK3r ! Que puis-je pour vous ?");
		boolean running = true;
		int choix;

			System.out.println("Veuillez taper le numero de la section qui vous interesse.");
			System.out.println("1- Informations a propos de 'Backdoor'");
			System.out.println("2- Informations a propos de 'Kill'");
			System.out.println("3- Informations a propos de 'Steal'");
			System.out.println("4- Informations a propos de 'Bruteforce'");

			choix = sc.nextInt();
			String choix2;

			if (choix == 1) {
				System.out.println("Backdoor vous permettra de revenir a un serveur precis, meme si le serveur ou vous etes n'y est pas connecte.");
				System.out.println("Backdoor ne vous coutera que la modique somme de " + Store.getbackdoorprice() + " bitcoins.");
				System.out.println("Voulez vous acquerir la competence backdoor ? y/n");
				choix2 = sc.nextLine(); //POURQUOI TU MARCHES PAS ??? HEIN ???? POURQUOI
				if(choix2.equals("y")){
					Player.buyObject("backdoor", Store.getbackdoorprice());
					System.out.println("Je vous remercie pour votre achat. A la prochaine fois.");
				}
				else {
					System.out.println("Vous ne voulez rien ? A la prochaine alors.");
				}
			}

			if (choix == 2) {
				System.out.println("Kill aneantira l'antivirus d'un serveur indique pour vous. Vous pourrez ensuite vous y connecter sans soucis.");
				System.out.println("Kill ne vous coutera que la modique somme de " + Store.getkillprice() + " bitcoins.");
				System.out.println("Voulez vous acquerir la competence Kill ? y/n");
				choix2 = sc.nextLine(); //ca marche pas, je vais jouer a animal crossing j'en ai marre
				if(choix2.equals("y")){
					Player.buyObject("kill", Store.getkillprice());
					System.out.println("Je vous remercie pour votre achat. A la prochaine fois.");
				}
				else {
					System.out.println("Vous ne voulez rien ? A la prochaine alors.");
				}
			}

			if (choix == 3) {
				System.out.println("Steal recuperera tous les bitcoins du serveur sur lequel vous etes et les transferera sur votre portefeuille.");
				System.out.println("Steal ne vous coutera que la modique somme de " + Store.getstealprice() + " bitcoins.");
				System.out.println("Voulez vous acquerir la competence Steal ? y/n");
				choix2 = sc.nextLine();
				if(choix2.equals("y")){
					Player.buyObject("steal", Store.getstealprice());
					System.out.println("Je vous remercie pour votre achat. A la prochaine fois.");
				}
				else {
					System.out.println("Vous ne voulez rien ? A la prochaine alors.");
				}
			}

			if (choix == 4) {
				System.out.println("Bruteforce recuperera le mot de passe de l'utilisateur du serveur sur lequel vous etes. Vous pourrez ensuite telecharger ce que vous voulez.");
				System.out.println("Bruteforce ne vous coutera que la modique somme de " + Store.getbruteforceprice() + " bitcoins.");
				System.out.println("Voulez vous acquerir la competence Bruteforce ? y/n");
				choix2 = sc.nextLine();
				if(choix2.equals("y")){
					Player.buyObject("bruteforce", Store.getbruteforceprice());
					System.out.println("Je vous remercie pour votre achat. A la prochaine fois.");
				}
				else {
					System.out.println("Vous ne voulez rien ? A la prochaine alors.");
				}
			}

			else {
				System.out.println("Vous ne voulez rien ? A la prochaine alors.");
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
