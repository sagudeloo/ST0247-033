import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class Map{

    HashMap<Long, HashMap<Long, Double>> roads;
    HashMap<Long, Vertex> vertexes;

    /**
     * Constructor para el grafo
     */
    public Map() {
        super();
        vertexes = new HashMap<>();
        roads = new HashMap<>();
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param distance  el peso de la longitud entre source y destination
     */
    public void addRoad(Long source, Long destination, Double distance){

        (roads.get(source)).put(destination, distance);
    }

    /**
     * Metodos para agregar nuevos vertices
     *
     * @param id es el ID de el vertice
     * @param coordinateX es la primera coordenada del vertice
     * @param coordinateY es la segunda coordenada del vertice
     */
    public void addVertex (Long id, double coordinateX, double coordinateY) {
        vertexes.put(id, (new Vertex((Long ) id, coordinateX, coordinateY)));
        roads.put(id, new HashMap<>());
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Long> getSuccessors(Long vertex) {
        // Una nueva lista que saque los sucesores
        ArrayList<Long> successors = new ArrayList<>();
        HashMap<Long, Double> pairs = roads.get(vertex);
        if ( pairs != null && pairs.size() != 0 ) {
            for ( Long successor : pairs.keySet() ) {
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
    public Double getDistance(Long source, Long destination) {
        HashMap<Long, Double> pairs = roads.get(source);
        for ( Long cDestination: pairs.keySet() ) {
            if ( cDestination == destination ) return (pairs.get(cDestination));
        }
        return null;
    }

    public Vertex getVertex(long idVertex) {
        return vertexes.get(idVertex);
    }

    public int size(){
        return vertexes.size();
    }
}