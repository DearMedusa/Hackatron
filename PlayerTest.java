import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

public class PlayerTest {
	
	@Test
	public void test_difficulte_life() {
		Player.setlife(1);
		assertEquals("la vie doit etre de 20", Player.getlife(), 20);

		Player.setlife(2);
		assertEquals("la vie doit etre de 10", Player.getlife(), 10);

		Player.setlife(3);
		assertEquals("la vie doit etre de 5", Player.getlife(), 5);
		
		Player.decreaselife();
		assertEquals("la vie doit etre de 4", Player.getlife(), 4);
	}
	
	@Test
	public void test_bitcoin() {
		double bitcoin = 0.5;
		Player.setBitcoin(bitcoin);
		assertEquals("bitcoin doit etre egal a 0.5", Player.getbitcoin(), bitcoin, 2);
		Player.decreasebitcoin(0.1);
		assertEquals("bitcoin doit etre egal a 0.4", Player.getbitcoin(), 0.4, 2);
		Player.deletebitcoin();
		assertEquals("bitcoin doit etre nul", Player.getbitcoin(), 0, 2);
	}

	@Test
	public void test_pseudo() {
		String pseudo = "test";
		Player.setPseudo(pseudo);
		assertEquals("Le pseudo doit etre 'test", Player.getPseudo(), pseudo);
	}
	
	@Test
	public void test_lvl() {
		Player.increaselvl();
		assertEquals("le lvl doit etre de 1", Player.getbnetplayer(), 1);
	}
	
	@Test
	public void test_server() {
		String[] Stest = {};
		Server test = new Server("test", "test", Stest);
		Player.setCurrentServ(test);
		assertEquals("Le server doit etre test", Player.getCurrentServ(), test);
		Player.setLastServer(test);
		assertEquals("Le lastserver doit etre test", Player.getLastServer(), test);
	}

	
}
