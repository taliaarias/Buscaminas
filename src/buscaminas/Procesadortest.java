package buscaminas;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class Procesadortest implements MouseListener {

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
			if (miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].hasMine() && 
					!miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].isFlagged()) {
				miTablero.mostrar();
				pan.removeAll();
				pintaBotones();
				pan.repaint();
				pan.revalidate();

			}
			
			else {
				miTablero.pisar(eb.getVer(), eb.getHor());
				String etiq = miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
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
				miTablero.flaggear(eb.getVer(), eb.getHor());
				String etiq = miTablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
				eb.setText(etiq);
				eb.getParent().repaint();
				eb.getParent().revalidate();
			}
		
	}
	
}