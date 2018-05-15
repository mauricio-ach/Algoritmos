package arbolgenerador;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Grafica{    

    private LinkedList<Nodo> Nodos;
    private int aristas;

    public Grafica(){
		this.Nodos = new LinkedList<>();
		this.aristas = 0;
    }
    
    public void agregaNodo(String elemento){
		if(!this.comparaElemento(elemento)){
	    	Nodo nuevo = new Nodo(elemento);
	    	Nodos.add(nuevo);
		}
    }

    public boolean comparaElemento(String elemento){
		for(Nodo e: Nodos){
	    	if(elemento.compareTo(e.elemento) == 0)
			return true;
		}
		return false;
    }

    public Nodo obtenerNodo(String elemento){
		for(Nodo e: Nodos){
	    	if(elemento.compareTo(e.elemento) == 0)
			return e;
		}
		throw new NoSuchElementException();
    }

    public void conectar(String elemento1, String elemento2){
		if(!comparaElemento(elemento1))
	    	System.out.println("Elemento " + elemento1 + " no encontrado");
		else if(!comparaElemento(elemento2))
	    	System.out.println("Elemento" + elemento2 + " no encontrado");
		else{
	    	Nodo nodo1 = this.obtenerNodo(elemento1);
	    	Nodo nodo2 = this.obtenerNodo(elemento2);
	    	nodo1.agregarVecino(nodo2);
	    	nodo2.agregarVecino(nodo1);
	    	aristas+=1;
		}	    
    }

    public boolean sonVecinos(String elemento1, String elemento2){
		if(!comparaElemento(elemento1) || !comparaElemento(elemento2))
	    	throw new NoSuchElementException();
		return obtenerNodo(elemento1).vecinos.contains(obtenerNodo(elemento2));
    }

    public Grafica generaDFS(String elementoRaiz){
    	LinkedList<Nodo> pila = new LinkedList<>();
    	Grafica arbolGenerador = new Grafica();
    	Nodo aux = obtenerNodo(elementoRaiz);
    	pila.addFirst(aux);
    	aux.visitado = true;
    	arbolGenerador.agregaNodo(aux.obtenerElemento());
    	while(!pila.isEmpty()){
        	aux = pila.remove();
        	for(Nodo v: aux.vecinos){
    			if(v.visitado == false){
    	    		pila.addFirst(v);
    	    		v.visitado = true;
    	    		arbolGenerador.agregaNodo(v.obtenerElemento());
    	    		arbolGenerador.conectar(aux.obtenerElemento(), v.obtenerElemento());
    			}
        	}
    	}
    	reiniciar();
    	return arbolGenerador;
    }
        
    public Grafica generaBFS(String elementoRaiz){
    	LinkedList<Nodo> cola = new LinkedList<>();
    	Grafica arbolGenerador = new Grafica();
    	Nodo aux = obtenerNodo(elementoRaiz);
    	cola.addLast(aux);
    	aux.visitado = true;
    	arbolGenerador.agregaNodo(aux.obtenerElemento());
    	while(!cola.isEmpty()){
        	aux = cola.remove();
        	for(Nodo v: aux.vecinos){
    			if(v.visitado = false){
    	    		cola.addLast(v);
    	    		v.visitado = true;
    	    		arbolGenerador.agregaNodo(v.obtenerElemento());
    	    		arbolGenerador.conectar(aux.obtenerElemento(), v.obtenerElemento());
    			}
        	}
    	}
    	reiniciar();
    	return arbolGenerador;
    }

    public void imprimir(){	
    	System.out.println("Nodos: ");
    	String nodosFinal = "";
    	for(Nodo aux: Nodos){
        	nodosFinal = nodosFinal + aux.obtenerElemento() + ", ";
    	}
    	nodosFinal = nodosFinal.substring(0, nodosFinal.length() - 2);
    	System.out.println(nodosFinal + "\n");
    	System.out.println("Aristas: ");
    	for(Nodo aux: Nodos){
        	for(Nodo aux2: aux.vecinos){
    			if(aux2.visitado = false){
    	    		System.out.println("("+ aux.obtenerElemento() + ", " + aux2.obtenerElemento() +")");
    	 	 	}
        	}
        	aux.visitado = true;
    	}
    	reiniciar();
    }

    private void reiniciar(){
    	for(Nodo v: Nodos){
        	v.desmarcar();
    	}
    }
}
