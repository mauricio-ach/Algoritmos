package algoritmos;

/**
 * Nodo.java 
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
import java.util.LinkedList;

/**
 * @author Mauricio Araujo
 * @version 1.0 
 * @since May 17 2018
 *
 * Clase para modelar el nodo de una grafica.
 *
 */

public class Nodo {
	public String elemento;
	public ArrayList<Arista> vecinos = new ArrayList<Arista>();
	public LinkedList<Nodo> camino = new LinkedList<Nodo>();
	public double distanciaMinima = Double.POSITIVE_INFINITY;
	public Nodo anterior;

	public int compareTo(Nodo nodo) {
		return Double.compare(distanciaMinima, nodo.distanciaMinima);
	}

	public Nodo(String elemento) {
		this.elemento = elemento;
	}
}