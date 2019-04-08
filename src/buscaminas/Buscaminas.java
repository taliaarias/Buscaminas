package buscaminas;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buscaminas {
	
			
	static public JFrame frame = new JFrame("Ejemplo5 con GridLayout");
	static public JPanel contentPane = (JPanel) frame.getContentPane();
	static public JPanel interior= new JPanel();
	static Procesador procesador = new Procesador();
 	
	public Buscaminas(Dificultad dif) {
		Tablero.inicarTablero(dif);
		Tablero.ponerMinas();
		pintaBotones();
		contentPane.add(interior);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(dif==Dificultad.EASY)
		frame.setSize(400,400);
		else if(dif==Dificultad.MEDIUM)
		frame.setSize(800,800);
		else if(dif==Dificultad.HARD)
		frame.setSize(1480,800);
		frame.setVisible(true);
		//frame.setResizable(false);
		
		
	}
	
	public static void pintaBotones() {
		interior.setLayout(new GridLayout(Tablero.getTableroInUse().length,Tablero.getTableroInUse()[1].length,1,1));    
		
		for (int i=0; i<Tablero.getTableroInUse().length; i++) {
			
			for (int j=0; j<Tablero.getTableroInUse()[i].length; j++) {
			
			Botoncico botoncico= new Botoncico(Tablero.getTableroInUse()[i][j].toString(), i, j);
			botoncico.addMouseListener(procesador);
			interior.add(botoncico);
			//botoncico.setBackground(new Color(255, 255, 255));
			
			}
			
		}
	}

	
	
	public static void execBusca(Dificultad dif) {

	//	miTablero.imprime();		
	//	Utilidades.ponerMina(miTablero, 0, 0);
	//	Utilidades.ponerMina(miTablero, 2, 2);
	//	Utilidades.ponerMina(miTablero, 0, 2);
	//	miTablero.ponerMinas();

		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
		public void run() {
			@SuppressWarnings("unused")
			Buscaminas gui = new Buscaminas(dif);
		}
		});
	}
		
}