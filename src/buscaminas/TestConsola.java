package buscaminas;

public class TestConsola {
		
	/**
	 * Método de prueba para testear el programa.
	 * Debe salir en blanco, ya que está todo oculto.
	 * Se irán mostrando según se vayan "clickeando" las casillas,
	 * es decir, se vayan "flageando" o "pisando". 
	 * @param args hay que pasarle los argumentos.
	 * @void no devuelve nada.
	 */
	public static void main(String[] args) {
		
		Tablero.iniciarTablero(Dificultad.MEDIA);
		Tablero.ponerMinas();
		Tablero.imprime();
	}

}
