import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		Player.getInstance();
		Command c = new Command();
		Initializer I = new Initializer();

		//Pour avoir une commande map, il sera nécessaire de mettre tout les serveurs dans un tableau, accessible depuis la classe map

		// INTRO
		I.Logo();
		I.Introduction();

		Player.setPseudo(sc.nextLine());

		I.NomUser();

		//DEFINITION DE LA DIFFICULTE
		I.SetDifficulte();
		int difficulty = sc.nextInt(); //TODO : catch les erreurs potentielles (fautes de frappes ect)

		//CREATION DU SHOP EN FONCTION DU NIVEAU DE DIFFICULTE CHOISI
		Store store = new Store(difficulty);

		//TEXTE : PAS DEFINITIF
		I.ConseilDebut();

		//CREATION DES SERVEURS
		Server[] TabServeurs = I.GenerationServeurs(difficulty);

		// DEFINITION DU SERVEUR DE DEPART
		Player.setCurrentServ(TabServeurs[0]);

		// GAME LOOP

		while (running) {
			c.input(sc);
			// interactions
			switch (c.getWord1()) {
			/*DEBUG = beta test*/
			case "DEBUG":
				Command.DEBUG();
				break;
			case "quit":
				running = false;
				break;
			case "ls":
				Command.ls();
				break;
			case "help":
				Command.help();
				break;
			case "backdoor":
				Command.backdoor();
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
				break;
			default:
				System.out.println("ERREUR : commande inconnue");
				break;
			}
		}
		I.QuitGame();
	}
}
