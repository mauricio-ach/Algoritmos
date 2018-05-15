package arbolgenerador;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;

public class Main {

    public static Grafica construirGrafica(File archivo){
		Grafica grafica = new Grafica();
		try{
			System.out.println("Generando grafica ...");
	    	BufferedReader br = new BufferedReader(new FileReader(archivo));
	    	boolean primeraVez = true;
	    	String linea = null;
	    	String[] aux = null;
	    	while((linea = br.readLine()) != null){
				aux = linea.split(",");
				if(primeraVez == true){
		    		for(int i = 0; i < aux.length; i++){
						grafica.agregaNodo(aux[i]);
		    		}
		    		primeraVez = false;
				} else {
				    if(aux.length != 2) throw new IllegalArgumentException();
			    grafica.conectar(aux[0], aux[1]);
				}
	    	}
	    	System.out.println("Grafica generada !");
		}catch(IllegalArgumentException e){
	    	System.out.println("No se pudo leer el archivo, por favor verificalo ... ");
		}catch(Exception e){
	    	System.out.println(e.getMessage());
		} 
		return grafica;
    }
    
    
    public static void main(String[] args){
		File archivo = new File(args[0]);
		Grafica grafica = construirGrafica(archivo);
		if(args[1].equalsIgnoreCase("DFS")){
	    	System.out.println("Generando Arbol En DFS ...");
	    	Grafica arbolDFS = grafica.generaDFS("A");
	    	System.out.println("Arbol Generado !");
	    	arbolDFS.imprimir();
		} else if(args[1].equalsIgnoreCase("BFS")){
			System.out.println("Generando Arbol en BFS ...");
			Grafica arbolBFS = grafica.generaBFS("A");
			System.out.println("Arbol Generado !");
			arbolBFS.imprimir();
		} else
	    	System.out.println("La opcion es incorrecta por favor verifica...");
    }
}
