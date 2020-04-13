import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

public class ServerTest {
	
	/**
	 * Attributs qui vont servir aux tests
	 */
	String[] Stest = {"test1", "test2"};
	Server test = new Server("test", "testuser", Stest);

	@Test
	public void test_noms() {
		assertEquals("le nom doit etre 'test'", test.getName(), "test");
		assertEquals("le username doit etre 'testuser'", test.getUsername(), "testuser");
		test.setUsername("nom");
		assertEquals("le username doit etre 'nom'", test.getUsername(), "nom");
	}
	
	@Test
	public void test_antivirus() {
		test.creerAntivirus("nom", 1);
		assertEquals("doit avoir un antivirus", test.hasAntivirus(), true);
	}
	
	@Test
	public void test_mdp() {
		test.setmdp("test");
		assertEquals("doit avoir un mdp", test.hasmdp(), true);
		assertEquals("le mdp doit etre 'test'", test.getmdp(), "test");
	}
	
	@Test
	public void test_mine() {
		assertEquals("doit etre false", test.getstatutmine(), false);
		test.setmine();
		assertEquals("doit etre true", test.getstatutmine(), true);
	}
	
	@Test
	public void test_bitcoin() {
		test.deletebitcoin();
		assertEquals("doit etre a 0", test.getbitcoin(), 0, 2);
		test.setbitcoin(1.01);
		assertEquals("doit etre a 1.01", test.getbitcoin(), 1.01, 2);
	}

}
