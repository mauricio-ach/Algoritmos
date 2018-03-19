package busquedas;

/**
 * Interfaz.java 
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

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Mauricio Araujo
 * @version 1.0 
 * @since Mar 16 2018
 *
 * Clase para modelar una interfaz donde se ocupen las busquedas
 * secuencial, binaria, exponencial y por interpolacion.
 */
public class Interfaz{

	public static void main(String[] args) {
		
		//Obtenemos datos necesarios
		String archivo = args[0];
		int elemento = Integer.parseInt(args[1]);
		String opcion = args[2];
		Buscador buscador = new Buscador();
		boolean encontrado = false;

		//Para leer
		FileReader fr = null;
		BufferedReader br = null;

		try {

			//Tratamos de leer archivo
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			//imprimimos arreglo
			System.out.println("Arreglo donde se buscará el elemento {" + elemento + "} :");
			String tmp, aux = "";
			
			while((tmp = br.readLine()) != null){
				System.out.println(tmp);
				aux = aux + tmp; 
			}
			String[] datosString = aux.split(" ");

			//Convertimos string a int
			int[] datos = new int[datosString.length];
			for(int i = 0; i < datosString.length; i++)
				datos[i] = Integer.parseInt(datosString[i]);

			//Manejamos la opcion elegida
			//Busqueda Secuencial
			if(opcion.compareTo("S") == 0){
				System.out.println("Ejecutando Busqueda Secuencial....");
				encontrado = buscador.busquedaSecuencial(elemento, datos);
				if(encontrado == true){
					System.out.println("Elemento encontrado!");
				} else {
					System.out.println("Elemento no encontrado!");
				}
			} else if(opcion.compareTo("B") == 0){
				System.out.println("Ejecutando Busqueda Binaria....");
				encontrado = buscador.busquedaBinaria(elemento, datos, 0, datos.length);
				if(encontrado == true){
					System.out.println("Elemento encontrado!");
				} else {
					System.out.println("Elemento no encontrado!");
				}
			} else if(opcion.compareTo("E") == 0){
				System.out.println("Ejecutando Busqueda Exponencial....");
				encontrado = buscador.busquedaExponencial(elemento, datos);
				if(encontrado == true){
					System.out.println("Elemento encontrado!");
				} else {
					System.out.println("Elemento no encontrado!");
				}
			} else if(opcion.compareTo("I") == 0){
				System.out.println("Ejecutando Busqueda por Interpolacion....");
				encontrado = buscador.busquedaInterpolacion(elemento, datos);
				if(encontrado == true){
					System.out.println("Elemento encontrado!");
				} else {
					System.out.println("Elemento no encontrado!");
				}
			} else {
				System.out.println("Opción incorrecta, por favor ingresa una opción correcta!");
			}

		} catch(IOException e) {

			System.out.println("El archivo no existe por favor verifica que el archivo exista y se encuentre en el mismo directorio de trabajo...");

		} finally {
			try{
				
				if(fr != null)
					fr.close();
				if(br != null)
					br.close();

			} catch(IOException e){

				e.printStackTrace();

			}
		}
	}
}