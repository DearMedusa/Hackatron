package source;
import java.util.List;
import java.util.Scanner;

public class Game {

	public Game() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		Player.getInstance();
		CommandeBasique cb = new CommandeBasique();
		CommandeShop cs = new CommandeShop();
		GenerationAffichage I = new GenerationAffichage();
		Rng.getInstance();

		// INTRO
		GenerationAffichage.Logo();
		GenerationAffichage.Introduction();

		//DEFINITION DU PSEUDO
		Player.setPseudo(sc.nextLine());

		GenerationAffichage.NomUser();
		
		//DEFINITION DE LA DIFFICULTE
		GenerationAffichage.SetDifficulte();
		String choice = sc.nextLine();
		int difficulty;
		switch (choice) {
			case "1":
				System.out.println("Votre niveau de difficulte a ete defini sur :");
				System.out.println("Facile");
				difficulty = 1;
				break;
			case "2":
				System.out.println("Votre niveau de difficulte a ete defini sur :");
				System.out.println("Normal");
				difficulty = 2;
				break;
			case "3":
				System.out.println("Votre niveau de difficulte a ete defini sur :");
				System.out.println("Difficile");
				difficulty = 3;
				break;
			default:
				System.out.println("Votre niveau de difficulte a ete defini sur :");
				System.out.println("Normal");
				difficulty = 2;
				break;
		}

		System.out.println("Tapez HELP pour obtenir des informations sur les commandes disponibles");

		//CREATION DU SHOP EN FONCTION DU NIVEAU DE DIFFICULTE CHOISIE
		Store store = new Store(difficulty);

		//GENERATION DE LA BARRE DE VIE DU JOUEUR EN FONCTION DE LA DIFFICULTE
		Player.setlife(difficulty);

		//GENERATION DE LA RNG EN FONCTION DE LA DIFFICULTE
		Rng.SetDifficulty(difficulty);

		//CREATION DES SERVEURS EN FONCTION DE LA DIFFICULTE
		GenerationServeurs.getInstance();
		GenerationServeurs.Create(difficulty);
		List<Server> TabServeurs = GenerationServeurs.getTabServer();

		//DEFINITION DU SERVEUR DE DEPART
		Player.setCurrentServ(TabServeurs.get(0));

		//GAME LOOP

		while (running) {
			c.input(sc);
			// interactions
			switch (c.getWord1()) {
			case "quit":
				running = false;
				break;
			case "ls":
				CommandeBasique.ls();
				break;
			case "help":
				CommandeBasique.help();
				break;
			case "backtrack":
				CommandeShop.backtrack();
				break;
			case "ifconfig":
				CommandeBasique.ifconfig();
				break;
			case "connect":
				CommandeBasique.connect(c.getWord2());
				break;
			case "map":
				CommandeBasique.map();
				break;
			case "bruteforce":
				CommandeShop.bruteforce();
				break;
			case "download":
				CommandeBasique.download();
				break;
			case "kill":
				CommandeShop.kill(c.getWord2());
				break;
			case "steal":
				CommandeShop.steal();
				break;
			case "shop":
				CommandeBasique.shop();
				break;
			case "mine":
				CommandeBasique.mine();
				break;
			case "save":
				CommandeBasique.save(Integer.parseInt(c.getWord2()));
				break;
			case "load":
				CommandeBasique.load(Integer.parseInt(c.getWord2()));
				break;
			default:
				System.out.println("ERREUR : commande inconnue");
				break;
			}

			//EVENEMENTS ALEATOIRES
			Events.EventAleatoire();

			//CONDITION DE LOSE
			if(Player.getlife() == 0){
				System.out.println("Perdu !");
				running = false;
			}
		}
		I.QuitGame();

	}
	
}
