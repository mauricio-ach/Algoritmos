package Conjunto;

import java.io.File;
import java.util.LinkedList;

public class Interfaz {
	public static void main(String[] args) {
		File archivo = new File(args[0]);
		Grafica grafica = Grafica.obtenerGrafica(archivo);
		LinkedList<Nodo> conjuntoIndependiente = grafica.obtenerConjuntoIndp();
		String conjuntoFinal = "";
		for(Nodo nodo : conjuntoIndependiente) {
			conjuntoFinal = conjuntoFinal + nodo.elemento + ", ";
		}
		System.out.println("Conjunto independiente generado: ");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println();
		System.out.println(conjuntoFinal.substring(0, conjuntoFinal.length() - 2));
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*********************************");
	}
}