package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import source.Antivirus;

/**
 * 
 */

public class AntivirusTest {

	@Test
	public void test_constructeur() {
		Antivirus test = new Antivirus("test", 1);
		assertEquals("le nom doit etre test", test.getName(), "test");
		assertEquals("le lvl doit etre de 1", test.getlvl(), 1);
		assertEquals("this.Active doit etre true", test.getStatut(), true);
		test.disable();
		assertEquals("this.Active doit etre false", test.getStatut(), false);
	}
	
	

}
