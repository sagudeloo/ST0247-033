import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class Digraph<V, C>{
	
	HashMap<V, HashMap<V, C>> arcs;
	HashMap<V, Vertex> vertexes;
	
	/**
	 * Constructor para el grafo
	 */
	public Digraph() {
		super();
		vertexes = new HashMap<>();
		arcs = new HashMap<>();
	}
	
	/**
	 * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	 * y se le asigna un peso a la longitud entre un nodo fuente y uno destino
	 * @param source desde donde se hara el arco
	 * @param destination hacia donde va el arco
	 * @param distance  el peso de la longitud entre source y destination
	 */
	public void addArc(V source, V destination, C distance){
		
		(arcs.get(source)).put(destination, distance);
	}
	
	/**
	 * Metodos para agregar nuevos vertices
	 *
	 * @param id es el ID de el vertice
	 * @param coordinateX es la primera coordenada del vertice
	 * @param coordinateY es la segunda coordenada del vertice
	 */
	public void addVertex (V id, double coordinateX, double coordinateY) {
		vertexes.put(id, (new Vertex((Long ) id, coordinateX, coordinateY)));
		arcs.put(id, new HashMap<>());
	}
	
	/**
	 * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	 * asociados al nodo pasado como argumento
	 * @param vertex nodo al cual se le busca los asociados o hijos
	 * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	 * Para más información de las clases:
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	 */
	public ArrayList<V> getSuccessors(V vertex) {
		// Una nueva lista que saque los sucesores
		ArrayList<V> successors = new ArrayList<>();
		HashMap<V, C> pairs = arcs.get(vertex);
		if ( pairs != null && pairs.size() != 0 ) {
			for ( V successor : pairs.keySet() ) {
				successors.add(successor); //segunda parte de la pareja
			}
		}
    return successors;
	}
	
	/**
	 * Metodo para obtener el peso o longitud entre dos nodos
	 *
	 * @param source desde donde inicia el arco
	 * @param destination  donde termina el arco
	 * @return un entero con dicho peso
	 */
	public C getWeight(V source, V destination) {
		HashMap<V, C> pairs = arcs.get(source);
		for ( V cDestination: pairs.keySet() ) {
			if ( cDestination == destination ) return (pairs.get(cDestination));
		}
		return null;
	}
	
	public int size(){
		return vertexes.size();
	}
}
