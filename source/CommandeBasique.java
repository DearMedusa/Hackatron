package source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommandeBasique {
	
	public CommandeBasique() {
		super();
	}
	
	/** Methode qui sert a miner des bitcoins sur le serveur courant */
	public static void mine() {
		Scanner sc = new Scanner(System.in);

		System.out
				.println("La puissance de ce serveur est de " + Player.getCurrentServ().getpuissance() + " teraFlops");
		System.out.println("Si vous minez, vous prenez le risque de vous faire reperer par le proprietaire du serveur");
		System.out.println("Voulez vous miner ce serveur ? y/n");

		String choix = sc.nextLine();

		if (choix.equals("y")) {
			double bitcoins = 0;
			if (Player.getCurrentServ().getstatutmine() == false) {
				int power = Player.getCurrentServ().getpuissance();
				switch (power) {
				case 1:
				case 2:
				case 3:
					bitcoins = GenerationArguments.Bitcoin();
					break;
				case 4:
				case 5:
				case 6:
					bitcoins = GenerationArguments.Bitcoin() * 2;
					break;
				case 7:
				case 8:
				case 9:
				case 10:
					bitcoins = GenerationArguments.Bitcoin() * 4;
					break;
				}
				if (Rng.getRng()) {
					GenerationAffichage.msgRepere();
				} else {
					GenerationAffichage.tempsdechargement();
					Player.increasebitcoin(bitcoins);
					System.out.println("Vous avez mine " + bitcoins + " bitcoins");
					Player.getCurrentServ().setmine();
				}
			} else {
				System.out.println("ERROR : vous avez deja mine ce serveur");
				if (Rng.getRng()) {
					GenerationAffichage.msgRepere();
				}
			}
		}
	}
	
	/** Methode qui permet d'acceder au shop du jeu */
	public static void shop() {
		Scanner sc = new Scanner(System.in);
		String choix;
		boolean running = true;

		while (running) {
			Store.menu();
			choix = sc.nextLine();

			if (choix.equals("6")) {
				running = false;
				break;
			}

			Store.choicesDESC(choix);
			String memorychoice = choix;

			choix = sc.nextLine();
			Store.choicesBUY(memorychoice, choix);
		}
	}
	
	/*
	 * Recupere le serveur actuel du Joueur
	 *
	 * @param word2 de la Commande change l'attribut currentServ du joueur comme
	 * etant le serveur word2
	 */
	public static void connect(String word2) {
		Server[] voisins = Player.getCurrentServ().getVoisins();

		// **************************************************************************
		// Cette partie est chargee de recuperer le numero du serveur dans le tableau
		// qui correspond au mot cle entre par l'user
		int numServeur = -1;
		boolean error = true;

		for (int i = 0; i < voisins.length; i++) {
			if (word2.equals(voisins[i].getName())) {
				numServeur = i; // recupere la position du serveur dans le tableau
				error = false; // il n'y a pas eu d'erreur, donc on positionne la boolean sur false
				break;
			}
		}
		// **************************************************************************
		// retour utilisateur
		// si le joueur a fait une faute de frappe par ex, un message d'errreur apparait
		if (error == true) {
			System.out.println("ERROR : ce serveur n'existe pas");
		} else {
			// postionnement du joueur
			if (voisins[numServeur].hasAntivirus()) { // si le serveur a un antivirus, le joueur doit d'abord le
														// desactiver pour pouvoir s'y connecter
				if (voisins[numServeur].getAntivirus().getStatut()) { // l'antivirus doit etre disable
					GenerationAffichage.tempsdechargement();
					System.out.println("ERROR : Vous ne pouvez pas vous connecter : ");
					System.out.println(word2 + "est protege par un antivirus "
							+ voisins[numServeur].getAntivirus().getname() + ": desactivez le pour vous connecter");
				} else {// si l'antivirus est disable, on positionne le joueur au serveur demande
					Player.setLastServer(Player.getCurrentServ());// sauvegarde du dernier serveur que le joueur a
																	// visite
					Player.setCurrentServ(voisins[numServeur]);
					GenerationAffichage.tempsdechargement();
					System.out.println("Vous etes connecte au " + voisins[numServeur].getName());
					System.out.println("Le serveur vous prendra desormais pour son utilisateur habituel: "
							+ Player.getCurrentServ().getUsername()); // a changer si ca convient pas
				}
			} else { // dans le cas contraire, on positionne le joueur au serveur demande
				Player.setLastServer(Player.getCurrentServ());// sauvegarde du dernier serveur que le joueur a visite
				Player.setCurrentServ(voisins[numServeur]);
				GenerationAffichage.tempsdechargement();
				System.out.println("Vous etes connecte au " + voisins[numServeur].getName());
				System.out.println("Le serveur vous prendra desormais pour son utilisateur habituel: "
						+ Player.getCurrentServ().getUsername());
			}
		}
	}

	/*
	 * Creer un objet fenetre
	 */
	public static void map() {
		GenerationAffichage.tempsdechargement();
		System.out.println("Ouverture de la fenetre du reseau...");
		Fenetre n = new Fenetre();
	}

	/*
	 * affiche la liste des fichiers que le serveur sur lequel le joueur est
	 * positionne possede demande quel numero de fichier le joueur veut, et le
	 * telecharge si le fichier s'appelle "sudoku.java", affiche le message de
	 * victoire au joueur UTILISATION DE GenerationAffichage : contient les lignes
	 * de codes necessaire a l'execution
	 */
	public static void download() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bonjour " + Player.getCurrentServ().getUsername() + " !");// affichage du nom de l'user du
																						// serveur
		if (Player.getCurrentServ().hasmdp()) { // si le serveur a un mdp, le joueur doit le taper pour pouvoir
												// telecharger les fichiers
			System.out.println("Mot de passe ?");
			String mdp = sc.nextLine();

			if (Player.getCurrentServ().getmdp().equals(mdp)) { // si le joueur a entre le bon mot de passe
				GenerationAffichage.download();
			} else {
				System.out.println("ERROR : mot de passe incorrect, veuillez reessayer");
			}
		} else { // si le serveur n'est pas protege par un mot de passe
			GenerationAffichage.download();
		}

	}
	
	/*
	 * Recupere le serveur actuel du Joueur Affiche l'attribut adresse ip du serveur
	 * affiche les serveurs connectes au serveur actuel affiche l'attribut bnet du
	 * Joueur affiche l'etat de l'inventaire du joueur (competences + bitcoins)
	 */
	
	public static void ifconfig() {
		System.out.println("***********************************************************************");
		System.out.println("Actuellement connecte a� :" + Player.getCurrentServ().getName());
		System.out.println("IP adress: " + Player.getCurrentServ().getIp());
		System.out.println("Serveurs Connectes: ");
		Server[] voisins = Player.getCurrentServ().getVoisins();// affiche la liste des serveurs connectÃ©s au serveur
																// courant
		for (int i = 0; i < voisins.length; i++) {
			System.out.println("-" + voisins[i].getName());
		}
		System.out.println("Puissance du botnet : " + Player.getbnetplayer());
		System.out.println("Bitcoins : " + Player.getbitcoin());
		System.out.println("Competences : ");
		// System.out.println("(true = vous pouvez vous servir de cette commande / false
		// : achetez le materiel necessaire (commande : shop) pour la debloquer)");
		System.out.println("backtrack : " + Player.getInventaire().getbacktrack());
		System.out.println("kill : " + Player.getInventaire().getkill());
		System.out.println("steal : " + Player.getInventaire().getsteal());// changer le nom de cette commande
		System.out.println("bruteforce : " + Player.getInventaire().getbruteforce());
		System.out.println("***********************************************************************");
	}
	
	/*
	 * RÃ©cupÃ¨re le serveur actuel du Joueur Affiche chaque element du tableau
	 * "contenu" grace Ã  une boucle for
	 */
	
	public static void ls() {
		System.out.println("***********************************************************************");
		System.out.println("Contenu du serveur " + Player.getCurrentServ().getName() + ": ");
		for (int i = 0; i < Player.getCurrentServ().getContent().length; i++) {
			System.out.println(Player.getCurrentServ().getContent()[i]);
		}
	}

	/*
	 * Affiche une liste des commandes possibles et une breve explication Ã  leur
	 * sujet
	 */
	public static void help() {
		System.out.println("**COMMAND LIST*********************************************************");
		System.out.println("ifconfig: affiche des informations sur l'etat actuel du joueur");
		System.out.println("ls: affiche la liste des fichiers presents sur le serveur courant");
		System.out.println("backtrack: permet de retourner au dernier serveur visite");
		System.out.println("download: liste les fichiers disponibles");
		System.out.println("connect X: se connecte au serveur voisin X");
		System.out.println("bruteforce: affiche le mot de passe d'un serveur s'il en possede un");
		System.out.println("kill: desactive l'antivirus si le niveau de botnet est suffisant");
		System.out
				.println("steal: vole les bitcoins du serveur courant (risque de se faire prendre par les autorites)");
		System.out.println("shop : permet d'acheter des ameliorations");
		System.out.println("save : sauvegarde le jeu dans l'un des 3 emplacements");
		System.out.println("load : charge la partie sauvegardee dans l'un des 3 emplacements");
		System.out.println("mine : permet de miner des bitcoins (Plus le serveur est puissant, plus il vous rapporte)");
		System.out.println("quit: ferme la session Hackatron");
	}

	public static void load(int number) {
		System.out.println("Chargement de la partie en sauvegarde");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("save_" + number + ".txt"));

			String content = reader.readLine();

			String[] temp;
			String delimeter = "/";
			temp = content.split(delimeter);
			System.out.println("argument 1 : " + temp[0]);
			Player.setPseudo(temp[0]);
			Player.setBitcoin(Double.parseDouble(temp[1]));

		} catch (IOException ex) {
			System.out.println(ex.toString());
			System.out.println("Le fichier de sauvegarde : save_"+ number +".txt  n'as pas ete trouve");
		}
	}

	public static void save(int number) {

		System.out.println("Sauvegarde du jeu en cours...");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("save_"+ number +".txt"));
			String fileContent = Player.getPseudo() + "/" + Player.getbitcoin() + "/" + Player.getbnetplayer();
			BufferedWriter writer = new BufferedWriter(new FileWriter("save_"+ number +".txt"));
			writer.write(fileContent);
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
			System.out.println("Erreur lors de la sauvegarde du jeu ! ");
		}
	}


}
