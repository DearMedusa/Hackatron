package source;
import java.util.Scanner;

public abstract class Command {

	/*
	 * Classe qui gere le traitement et l'execution des commandes que le joueur
	 * input
	 */

	/*
	 * Attributs
	 *
	 * @param word1 String, le premier mot de la commande
	 *
	 * @param word2 String, le deuxiÃ¨me mot de la commande
	 */
	private String word1;
	private String word2;

	/*
	 * Constructeur qui crÃ©er une commande avec ses paramÃ¨tres null
	 */
	public Command() {
		this.word1 = null;
		this.word2 = null;
	}

	/*
	 * Methode Input Affiche le pseudo du joueur RÃ©cupÃ¨re l'input de
	 * l'utilisateur le stock dans un tableau "mots" Definit mots[0] comme Ã©tant
	 * l'attribut word1 Definit mots[1] comme Ã©tant l'attribut word2 si l'input
	 * contient un espace
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
