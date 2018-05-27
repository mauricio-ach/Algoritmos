package algoritmos;

/**
 * Conjunto.java 
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
 * @since May 17 2018
 *
 * Clase para modelar las operaciones de un conjunto ajeno.
 *
 */

public class Conjunto {
	public int[] conjunto;

	public Conjunto(int elementos) {
		this.conjunto =  new int[elementos];
		for(int i = 0; i < this.conjunto.length; i++) {
			this.conjunto[i] = -1;
		}
	}

	public void unir(int raiz1, int raiz2) {
		if(this.conjunto[raiz2] < this.conjunto[raiz1]){
			this.conjunto[raiz1] = raiz2;
		}else {
			if(this.conjunto[raiz1] == this.conjunto[raiz2]){
				this.conjunto[raiz1]--;
			}
			this.conjunto[raiz2] = raiz1; 
		}
	}

	public int buscar(int buscado) {
		if(this.conjunto[buscado] < 0){
			return buscado;
		}
		int siguiente = buscado;
		while(this.conjunto[siguiente] > 0){
			siguiente = this.conjunto[siguiente];
		}
		return siguiente;
	}
}