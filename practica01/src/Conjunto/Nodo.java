package Conjunto;

import java.util.LinkedList;

public class Nodo {
	public LinkedList<Nodo> vecinos;
	public String elemento;
	public int numVecinos;
	public boolean visitado;

	public Nodo(String elemento) {
		this.vecinos = new LinkedList<>();
		this.elemento = elemento;
		this.numVecinos = 0;
		this.visitado = false;
	}

	public void agregarVecino(Nodo vecino) {
		vecinos.addLast(vecino);
		numVecinos += 1;
	}

}