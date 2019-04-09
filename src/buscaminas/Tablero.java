package buscaminas;


import java.util.Random;

enum Dificultad{EASY,MEDIUM,HARD};

public class Tablero {
	
	//propiedades.
	private static Casilla[][] tableroInUse;
	private static Dificultad dificultadInUse;
	
	static int[] current= {0,0,0}; 
	static final int[] HARD= {99,16,30};
	static final int[] MEDIUM= {40,16,16};
	static final int[] EASY= {10,8,8};
	
	/**
	 * Método que inicia el tablero según el grado de dificultad escogido.
	 * @param dif el grado de dificultad.
	 * @void no devuelve nada.
	 */
	
	public static void iniciarTablero(Dificultad dif) {

		switch (dif) {
		
		case EASY:
			current=EASY;
			setDificultadInUse(dif);
			break;
		case MEDIUM:
			current=MEDIUM;
			setDificultadInUse(dif);
			break;
		case HARD:
			current=HARD;
			setDificultadInUse(dif);
			break;	
		}
		
		iniciar();
	}
	

	//getters and setters
	
	/**
	 * @return devuelve el tablero.
	 */
	public static Casilla[][] getTableroInUse() {
		return tableroInUse;
	}

	/**
	 * @return devuelve el grado de dificultad.
	 */
	public static Dificultad getDificultadInUse() {
		return dificultadInUse;
	}

	/**
	 * @param para establecer el tablero.
	 * @void no devuelve nada.
	 */
	public static void setTableroInUse(Casilla[][] tablero) {
		tableroInUse = tablero;
	}

	/**
	 * @param dif para establecer la dificultad.
	 * @void no devuelve nada.
	 */
	public static void setDificultadInUse(Dificultad dif) {
		
		Tablero.setDificultadInUse(dif);
	}
	
	/**
	 * Método para iniciar el tablero.
	 * @void no devuelve nada.
	 */
	public static void iniciar() {
		
		setTableroInUse(new Casilla[current[1]][current[2]]);
		
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					getTableroInUse()[i][j]=new Casilla();
					
				}		
			}	
	}
	
	/**
	 * Método que muestra el tablero.
	 * @void no devuelve nada.
	 */
	public static void imprime() {
		
		{			
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					System.out.print(getTableroInUse()[i][j]);
					
				}
				System.out.println();
				System.out.println();			
			}
		}
	}
	
	/**
	 * Método para indicar si ya está el tablero completo.
	 * @return boolean.
	 */
	public static boolean estaCompleto() {
			
			boolean completo = false;
			int cont = 0;
			
			for (int i = 0; i < getTableroInUse().length; i++) {
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					if (cont==current[0]) {
						
						completo=true;
						break;
					}
					
					else if (getTableroInUse()[i][j].hasMine()) cont++ ;
								
				}
			}
			
			return completo;
	}
	
	/**
	 * Método vacío que muestra el tablero.
	 * @void no devuelve nada.
	 */
	public static void mostrar() {
			
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					if(getTableroInUse()[i][j].hasMine())
						getTableroInUse()[i][j].setVisible(true);
					
				}
				
			}
			
		}
 
	/**
	 * Método que pone una mina en el tablero.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void ponerMina(int vert, int hor) {
		
		getTableroInUse()[vert][hor].setHasMine(true);
		
		for (int i = vert-1; i <= vert+1 ; i++) {
			for (int j = hor-1; j <= hor+1; j++) {
				
				if (i>=0 && i<getTableroInUse().length && j>=0 && j<getTableroInUse()[0].length) {
					
					getTableroInUse()[i][j].sumarCuenta();
					
				}
			}
			
		}
	}
	
	/**
	 * Método que basándose en el de "ponerMina" va completando
	 * el tablero con las minas correspondientes hasta que está completo.
	 * @void no devuelve nada.
	 */
	public static void ponerMinas() {
		
		Random rand = new Random();
		int longitudmax = getTableroInUse().length;
		do {
			
			int ver=rand.nextInt(longitudmax);
			int hor=rand.nextInt(longitudmax);
			ponerMina(ver, hor);
			
		} while(!estaCompleto());
		
		
	}
	
	/**
	 * Método que muestra las casillas que se van "clickeando", y
	 * refleja si hay un número, nada o una mina.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void pisar(int vert, int hor) {
		
		Casilla pisada = getTableroInUse()[vert][hor];
		
		if(!pisada.isVisible()) {
			pisada.setVisible(true); 
			
			if(pisada.getMinesArround()==0) {
				
				for (int i = vert-1; i <= vert+1 ; i++) {
					for (int j = hor-1; j <= hor+1; j++) {
							//getTableroInUse()[i][j].setVisible(true);
						//Tablero.mostrar();
					//pisar(vert, hor);
							//imprime();
						if (i>=0 && i<getTableroInUse().length && j>=0 && j<getTableroInUse()[0].length) {
						//	getTableroInUse()[i][j].setVisible(true);
						//pisada.isVisible();
						  // int vert = pisada[vert];
						 //  int hor = pisada[hor];
							 //pisar(vert, hor); // PETAAAAA
							//imprime();
							pisar(vert-1, hor);
							pisar(vert-1, hor-1);
							pisar(vert-1, hor+1);
							pisar(vert, hor-1);
							pisar(vert, hor+1);
							pisar(vert+1, hor-1);
							pisar(vert+1, hor);
							pisar(vert+1, hor+1);
						}
					}
				}
			}
		}
		
		pisada.setVisible(true);
				
		}

	/*public static void pisar(int vert, int hor) {
		
		Casilla pisada = getTableroInUse()[vert][hor];
		
		if(!pisada.isVisible()) {
			pisada.setVisible(true); 
			//en el papel teníais puesto que hay que poner FALSE pero no lo entiendo.
			
			do { //NO HACERRRRR. ENTRA EN BUCLE INFINITO 
			
				for (int i = vert-1; i <= vert+1 ; i++) {
					for (int j = hor-1; j <= hor+1; j++) {
							//getTableroInUse()[i][j].setVisible(true);
						//Tablero.mostrar();
					//pisar(vert, hor);
							//imprime();
						if (i>=0 && i<getTableroInUse().length && j>=0 && j<getTableroInUse()[0].length) {
						//	getTableroInUse()[i][j].setVisible(true);
						//pisada.isVisible();
							 //pisar(vert, hor); // PETAAAAA
							//imprime();
							
						}
					}
				}
			}while(pisada.getMinesArround()<1);
			
		}
		
		pisada.setVisible(true);
				
		}*/
	
	/**
	 * Método que al "clickear" con el botón derecho etiqueta las casillas.
	 * Si pulsas 1 vez, pone "F".
	 * Si pulsas 2 veces, pone "?".
	 * Si pulsas 3 veces, la deja en blanco.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void flaggear(int vert, int hor) {
		
		Casilla pisada = getTableroInUse()[vert][hor];
		
		if (pisada.isFlagged()) pisada.setDuda(true);
		else if (pisada.isDuda()) pisada.setVisible(false);
		else pisada.setFlagged(true);
		
	}
}
