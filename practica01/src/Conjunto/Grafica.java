package Conjunto;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Grafica {
	LinkedList<Nodo> nodos;
	int numAristas;

	public Grafica() {
		this.nodos = new LinkedList<>();
		this.numAristas = 0;
	}

	public Nodo obtenerNodo(String elemento) {
		for(Nodo aux : nodos) {
			if(elemento.compareTo(aux.elemento) == 0)
				return aux;
		}
		throw new NoSuchElementException();
	}

	public boolean encuentraNodo(String elemento){ 
		for(Nodo aux : nodos) {
			if(elemento.compareTo(aux.elemento) == 0)
				return true;
		}
		return false;
	}

	public void agregaNodo(String elemento) {
		if(!this.encuentraNodo(elemento)) {
			Nodo nuevo = new Nodo(elemento);
			nodos.add(nuevo);
		}
	}

	public void conectar(String elemento1, String elemento2) {
		if(!encuentraNodo(elemento1))
			System.out.println("Elemento " + elemento1 + "no encontrado.");
		else if(!encuentraNodo(elemento2))
			System.out.println("Elemento " + elemento2 + "no encontrado.");
		else {
			Nodo aux1 = this.obtenerNodo(elemento1);
			Nodo aux2 = this.obtenerNodo(elemento2);
			aux1.agregarVecino(aux2);
			aux2.agregarVecino(aux1);
			numAristas += 1;
		}
	}

	public boolean verificaVecinos(String elemento1, String elemento2) {
		if(!encuentraNodo(elemento1) || !encuentraNodo(elemento2))
			throw new NoSuchElementException();
		Nodo aux1 = obtenerNodo(elemento1);
		Nodo aux2 = obtenerNodo(elemento2);
		return aux1.vecinos.contains(aux2);
	}

	public LinkedList<Nodo> obtenerConjuntoIndp() {
		LinkedList<Nodo> cola = new LinkedList<>();
		LinkedList<Nodo> conjuntoFinal = new LinkedList<>();
		Nodo aux = null;
		boolean pertenece = true;

		for(Nodo nodo : nodos) {
			if(!nodo.visitado){
				cola.addLast(nodo);
				nodo.visitado = true;
			}
			while(!cola.isEmpty()) {
				aux = cola.remove();
				for(Nodo nodo2 : aux.vecinos) {
					if(!nodo2.visitado) {
						cola.addLast(nodo2);
						nodo2.visitado = true;
					}
					if(conjuntoFinal.contains(nodo2))
						pertenece = false;
				}
				if(pertenece)
					conjuntoFinal.add(aux);
				pertenece = true;
			}
		}
		return conjuntoFinal;
	}

	public static Grafica obtenerGrafica(File archivo) {
		Grafica grafica = new Grafica();
		try{
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			boolean primera = true;
			String linea = "";
			String[] arreglo = null;
			while((linea = bf.readLine()) != null) {
				arreglo = linea.split(",");
				if(primera) {
					for(int i = 0; i < arreglo.length; i++) {
						grafica.agregaNodo(arreglo[i]);
					}
					primera = false;
				} else {
					if(arreglo.length != 2)
						throw new IllegalArgumentException();
					grafica.conectar(arreglo[0], arreglo[1]);
				}
			}
		} catch(IllegalArgumentException e) {
			System.out.println("El formato del archivo es érroneo por favor verifica las instrucciones ....");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Gráfica generada !");
		return grafica;
	}
}

