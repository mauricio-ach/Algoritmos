import java.util.LinkedList;
import java.util.NoSuchElementException;
public class Grafica{

    protected class Nodo{
        public LinkedList<Nodo> vecinos;
	public String id;
	public int vecs;
	public boolean visitado;
	
	public Nodo(String name){
	    this.vecinos = new LinkedList<>();
	    this.id = name;
	    this.vecs = 0;
	    this.visitado = false;
	}

	public void agregaVecino(Nodo neighbour){
	    vecinos.addLast(neighbour);
	    vecs++;
	}
    }

    LinkedList<Nodo> nodos;
    int aristas;
    
    public Grafica(){
	this.nodos = new LinkedList<>();
	this.aristas = 0;
    }
    
    public void agregaNodo(String id){
	if(!this.contiene(id)){
	    Nodo nuevo = new Nodo(id);
	    nodos.add(nuevo);
	}
    }

    public boolean contiene(String ident){
	for(Nodo e: nodos){
	    if(ident.compareTo(e.id) == 0)
		return true;
	}
	return false;
    }

    public Nodo getNodo(String ident){
	for(Nodo e: nodos){
	    if(ident.compareTo(e.id) == 0)
		return e;
	}
	throw new NoSuchElementException();
    }

    public void conecta(String idA, String idB){
	if(!contiene(idA))
	    System.out.println("Error: La gráfica no contiene" + idA);
	else if(!contiene(idB))
	    System.out.println("Error: La gráfica no contiene" + idB);
	else{
	    Nodo A = this.getNodo(idA);
	    Nodo B = this.getNodo(idB);
	    A.agregaVecino(B);
	    B.agregaVecino(A);
	    aristas++;
	}	    
    }

    public boolean sonVecinos(String idA, String idB){
	if(!contiene(idA) || !contiene(idB))
	    throw new NoSuchElementException();
	return getNodo(idA).vecinos.contains(getNodo(idB));
    }

    public LinkedList<Nodo> getConjIndependiente(){
	LinkedList<Nodo> cola = new LinkedList<>();
	LinkedList<Nodo> conjInd = new LinkedList<>();
	Nodo aux = null;
	boolean vaEnIndep = true;
	for(Nodo e: nodos){
	    if(!e.visitado){
		cola.addLast(e);
		e.visitado = true;	    	    
		while(!cola.isEmpty()){
		    aux = cola.remove();
		    for(Nodo f: aux.vecinos){
			if(!f.visitado){
			    cola.addLast(f);
			    f.visitado = true;	    	    
			}
			if(conjInd.contains(f))
			    vaEnIndep = false;
		    }
		    if(vaEnIndep){
			conjInd.add(aux);
		    }
		    vaEnIndep = true;
		}
	    }
	}
	return conjInd;
    }
}
