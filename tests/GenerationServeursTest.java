package tests;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import source.GenerationServeurs;
import source.Server;

/**
 * 
 */

public class GenerationServeursTest {

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		GenerationServeurs.resetTabServer();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		GenerationServeurs.resetTabServer();
	}

	@Test
	public void test_difficulte_facile() {
		GenerationServeurs.Create(1);
		List<Server> test = GenerationServeurs.getTabServer();
		Server ServerTest = test.get(0);
		
		boolean vraie = false;
		if(ServerTest.getVoisins().length >= 5) {
			vraie = true;
		}
		
		assertEquals("le nom doit etre serveur0", ServerTest.getName(), "serveur0");
		assertEquals("serveur0 ne doit pas avoir d'antivirus", ServerTest.hasAntivirus(), false);
		assertEquals("serveur0 doit avoir au moins 5 connexions", true, vraie);
		
		boolean ServGagnant = false;
		for(int i = 0; i < test.size(); i++) {
			if(test.get(i).getUsername() == "Roegel") {
				ServGagnant = true;
			}
		}
		
		assertEquals("le serveur gagnant doit exister", true, ServGagnant);	
	}
	
	@Test
	public void test_difficulte_normale() {
		GenerationServeurs.Create(2);
		List<Server> test = GenerationServeurs.getTabServer();
		Server ServerTest = test.get(0);
		
		boolean vraie = false;
		if(ServerTest.getVoisins().length >= 5) {
			vraie = true;
		}
		
		assertEquals("le nom doit etre serveur0", ServerTest.getName(), "serveur0");
		assertEquals("serveur0 ne doit pas avoir d'antivirus", ServerTest.hasAntivirus(), false);
		assertEquals("serveur0 doit avoir au moins 5 connexions", true, vraie);
		
		boolean ServGagnant = false;
		for(int i = 0; i < test.size(); i++) {
			if(test.get(i).getUsername() == "Roegel") {
				ServGagnant = true;
			}
		}
		
		assertEquals("le serveur gagnant doit exister", true, ServGagnant);	
	}
	
	@Test
	public void test_difficulte_difficile() {
		GenerationServeurs.Create(3);
		List<Server> test = GenerationServeurs.getTabServer();
		Server ServerTest = test.get(0);
		
		boolean vraie = false;
		if(ServerTest.getVoisins().length >= 5) {
			vraie = true;
		}
		
		assertEquals("le nom doit etre serveur0", ServerTest.getName(), "serveur0");
		assertEquals("serveur0 ne doit pas avoir d'antivirus", ServerTest.hasAntivirus(), false);
		assertEquals("serveur0 doit avoir au moins 5 connexions", true, vraie);
		
		boolean ServGagnant = false;
		for(int i = 0; i < test.size(); i++) {
			if(test.get(i).getUsername() == "Roegel") {
				ServGagnant = true;
			}
		}
		
		assertEquals("le serveur gagnant doit exister", true, ServGagnant);	
	}

}
