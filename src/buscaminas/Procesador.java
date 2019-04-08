package buscaminas;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

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
		Container pan = eb.getParent();
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].hasMine() && 
					!Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].isFlagged()) {
				Tablero.mostrar();
				pan.removeAll();
				Buscaminas.pintaBotones();
				pan.repaint();
				pan.revalidate();

			}
			
			else {
				Tablero.pisar(eb.getVer(), eb.getHor());
				String etiq = Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
				eb.setEnabled(false);
				eb.setText(etiq);
				//
				//pan.repaint();
				//pan.revalidate();
			}
			
			
			/*else if (miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].isFlagged()) { 
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
				Tablero.flaggear(eb.getVer(), eb.getHor());
				String etiq = Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
				eb.setText(etiq);
				eb.getParent().repaint();
				eb.getParent().revalidate();
			}
		
	}
	
}