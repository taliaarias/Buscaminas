package buscaminas;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * Clase de Prueba para testear "Tablero".
 * @author Pedro y Talia.
 *
 */
public class TableroTest {


	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		Tablero.iniciarTablero(Dificultad.EASY);
		
	}


	@Test
	public void testIniciarTablero() {
		
		System.out.println("Introducimos una dificultad reconocida");
		 assertEquals(Dificultad.EASY, Tablero.getDificultadInUse());
	}

	@Test
	public void testIniciarTablero2() {
		System.out.println("Introducimos una dificultad NO reconocida");
		
	}
	
	@Test
	public void testGetTableroInUse() {
		//System.out.println("Introducimos un tablero");
		//assertNotNull(tablero2);
		//assertEquals(tablero2, tablero2.getTableroInUse());
	}

	@Test
	public void testGetDificultadInUse() {
		System.out.println("Introducimos una dificultad existente");
		assertEquals(10, Dificultad.EASY.compareTo(null));
	}

	@Test
	public void testGetDificultadInUse2() {
		System.out.println("Introducimos una dificultad NO existente");
		//assertEquals(10, Dificultad.IMPOSSIBLE.compareTo(null));
	}
	@Test
	public void testSetTableroInUse() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDificultadInUse() {
		fail("Not yet implemented");
	}

	@Test
	public void testIniciar() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprime() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstaCompleto() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrar() {
		fail("Not yet implemented");
	}

	@Test
	public void testPonerMina() {
		fail("Not yet implemented");
	}

	@Test
	public void testPonerMinas() {
		fail("Not yet implemented");
	}

	@Test
	public void testPisar() {
		fail("Not yet implemented");
	}

	@Test
	public void testFlaggear() {
		fail("Not yet implemented");
	}

}
