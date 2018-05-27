package algoritmos;
/**
 * Grafica.java 
 * Version 1.0
 * Copyright (C)  2018 by Mauricio Araujo Chavez
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.ArrayList;

/**
 * @author Mauricio Araujo
 * @version 1.0 
 * @since May 17 2018
 *
 * Clase para modelar operaciones de una grafica.
 *
 */
public class Grafica {
	public ArrayList<Nodo> nodos;

	public Grafica(int numeroNodos) {
		nodos = new ArrayList<Nodo>(numeroNodos);
		for(int i = 0; i < numeroNodos; i++){
			nodos.add(new Nodo("n" + Integer.toString(i)));
		}
	}

	public agregarArista(int origen, int destino, int peso) {
		Nodo aux = nodos.get(origen);
		Arista nuevaArista = new Arista(nodos.get(destino), peso);
		aux.vecinos.add(nuevaArista);
	}

	public ArrayList<Nodo> obtenerNodos() {
		return this.nodos;
	}

	public Nodo obtenerNodo(int nodo){
		return nodos.get(nodo);
	}
}