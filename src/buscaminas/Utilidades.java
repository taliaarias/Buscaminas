package buscaminas;


import java.util.Random;



public class Utilidades {


	public static void ponerMinasTest(Tablero tablero) {
		
		Random rand = new Random();
		do {
			
			int ver=rand.nextInt(Tablero.IN_USE[1]-1), hor=rand.nextInt(Tablero.IN_USE[2]-1);
			ponerMina(tablero, ver, hor);
			
		} while(!tablero.estaCompleto());
		
		
	}
	public static void ponerMina(Tablero tablero, int vert, int hor) {
		tablero.getTableroInUse()[vert][hor].setHasMine(true);
		for (int i = vert-1; i <= vert+1 ; i++) {
			for (int j = hor-1; j <= hor+1; j++) {
				
				if (i>=0 && i<=tablero.getTableroInUse().length && j>=0 && j<=tablero.getTableroInUse().length) {
					
					tablero.getTableroInUse()[i][j].sumarCuenta();
					
				}
			}
			
		}
	}
				
	public static void pisar(Tablero tablero, int vert, int hor) {
		
		if(!tablero.getTableroInUse()[vert][hor].isFlagged() && !tablero.getTableroInUse()[vert][hor].isVisible()) 
			
				tablero.getTableroInUse()[vert][hor].setVisible(true);
				
			
				
		}
		

	
	public static void flaggear(Tablero tablero, int vert, int hor) {
		
		if (!tablero.getTableroInUse()[vert][hor].isFlagged() && !tablero.getTableroInUse()[vert][hor].isVisible())
			
			tablero.getTableroInUse()[vert][hor].setFlagged(true);
		
	}
	
	
	
	/*
	public static boolean valid(int vert, int hor) {
		boolean valid=false;
		if (vert>0 && vert <Tablero.IN_USE[1] && hor>0 && hor <Tablero.IN_USE[2]) {
			valid=true;
		}
		return valid;

	}
	*/
}
