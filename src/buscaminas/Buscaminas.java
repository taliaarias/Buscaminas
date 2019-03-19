package buscaminas;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Buscaminas {
	
	static Tablero miTablero;		
	
	public class Botoncico extends JButton {
		private static final long serialVersionUID = -6151893053086375721L;
		public int ver;
		public int hor;
		
		public Botoncico() {
			super();
		}
		
		public Botoncico(String args) {
			super(args);
		}
		
		public Botoncico(String args, int ver, int hor) {
			super(args);
			this.setVer(ver);
			this.setHor(hor);
		}
		
		public int getVer() {
			return ver;
		}

		public int getHor() {
			return hor;
		}
		
		public void setVer(int ver) {
			this.ver = ver;
		}
		
		public void setHor(int hor) {
			this.hor = hor;
		}

		
	}
	public class Procesador implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		@Override
		public void mouseReleased(MouseEvent e) {
			Botoncico eb =(Botoncico) e.getSource();
			String etiq = miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
			Container pan = eb.getParent();
			
			if (SwingUtilities.isLeftMouseButton(e)) {
				if (miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].hasMine()) {
					miTablero.mostrar();
					for (int i = 0; i < pan.getComponentCount(); i++) {
						Botoncico array_element = (Botoncico) pan.getComponents()[i];
						
						array_element.repaint();
						array_element.revalidate();
					}
				}
				/*
				if (miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].hasMine()) {
					//System.out.println("Has perdido");
					//miTablero.mostrar();
					//pan.repaint();
					//pan.revalidate();
				}
				
				
				else if (miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].isFlagged()) { 
				//eb.setBackground(new Color(255, 255, 255));
				miTablero.pisar(eb.getVer(), eb.getHor());
				eb.setEnabled(false);
				eb.setText(etiq);
				pan.repaint();
				pan.revalidate();
				}*/
				
			} else
				if (SwingUtilities.isRightMouseButton(e)) {
					//eb.setBackground(new Color(255, 255, 255));
					miTablero.flaggear(eb.getVer(), eb.getHor());
					eb.setText(etiq);
					eb.getParent().repaint();
					eb.getParent().revalidate();
				}
			
		}
		
	}
	
	public Buscaminas(Tablero.dificultad dif) {
		miTablero = new Tablero(dif);
		miTablero.ponerMinas();
		JFrame frame = new JFrame("Ejemplo5 con GridLayout");
		JPanel contentPane = (JPanel) frame.getContentPane();
		JPanel interior= new JPanel();
		Procesador procesador = new Procesador();
		interior.setLayout(new GridLayout(miTablero.getTableroInUse().length,miTablero.getTableroInUse()[1].length,1,1));    
		
		for (int i=0; i<miTablero.getTableroInUse().length; i++) {
			
			for (int j=0; j<miTablero.getTableroInUse()[i].length; j++) {
			
			Botoncico botoncico= new Botoncico(String.format("%s", miTablero.getTableroInUse()[i][j].toString()), i, j);
			botoncico.addMouseListener(procesador);
			interior.add(botoncico);
			//botoncico.setBackground(new Color(255, 255, 255));
			
			}
			
		}
		
		contentPane.add(interior);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(miTablero.getDificultadInUse()==Tablero.dificultad.EASY)
		frame.setSize(400,400);
		else if(miTablero.getDificultadInUse()==Tablero.dificultad.MEDIUM)
		frame.setSize(800,800);
		else if(miTablero.getDificultadInUse()==Tablero.dificultad.HARD)
		frame.setSize(1480,800);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}
	

	
	
	public static void main(Tablero.dificultad dif) {

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