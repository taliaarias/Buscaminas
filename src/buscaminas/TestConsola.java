package buscaminas;

public class TestConsola {
	
	static Tablero miTablero = new Tablero(dificultad.MEDIUM);	
	
	public static void main(String[] args) {
		
		
		miTablero.ponerMina(0, 0);
		miTablero.ponerMina(2, 2);
		miTablero.ponerMina(0, 2);
		miTablero.imprime();
	}

}
