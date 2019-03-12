package buscaminas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buscaminas {

	static Tablero miTablero = new Tablero(Tablero.dificultad.EASY);
	
	
	public Buscaminas() {
		
		JFrame frame = new JFrame("Ejemplo5 con GridLayout");
		JPanel contentPane = (JPanel) frame.getContentPane();
		JPanel interior= new JPanel();
		interior.setLayout(new GridLayout(miTablero.getTableroInUse().length  ,miTablero.getTableroInUse()[1].length,1,1));    
		
		
		for (int i=0; i<=25; i++) {
			
			interior.add(new JButton("Boton "+i));
			
		}
		
		contentPane.add(interior);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
		miTablero.ponerMinas();
		miTablero.imprime();
	}
	
	public static void main(String[] args) {

		//miTablero.imprime();		
	//	Utilidades.ponerMina(miTablero, 0, 0);
	//	Utilidades.ponerMina(miTablero, 2, 2);
	//	Utilidades.ponerMina(miTablero, 0, 2);
	//	miTablero.ponerMinas();
	//	miTablero.flaggear(0, 0);
	//	miTablero.pisar(0, 0);
	// 	miTablero.pisar(1, 1);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
		public void run() {
			@SuppressWarnings("unused")
			Buscaminas gui = new Buscaminas();
		}
		});
	}
		
}