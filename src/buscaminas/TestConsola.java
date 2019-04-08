package buscaminas;

public class TestConsola {
	
		
	
	public static void main(String[] args) {
		
		Tablero.inicarTablero(Dificultad.MEDIUM);
		Tablero.ponerMina(0, 0);
		Tablero.ponerMina(2, 2);
		Tablero.ponerMina(0, 2);
		Tablero.imprime();
	}

}
