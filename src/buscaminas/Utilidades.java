package buscaminas;

import java.util.Random;


public class Utilidades {

	/**
	 * Método de prueba para probar que va poniendo minas
	 * hasta que el tablero está lleno.
	 * @param tablero
	 * @void no devuelve nada.
	 */
	public static void ponerMinasTest(Tablero tablero) {
		
		Random rand = new Random();
		do {
			
			int ver=rand.nextInt(Tablero.current[1]-1), hor=rand.nextInt(Tablero.current[2]-1);
			ponerMina(tablero, ver, hor);
			
		} while(!tablero.estaCompleto());
		
		
	}
	
	/**
	 * Método para probar que se pone bien una mina en el tablero.
	 * @param tablero.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void ponerMina(Tablero tablero, int vert, int hor) {
		
		tablero.getTableroInUse()[vert][hor].setHasMine(true);
		for (int i = vert-1; i <= vert+1 ; i++) {
			for (int j = hor-1; j <= hor+1; j++) {
				
				if (i>=0 && i<=tablero.getTableroInUse().length && j>=0 && j<=tablero.getTableroInUse().length) {
					
					tablero.getTableroInUse()[i][j].sumarCuenta();
					
				}
			}
		}
	}
	
	/**
	 * Método que prueba que funciona el cambio de estado de las casillas
	 * cuando se hace "click" sobre ellas.
	 * @param tablero.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void pisar(Tablero tablero, int vert, int hor) {
		
		if(!tablero.getTableroInUse()[vert][hor].isFlagged() && !tablero.getTableroInUse()[vert][hor].isVisible()) 
			
				tablero.getTableroInUse()[vert][hor].setVisible(true);	
				
		}

	/**
	 * Método que prueba que funciona el cambio de etiqueta de las casillas
	 * cuando se hace "click-derecho" sobre ellas.
	 * @param tablero.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void flaggear(Tablero tablero, int vert, int hor) {
		
		if (!tablero.getTableroInUse()[vert][hor].isFlagged() && !tablero.getTableroInUse()[vert][hor].isVisible())
			
			tablero.getTableroInUse()[vert][hor].setFlagged(true);
		
	}
	
}
