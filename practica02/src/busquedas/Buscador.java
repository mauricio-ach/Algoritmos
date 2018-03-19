package busquedas;

/**
 * Buscador.java 
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

/**
 * @author Mauricio Araujo
 * @version 1.0 
 * @since Mar 16 2018
 *
 * Clase para modelar un buscador que implementa las busquedas 
 * Secuencial, Binaria, Exponencial y por Interpolación.
 *
 */
public class Buscador{

	/**
	* Método para implementar busqueda secuencial.
	* @pre El arreglo de la clase debe estar ordenado.
	* @param int elemento, el elemento a ser buscado dentro del arreglo.
	* @param int[] numeros, el arreglo donde se va a buscar el elemento.
	* @return True si el elemento a buscar esta dentro de la lista, False en otro caso.
	*/
	public boolean busquedaSecuencial(int elemento, int[] numeros){

		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] == elemento){
				return true;
			}
		}

		return false;
	}

	/**
	* Método para implementar busqueda binaria.
	* @pre El arreglo de la clase debe estar ordenado.
	* @param int elemento, el elemento a ser buscado dentro del arreglo.
	* @param int[] numeros, el arreglo donde se va a buscar el elemento.
	* @param int izquierdo, el indice izquierdo.
	* @param int derecho, el indice derecho.
	* @return True si el elemento a buscar esta dentro de la lista, False en otro caso.
	*/
	public boolean busquedaBinaria(int elemento, int[] numeros, int izquierdo, int derecho){

		if(derecho >= izquierdo){
			int mitad = izquierdo + (derecho - izquierdo) / 2;
			if(numeros[mitad] == elemento){
				return true;
			} else if(numeros[mitad] > elemento){
				return busquedaBinaria(elemento, numeros, izquierdo, mitad - 1);
			} else {
				return busquedaBinaria(elemento, numeros, mitad + 1, derecho);
			}
		}

		return false;
	}

	/**
	* Método para implementar busqueda exponencial.
	* @pre El arreglo de la clase debe estar ordenado.
	* @param int elemento, el elemento a ser buscado dentro del arreglo.
	* @param int[] numeros, el arreglo donde se va a buscar el elemento.
	* @return True si el elemento a buscar esta dentro de la lista, False en otro caso.
	*/
	public boolean busquedaExponencial(int elemento, int[] numeros){

		if(numeros[0] == elemento)
			return true;

		int limite = 1;
		while(limite < numeros.length && numeros[limite] <= elemento)
			limite = limite * 2;

		return busquedaBinaria(elemento, numeros, limite / 2, Math.min(limite, numeros.length));
	}

	/**
	* Método para implementar busqueda por interpolacion.
	* @pre El arreglo de la clase debe estar ordenado.
	* @param int elemento, el elemento a ser buscado dentro del arreglo.
	* @param int[] numeros, el arreglo donde se va a buscar el elemento.
	* @return True si el elemento a buscar esta dentro de la lista, False en otro caso.
	*/
	public boolean busquedaInterpolacion(int elemento, int[] numeros){
		
		int inferior = 0;
		int superior = numeros.length - 1;

		while(inferior <= superior && elemento >= numeros[inferior] && elemento <= numeros[superior]){
			int posicion = inferior + (((superior - inferior) / (numeros[superior] - numeros[inferior])) * (elemento - numeros[inferior]));
			if(numeros[posicion] == elemento){
				return true;
			} else if(numeros[posicion] < elemento){
				inferior = posicion + 1;
			} else {
				superior = posicion + 1;
			}
		}

		return false;
	}
}
