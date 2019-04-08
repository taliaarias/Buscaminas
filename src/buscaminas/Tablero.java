package buscaminas;


import java.util.Random;

enum Dificultad{EASY,MEDIUM,HARD};

public class Tablero {
	
	private static Casilla[][] tableroInUse;
	private static Dificultad dificultadInUse;
	
	static int[] current= {0,0,0}; 
	static final int[] HARD= {99,16,30};
	static final int[] MEDIUM= {40,16,16};
	static final int[] EASY= {10,8,8};
	
	public static void inicarTablero(Dificultad dif) {

		switch (dif) {
		
		case EASY:
			current=EASY;
			break;
		case MEDIUM:
			current=MEDIUM;
			break;
		case HARD:
			current=HARD;
			break;	
		}
		
		iniciar();
	}
	

	/**
	 * @return the tableroInUse
	 */
	public static Casilla[][] getTableroInUse() {
		return tableroInUse;
	}

	/**
	 * @return the dificultadInUse
	 */
	public static Dificultad getDificultadInUse() {
		return dificultadInUse;
	}

	/**
	 * @param tablero the tableroInUse to set
	 */
	public static void setTableroInUse(Casilla[][] tablero) {
		tableroInUse = tablero;
	}

	/**
	 * @param dif the dificultadInUse to set
	 */
	public static void setDificultadInUse(Dificultad dif) {
		
		Tablero.setDificultadInUse(dif);
	}
	
	public static void iniciar() {
		
		setTableroInUse(new Casilla[current[1]][current[2]]);
		
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					getTableroInUse()[i][j]=new Casilla();
					
				}
				
			}
			
	}
	
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
	
	public static void mostrar() {
			
			for (int i = 0; i < getTableroInUse().length; i++) {
				
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					if(getTableroInUse()[i][j].hasMine())
						getTableroInUse()[i][j].setVisible(true);
					
				}
				
			}
			
		}
 
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
	
	public static void ponerMinas() {
		
		Random rand = new Random();
		int longitudmax = getTableroInUse().length;
		do {
			
			int ver=rand.nextInt(longitudmax);
			int hor=rand.nextInt(longitudmax);
			ponerMina(ver, hor);
			
		} while(!estaCompleto());
		
		
	}
	
	public static void pisar(int vert, int hor) {
		Casilla pisada = getTableroInUse()[vert][hor];
		if (pisada.hasMine()) {
			Tablero.mostrar();
		//	pisada.setVisible(true);
			
		//	} else if(!pisada.isFlagged() && !pisada.isVisible()
		//		&& pisada.getMinesArround()>0) {
		}
			pisada.setVisible(true);
				
		//	}
				
		}

	public static void flaggear(int vert, int hor) {
		Casilla pisada = getTableroInUse()[vert][hor];
		
		if (pisada.isFlagged()) pisada.setDuda(true);
		else if (pisada.isDuda()) pisada.setVisible(false);
		else pisada.setFlagged(true);
		
	}
}
