package source;

public class CommandeShop {
	
	public CommandeShop() {
		super();
	}
	
	/*
	 * Recupere le serveur actuel du Joueur Definit son attribut "backtrack" comme
	 * etant vrai
	 */
	public static void backtrack() {
		if (Player.getInventaire().getbacktrack()) {
			GenerationAffichage.tempsdechargement();
			Player.setCurrentServ(Player.getLastServer());
			System.out.println("Vous revenez au dernier serveur visite");
		} else {
			System.out.println("ERROR : Vous n'avez pas le programme necessaire pour pouvoir effectuer cette action");
		}
	}

	/*
	 * competence achetable : affiche le mot de passe du serveur (necessaire pour
	 * pouvoir telecharger les fichiers presents sur celui ci)
	 */
	public static void bruteforce() {
		if (Player.getInventaire().getbruteforce()) { // verifie si le joueur a bruteforce sur true dans on inventaire
			if (Player.getCurrentServ().hasmdp()) { // verifie si le serveur a un mot de passe
				GenerationAffichage.tempsdechargement();
				System.out.println("Le mot de passe est : " + Player.getCurrentServ().getmdp()); // affiche le mot de
																									// passe du serveur
			} else {
				System.out.println("ERROR : ce serveur n'a pas de mot de passe");
			} // message d'erreur
		} else {
			System.out.println("ERROR : Vous n'avez pas le programme necessaire pour pouvoir effectuer cette action");
		} // message d'erreur

	}

	/**
	 * Methode servant a desactiver les antivirus d'un serveur entre en
	 * parametre @param word2
	 */
	public static void kill(String word2) {
		if (Player.getInventaire().getkill()) { // VERIFICATION si le joueur a bien la competence requise pour effectuer
												// cette action
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
			// si l'user a fait une faute de frappe, on arrete la et il doit retaper la
			// commande
			if (error == true) {
				System.out.println("ERROR : serveur inconnu, veuillez reessayer");
			}
			// sinon on passe a la partie desactivation
			else {
				Antivirus A = voisins[numServeur].getAntivirus(); // rÃ©cupÃ¨re l'antivirus

				if (A != null) { // check si le serveur a effectivement un antivirus

					if (A.getlvl() <= Player.getbnetplayer()) { // check si le lvl de l'antivirus n'est pas sup a celui
																// du joueur
						A.disable(); // dÃ©sactive l'antivirus
						GenerationAffichage.tempsdechargement();
						System.out.println("L'antivirus a ete desactive.");
						System.out.println("Antivirus de niveau " + A.getlvl());
						int chance = Rng.getRandomInt(0, 3); // 1 chance sur 2 (3 est exclu de l'intervalle)
						if (chance == 1) {
							System.out.println("Vous avez gagne 1 niveau de botnet");
							Player.increaselvl();
						}
						connect(word2);
					} else { // si le lvl du joueur est trop faible, il ne peut pas desactiver l'antivirus
						GenerationAffichage.tempsdechargement();
						System.out.println("ERROR : desactivation impossible (botnet trop faible)");
					}
				}

				else { // si le serveur n'a pas d'antivirus, on affiche un msg d'erreur
					System.out.println("ERROR : Ce serveur n'a pas d'antivirus");
				}

			}
		} else { // message d'erreur
			System.out.println("ERROR : Vous n'avez pas le programme necessaire pour pouvoir effectuer cette action");
		}
	}

	/** Methode qui sert a voler les bitcoins du serveur courant */
	public static void steal() {
		if (Player.getCurrentServ().getbitcoin() == 0) {
			System.out.println("ERROR : ce serveur ne possede pas de bitcoins");
		} else {
			if (Player.getInventaire().getsteal()) {
				if (Rng.getRng()) { // si le joueur est repere
					GenerationAffichage.msgRepere();
				} else {
					double nombredebitcoin = Player.getCurrentServ().getbitcoin(); // recupere le nbr de bitcoin que le
																					// serveur possede
					Player.increasebitcoin(nombredebitcoin); // augmente l'attribut bitcoin de player
					Player.getCurrentServ().deletebitcoin(); // diminue l'attribut bitcoin de serveur
					GenerationAffichage.tempsdechargement();
					System.out.println("Vous avez recupere " + nombredebitcoin + " bitcoins");
					System.out.println("Vous possedez maintenant " + Player.getbitcoin() + " bitcoins");
				}
			} else {
				System.out
						.println("ERROR : Vous n'avez pas le programme necessaire pour pouvoir effectuer cette action");
			}
		}
	}

}
