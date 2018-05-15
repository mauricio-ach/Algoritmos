package arbolgenerador;

import java.util.LinkedList;

public class Nodo{
    public LinkedList<Nodo> vecinos;
	public String elemento;
	public boolean visitado;
	
	public Nodo(String elemento){
	    this.vecinos = new LinkedList<>();
	    this.elemento = elemento;
	    this.visitado = false;
	}

	public String obtenerElemento() {
		return this.elemento;
	}

	public void agregarVecino(Nodo nodoVecino){
	    vecinos.addLast(nodoVecino);
	}

	public void desmarcar(){
	    this.visitado = false;
	}

}