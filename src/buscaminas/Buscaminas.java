package buscaminas;


public class Buscaminas {

	static Tablero miTablero = new Tablero(Tablero.dificultad.EASY);
	
	
	public static void main(String[] args) {

		//miTablero.imprime();		
	//	Utilidades.ponerMina(miTablero, 0, 0);
	//	Utilidades.ponerMina(miTablero, 2, 2);
	//	Utilidades.ponerMina(miTablero, 0, 2);
		miTablero.ponerMinas();
		miTablero.flaggear(0, 0);
		miTablero.pisar(0, 0);
		miTablero.pisar(1, 1);
		miTablero.imprime();
	}

}