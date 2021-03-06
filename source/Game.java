package source;
import java.util.List;
import java.util.Scanner;

public class Game {

	public Game() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		Player.getInstance();
		Command c = new Command();
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

		new Store(difficulty);

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
				Command.ls();
				break;
			case "help":
				Command.help();
				break;
			case "backtrack":
				Command.backtrack();
				break;
			case "ifconfig":
				Command.ifconfig();
				break;
			case "connect":
				Command.connect(c.getWord2());
				break;
			case "map":
				Command.map();
				break;
			case "bruteforce":
				Command.bruteforce();
				break;
			case "download":
				Command.download();
				break;
			case "kill":
				Command.kill(c.getWord2());
				break;
			case "steal":
				Command.steal();
				break;
			case "shop":
				Command.shop();
				Store.setlastlevelbotnet();
				break;
			case "mine":
				Command.mine();
				break;
			case "save":
				Command.save(Integer.parseInt(c.getWord2()));
				break;
			case "load":
				Command.load(Integer.parseInt(c.getWord2()));
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
		GenerationAffichage.QuitGame();
		sc.close();
	}
	
}
