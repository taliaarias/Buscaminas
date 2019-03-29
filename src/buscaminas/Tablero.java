package buscaminas;


import java.util.Random;

enum dificultad{EASY,MEDIUM,HARD};

public class Tablero {
	
	 
	
	public Casilla[][] tableroInUse;
	private dificultad dificultadInUse;
	
	int[] IN_USE= {0,0,0}; 
	static final int[] HARD= {99,16,30};
	static final int[] MEDIUM= {40,16,16};
	static final int[] EASY= {10,8,8};
	
	public Tablero(dificultad dif) {
		
		
		if(dif==dificultad.EASY) {
			IN_USE=EASY;
		} else if(dif==dificultad.MEDIUM) {
			IN_USE=MEDIUM;
		} else if(dif==dificultad.HARD) {
			IN_USE=HARD;
		}	
		setTableroInUse(new Casilla[IN_USE[1]][IN_USE[2]]);
		iniciar();
		
	}

	/**
	 * @return the tableroInUse
	 */
	public Casilla[][] getTableroInUse() {
		return tableroInUse;
	}

	/**
	 * @return the dificultadInUse
	 */
	public dificultad getDificultadInUse() {
		return dificultadInUse;
	}

	/**
	 * @param tableroInUse the tableroInUse to set
	 */
	public void setTableroInUse(Casilla[][] tableroInUse) {
		this.tableroInUse = tableroInUse;
	}

	/**
	 * @param dificultadInUse the dificultadInUse to set
	 */
	public void setDificultadInUse(dificultad dificultadInUse) {
		this.dificultadInUse = dificultadInUse;
	}
	
	public void iniciar() {
		
		{
			
			for (int i = 0; i < this.getTableroInUse().length; i++) {
				
				for (int j=0; j < this.getTableroInUse()[i].length; j++) {
					
					this.tableroInUse[i][j]=new Casilla();
					
				}
				
			}
			
		}
	}
	
	public void imprime() {
		{
			
			for (int i = 0; i < this.getTableroInUse().length; i++) {
				
				for (int j=0; j < this.getTableroInUse()[i].length; j++) {
					
					System.out.print(tableroInUse[i][j]);
					
				}
				System.out.println();
				System.out.println();
				
			}
		 
		}
	}
	
	public boolean estaCompleto() {
			
			boolean completo = false;
			int cont = 0;
			
			for (int i = 0; i < getTableroInUse().length; i++) {
				for (int j=0; j < getTableroInUse()[i].length; j++) {
					
					if (cont==IN_USE[0]) {
						
						completo=true;
						break;
					}
					
					else if (tableroInUse[i][j].hasMine()) cont++ ;
					
					
				}
			}
			
			return completo;
	}
	
	public void mostrar() {
			
			for (int i = 0; i < this.getTableroInUse().length; i++) {
				
				for (int j=0; j < this.getTableroInUse()[i].length; j++) {
					if(this.tableroInUse[i][j].hasMine())
					this.tableroInUse[i][j].setVisible(true);
					
				}
				
			}
			
		}
 
	public void ponerMina(int vert, int hor) {
		
		this.getTableroInUse()[vert][hor].setHasMine(true);
		
		for (int i = vert-1; i <= vert+1 ; i++) {
			for (int j = hor-1; j <= hor+1; j++) {
				
				if (i>=0 && i<=this.getTableroInUse().length && j>=0 && j<=this.getTableroInUse().length) {
					
					this.getTableroInUse()[i][j].sumarCuenta();
					
				}
			}
			
		}
	}
	
	public void ponerMinas() {
		
		Random rand = new Random();
		do {
			
			int ver=rand.nextInt(getTableroInUse().length-1), hor=rand.nextInt(getTableroInUse()[0].length-1);
			ponerMina(ver, hor);
			
		} while(!this.estaCompleto());
		
		
	}
	
	public void pisar(int vert, int hor) {
		Casilla pisada = this.getTableroInUse()[vert][hor];
	//	if (pisada.hasMine()) {
			
		//	pisada.setVisible(true);
			
		//	} else if(!pisada.isFlagged() && !pisada.isVisible()
		//		&& pisada.getMinesArround()>0) {
			
			pisada.setVisible(true);
				
		//	}
				
		}

	public  void flaggear(int vert, int hor) {
		Casilla pisada = this.getTableroInUse()[vert][hor];
		if (pisada.isFlagged()) {
				
			pisada.setFlagged(false);
			
		}
		
		else pisada.setFlagged(true);
		
	}
}
