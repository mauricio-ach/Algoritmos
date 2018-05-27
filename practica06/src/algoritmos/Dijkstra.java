package algoritmos;
/**
 * Dijkstra.java 
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

import java.util.PriorityQueue;
import java.util.LinkedList;

/**
 * @author Mauricio Araujo
 * @version 1.0 
 * @since May 17 2018
 *
 * Clase para modelar el algoritmo de Dijkstra.
 *
 */

public class Dijkstra {
	
	public void generar(Nodo inicio) {
		inicio.distanciaMinima = 0;
		PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>();
		cola.add(inicio);

		while(!inicio.isEmpty()) {
			Nodo auxNodo = cola.poll();
			for(Arista vecino: auxNodo.vecinos) {
				int nuevaDistancia = auxNodo.distanciaMinima + vecino.peso;
				if(vecino.destino,distanciaMinima > nuevaDistancia) {
					cola.remove(vecino.destino);
					vecino.origen.distanciaMinima = nuevaDistancia;
					vecino.origen.camino = new LinkedList<Nodo>(auxNodo.camino);
					vecino.origen.camino.add(auxNodo);
					cola.add(vecino.destino);
				}
			}
		}
	}
}