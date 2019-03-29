package buscaminas;

public class TestConsola {
	
	static Tablero miTablero = new Tablero(Tablero.dificultad.MEDIUM);	
	
	public static void main(String[] args) {
		
		
			Utilidades.ponerMina(miTablero, 0, 0);
			Utilidades.ponerMina(miTablero, 2, 2);
			Utilidades.ponerMina(miTablero, 0, 2);
			miTablero.ponerMinas();
			miTablero.imprime();
	}

}
