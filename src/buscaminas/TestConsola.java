package buscaminas;

public class TestConsola {
		
	/**
	 * Método de prueba para testear el programa.
	 * Debe salir en blanco, ya que está todo oculto.
	 * Se irán mostrando según se vayan "clickeando" las casillas,
	 * es decir, se vayan "flageando" o "pisando". 
	 * Si se ejecuta este ejemplo en concreto sale: "?F"; ya que
	 * al flagear 2 veces la misma casilla se convierte en duda, y la
	 * que es flageada una vez, la marca con "F".
	 * @param args hay que pasarle los argumentos.
	 * @void no devuelve nada.
	 */
	public static void main(String[] args) {
		
		Tablero.iniciarTablero(Dificultad.MEDIUM);
		Tablero.ponerMina(0, 0);
		Tablero.ponerMina(2, 2);
		Tablero.ponerMina(0, 2);
		Tablero.flaggear(0, 2);
		Tablero.flaggear(0, 3);
		Tablero.flaggear(0, 2);
		Tablero.imprime();
	}

}
