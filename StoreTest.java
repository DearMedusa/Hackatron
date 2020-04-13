import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * teste le store, sa methode d'achat, et les methodes de reset de player et inventaire
 */

public class StoreTest {
	
	@After
	public void teardown() {
		Player.defaultlvl(); //retabli le lvl du joueur apres chaque test
		Inventaire.resetInventory(); //reset l'inventaire
	}
	
	@Test
	public void test_difficulte_facile() {
		int difficulty = 1;
		new Store(difficulty);
		Player.getInstance();
		Player.setlife(difficulty);
		Player.setBitcoin(20);
		Inventaire.getInstance();
		
		
		Store.choicesBUY("1", "y");
		assertEquals("doit etre true", Inventaire.getbacktrack(), true);
		
		Store.choicesBUY("2", "y");
		assertEquals("doit etre true", Inventaire.getkill(), true);
		
		Store.choicesBUY("3", "y");
		assertEquals("doit etre true", Inventaire.getsteal(), true);
		
		Store.choicesBUY("4", "y");
		assertEquals("doit etre true", Inventaire.getbruteforce(), true);
		
		Store.choicesBUY("5", "y");
		assertEquals("doit etre egal a 2", Player.getbnetplayer(), 2);
	}
	
	@Test
	public void test_difficulte_normale() {
		int difficulty = 2;
		new Store(difficulty);
		Player.getInstance();
		Player.setlife(difficulty);
		Player.setBitcoin(20);
		Inventaire.getInstance();
		
		
		Store.choicesBUY("1", "y");
		assertEquals("doit etre true", Inventaire.getbacktrack(), true);
		
		Store.choicesBUY("2", "y");
		assertEquals("doit etre true", Inventaire.getkill(), true);
		
		Store.choicesBUY("3", "y");
		assertEquals("doit etre true", Inventaire.getsteal(), true);
		
		Store.choicesBUY("4", "y");
		assertEquals("doit etre true", Inventaire.getbruteforce(), true);
		
		Store.choicesBUY("5", "y");
		assertEquals("doit etre egal a 2", Player.getbnetplayer(), 2);
	}
	
	@Test
	public void test_difficulte_difficile() {
		int difficulty = 3;
		new Store(difficulty);
		Player.getInstance();
		Player.setlife(difficulty);
		Player.setBitcoin(20);
		Inventaire.getInstance();
		
		
		Store.choicesBUY("1", "y");
		assertEquals("doit etre true", Inventaire.getbacktrack(), true);
		
		Store.choicesBUY("2", "y");
		assertEquals("doit etre true", Inventaire.getkill(), true);
		
		Store.choicesBUY("3", "y");
		assertEquals("doit etre true", Inventaire.getsteal(), true);
		
		Store.choicesBUY("4", "y");
		assertEquals("doit etre true", Inventaire.getbruteforce(), true);
		
		Store.choicesBUY("5", "y");
		assertEquals("doit etre egal a 2", Player.getbnetplayer(), 2);
	}
	
	
	

}
