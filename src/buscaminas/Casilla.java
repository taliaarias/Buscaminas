package buscaminas;

public class Casilla {

	private boolean hasMine;
	private boolean isVisible;
	private boolean isFlagged;
	private boolean isDuda;
	private int minesAround;
	
	/**
	 * Constructor vacío de un objeto "Casilla" que por defecto está amenazada y no tiene ninguna pieza.
	 * 
	 */
	public Casilla() {
		setHasMine(false);
		setVisible(false);
		setFlagged(false);
		setDuda(false);
		this.minesAround=0;		
		}
	

	/**
	 * @return si la casilla tiene mina "true" si no, false.
	 */
	public boolean hasMine() {
		return hasMine;
	}
	/**
	 * @param hasMina "setter" para poner minas en una casilla.
	 */
	public void setHasMine(boolean hasMine) {
		this.hasMine = hasMine;
	}
	
	/**
	 *  Void para añadir 1 a la cantidad de minas que la casilla tiene alrededor.
	 */
	public void sumarCuenta() {
		
		this.minesAround+=1;
		
	}
	/**
	 * @return the minesArround
	 */
	public int getMinesArround() {
		return minesAround;
	}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}


	/**
	 * @param isVisible the isVisible to set
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		this.isDuda=false;
		this.isFlagged=false;
	}
	
	/**
	 * 
	 * @return the isFlagged;
	 */
	public boolean isFlagged() {
		return isFlagged;
	}
	/**
	 * @param isFlagged the isFlagged to set
	 */
	public void setFlagged(boolean isFlagged) {
		this.isFlagged=isFlagged;
		this.isDuda=false;
	}
	
	
	public boolean isDuda() {
		return isDuda;
	}


	public void setDuda(boolean isDuda) {
		this.isDuda = isDuda;
		this.isFlagged=false;
	}


	@Override
	public String toString() {
		
		String res="";
		if (isDuda()) res="?";
		else if (isFlagged()) res="F";
		
		else if(isVisible()) res=" ";
		else if (isVisible() && hasMine()) res ="M";
		else if (getMinesArround()>0) res=""+getMinesArround();
		else res="-";
		
		return res;		
		
	}


}
