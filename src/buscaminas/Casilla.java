package buscaminas;

public class Casilla {

	//propiedades.
	private boolean hasMine;
	private boolean isVisible;
	private boolean isFlagged;
	private boolean isDuda;
	private int minesAround;
	
	/**
	 * Constructor vacío de un objeto "Casilla" que por defecto está amenazada y no tiene ninguna pieza.
	 */
	public Casilla() {
		setHasMine(false);
		setVisible(false);
		setFlagged(false);
		setDuda(false);
		this.minesAround=0;		
		}
	
	/**
	 * Método para comprobar si la casilla tiene o no una mina.
	 * De tenerla, devolverá true.
	 * @return Boolean.
	 */
	public boolean hasMine() {
		return hasMine;
	}
	
	/**
	 * Método "setter" para poner una mina en uan casilla.
	 * @param del método anterior, "hasMine".
	 * @void no devuelve nada.
	 */
	public void setHasMine(boolean hasMine) {
		this.hasMine = hasMine;
	}
	
	/**
	 * Método para añadir 1 a la cantidad de minas que la casilla tiene alrededor.
	 *@void no devuelve nada.
	 */
	public void sumarCuenta() {
		this.minesAround+=1;
		
	}
	
	//getters and setters
	
	/**
	 * Método "get" para obtener las minas de alrededor.
	 * @return the minesArround.
	 */
	public int getMinesArround() {
		return minesAround;
	}

	/**
	 * Método que obtiene si es visible o no la casilla.
	 * @return boolean.
	 */
	public boolean isVisible() {
		return isVisible;
	}


	/**
	 * Método que establece la visibilidad de la casilla,
	 * establece que no tenga una etiqueta (ni "?" ni "F").
	 * @param isVisible. 
	 * @void no devuelve nada.
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		this.isDuda=false;
		this.isFlagged=false;
	}
	
	/**
	 * Método que devuelve si una casilla tiene o no la "F".
	 * @return boolean.
	 */
	public boolean isFlagged() {
		return isFlagged;
	}
	
	/**
	 * Método para marcar con una "F" la casilla.
	 * @param isFlagged.
	 * @void no devuelve nada.
	 */
	public void setFlagged(boolean isFlagged) {
		this.isFlagged=isFlagged;
		this.isDuda=false;
	}
	
	/**
	 * Método que devuelve si la casilla está marcada con "?" o no.
	 * @return boolean.
	 */
	public boolean isDuda() {
		return isDuda;
	}

	/**
	 * Método que marca la casilla con "?".
	 * @param isDuda.
	 * @void no devuelve nada.
	 */
	public void setDuda(boolean isDuda) {
		this.isDuda = isDuda;
		this.isFlagged=false;
	}

	/**
	 * Método que sobreescribe el método "toString" y muestra el tablero.
	 */
	@Override
	public String toString() {
		
		String res="";
		if (isDuda()) res="?";
		else if (isFlagged()) res="F";		
		else if (isVisible() && hasMine()) res ="M";
		else if(!isVisible()) res=" ";
		else if (getMinesArround()>0 && !hasMine()) res=""+getMinesArround();
		else res="-";
		
		return res;			
	}


}
