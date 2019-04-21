package buscaminas;


import java.util.Random;

enum Dificultad{FACIL,MEDIA,DIFICIL};

public class Tablero {
	
	//propiedades.
	private static Casilla[][] tableroInUse;
	private static Dificultad dificultadInUse;
	public static int finito;
	
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
		setDificultadInUse(dif);
		switch (dif) {
		
		case FACIL:
			current=EASY;
			break;
		case MEDIA:
			current=MEDIUM;
			break;
		case DIFICIL:
			current=HARD;
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
	 * @void
	 */
	public static void setTableroInUse(Casilla[][] tablero) {
		
		tableroInUse = tablero;
	}

	/**
	 * @param dif para establecer la dificultad.
	 * @void
	 */
	public static void setDificultadInUse(Dificultad dif) {
		
		dificultadInUse=dif;
		
	}
	
	/**
	 * Método para iniciar el tablero.
	 * @void no devuelve nada.
	 */
	public static void iniciar() {
		finito=0;
		setTableroInUse(new Casilla[current[1]][current[2]]);
		
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					getTableroInUse()[i][j]=new Casilla();
					
				}		
			}	
	}
	
	/**
	 * Método que muestra el tablero // usado para debug.
	 * @void no devuelve nada.
	 */
	public static void imprime() {
		
		{			
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					System.out.print(" "+getTableroInUse()[i][j]+" ");
					
				}
				System.out.println();
				System.out.println();			
			}
		}
	}
	
	/**
	 * Método para indicar si ya está el tablero completo (tiene tantas minas como las indicadas por la dificultad del tablero).
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
	 * Método vacío que hace visibles todas las casillas del tablero.
	 * @void
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
	 * Método que pone una mina en el tablero y suma 1 a "minesAround" de todas las casillas alrededor de la mina.
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void ponerMina(int vert, int hor) {
		
		if (!getTableroInUse()[vert][hor].hasMine()) {
			
			getTableroInUse()[vert][hor].setHasMine(true);
			
			for (int i = vert-1; i <= vert+1 ; i++) {
				for (int j = hor-1; j <= hor+1; j++) {
					
					if (i>=0 && i<getTableroInUse().length && j>=0 && j<getTableroInUse()[i].length) {
						
						if (i!=vert || j!=hor) getTableroInUse()[i][j].sumarCuenta();
						
					}
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
		int vertmax = getTableroInUse().length;
		int hormax = getTableroInUse()[0].length;
		do {
			
			int ver=rand.nextInt(vertmax);
			int hor=rand.nextInt(hormax);
			
			ponerMina(ver, hor);
			
		} while(!estaCompleto());
		
		
	}
	
	/**
	 * Método que muestra las casillas que se van "clickeando", y
	 * refleja si hay un número, nada o una mina. Explicar recursividad (y límites)
	 * @param vert índice vertical.
	 * @param hor índice horizontal.
	 * @void no devuelve nada.
	 */
	public static void pisar(int vert, int hor) {
		
		if(!ganar()) {
			
			if (vert>=0 && vert<getTableroInUse().length && hor>=0 && hor<getTableroInUse()[0].length) {
			
				Casilla pisada = getTableroInUse()[vert][hor];
					
			if(!pisada.isVisible() && !pisada.isFlagged()) {
								
				if (pisada.hasMine()) {
					Tablero.mostrar();
					Tablero.finito=1;
				}
				
				else pisada.setVisible(true); 
				
				if (pisada.getMinesArround()==0 && !pisada.hasMine()) {
					
					for (int i= vert-1; i <= vert+1 ; i++) {
						for (int j = hor-1; j <= hor+1; j++) {
							//if (i>=0 && i<getTableroInUse().length && j>=0 && j<getTableroInUse()[0].length) {
								pisar(i, j);
								//}
							}
						}
					}
				}
			}
		} 
	}
	
	
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
		
		if(!ganar()) {
		Casilla pisada = getTableroInUse()[vert][hor];
		
		if (pisada.isFlagged()) pisada.setDuda(true);
		else if (pisada.isDuda()) pisada.setVisible(false);
		else pisada.setFlagged(true);
		
		}
	}
	
	public static boolean ganar() {
		
		boolean ganado=false;
		int totalminas=current[0];
		int cont=0;
		int contPisadas=0;
		int objetivo=(current[1]*current[2])-current[0];
		
		for (int i = 0; i < getTableroInUse().length; i++) {
			
			for (int j=0; j < getTableroInUse()[i].length; j++) {
				Casilla current=getTableroInUse()[i][j];
				
				if(current.hasMine()&&current.isFlagged()) {
					cont++;					
				}
				
				if (current.isVisible()) {
					contPisadas++;
					
				}
				
				if (cont==totalminas || contPisadas==objetivo) {
					ganado=true;
					finito=2;
					break;
				}
			}
		}
		
		return ganado;
		
	} 
}
