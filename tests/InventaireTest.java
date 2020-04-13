package tests;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import source.Inventaire;

/**
 * 
 */

public class InventaireTest {

	@AfterClass
	public void tearDownAfterClass() throws Exception {
		Inventaire.resetInventory(); //reset l'inventaire
	}
	
	@Test
	public void test_backtrack() {
		assertEquals("doit etre false", Inventaire.getbacktrack(), false);
		Inventaire.setbacktrack();
		assertEquals("doit etre true", Inventaire.getbacktrack(), true);
	}
	
	@Test
	public void test_kill() {
		assertEquals("doit etre false", Inventaire.getkill(), false);
		Inventaire.setkill();
		assertEquals("doit etre true", Inventaire.getkill(), true);
	}
	
	@Test
	public void test_steal() {
		assertEquals("doit etre false", Inventaire.getsteal(), false);
		Inventaire.setsteal();
		assertEquals("doit etre true", Inventaire.getsteal(), true);
	}
	
	@Test
	public void test_bruteforce() {
		assertEquals("doit etre false", Inventaire.getbruteforce(), false);
		Inventaire.setbruteforce();
		assertEquals("doit etre true", Inventaire.getbruteforce(), true);
	}

}
