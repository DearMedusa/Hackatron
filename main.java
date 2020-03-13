import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		Player p = Player.getInstance();
		Command c = new Command();

		// CREATION DE SERVEURS
		String[] h1 = { "" };
		Server hub = new Server("Hub server", h1);

		String[] s1 = { "NePasOuvrirEnPublic.png", "NotesDuDS.xl", "MoiQuiDanse.mp4", "ChienQuiDort.gif" };
		Server serv1 = new Server("serveur 1", s1);

		String[] s2 = { "Sudoku.java", "HistoiresDeJojo.html", "AvisDesHaters.trash" };
		Server serv2 = new Server("serveur 2", s2);

		String[] s3 = { "KaamelottIntegrale.zip", "ImagesDeCanard.png", "RickAstley.mp3", "Fortnite.exe" };
		Server serv3 = new Server("serveur 3", s3);

		String[] s4 = { "a", "a", "a", "a", "a", "a", "a" };
		Server serv4 = new Server("serveur 4", s4);

		//Pour avoir une commande map, il sera nécessaire de mettre tout les serveurs dans un tableau, accessible depuis la classe map

		// CONNEXION DES SERVEURS ENTRE EUX

		Server[] voisinsHub = { serv1, serv2, serv3, serv4 };
		hub.setVoisins(voisinsHub);
		Server[] voisinsserv1 = { hub, serv2, serv3, serv4 };
		serv1.setVoisins(voisinsserv1);
		Server[] voisinsserv2 = { hub, serv1, serv3, serv4 };
		serv2.setVoisins(voisinsserv2);
		Server[] voisinsserv3 = { hub, serv1, serv2, serv4 };
		serv3.setVoisins(voisinsserv3);

		// DEFINITION DU SERVEUR DE DEPART
		p.setCurrentServ(hub);

		// INTRO
		Initializer T = new Initializer();
		T.Logo();
		T.Introduction();

		p.setPseudo(sc.nextLine());

		T.NomUser(p);

		// GAME LOOP

		while (running) {
			c.input(p, sc);
			// interactions
			switch (c.getWord1()) {
			case "quit":
				running = false;
				break;
			case "ls":
				Command.ls(p.getCurrentServ(), p);
				break;
			case "help":
				Command.help();
				break;
			case "backdoor":
				Command.backdoor(p.getCurrentServ());
				break;
			case "ifconfig":
				Command.ifconfig(p);
				break;
			case "connect":
				Command.connect(p, c.getWord2());
				break;
			case "map":
				Command.map();
				break;
			case "bruteforce":
				Command.bruteforce();
				break;
			case "download":
				Command.download(p, Integer.valueOf(c.getWord2()));
				break;
			default:
				System.out.println("Commande Inconnue...");
				break;
			}
		}
		T.QuitGame();
	}
}
