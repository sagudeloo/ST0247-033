import java.util.ArrayList;

/**
 * This class contains algorithms for digraphs
 * Adapted from: http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
 * @author Mauricio Toro
 * @version 1
 */
public class DigraphAlgorithms
{
  private static int minVertex (double [] dist, boolean [] v) {
    double x = Integer.MAX_VALUE;
    int y = -1;   // graph not connected, or no unvisited vertices
    for (int i=0; i<dist.length; i++) {
      if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
    }
    return y;
  }
  
  
  
  static int [] dijsktra(Digraph dg, int source)
  {
    final double [] dist = new double [dg.size()];  // shortest known distance from "s"
    final int [] pred = new int [dg.size()];  // preceeding node in path
    final boolean [] visited = new boolean [dg.size()]; // all false initially
    
    for (int i=0; i<dist.length; i++) {
      dist[i] = Integer.MAX_VALUE; //Infinity
    }
    dist[source] = 0;
    
    for (int i=0; i<dist.length; i++) {
      final int next = minVertex (dist, visited);
      visited[next] = true;
      
      // The shortest path to next is dist[next] and via pred[next].
      
      final ArrayList<Integer> n = dg.getSuccessors(next);
      for ( final int v : n ) {
        final double d = dist[next] + ( double ) dg.getWeight(next, v);
        if ( dist[v] > d ) {
          dist[v] = d;
          pred[v] = next;
        }
      }
    }
    return pred;  // (ignore pred[s]==0!)
  }
  
  
  public static ArrayList getPath (int [] pred, int s, int e) {
    final java.util.ArrayList path = new java.util.ArrayList();
    int x = e;
    while (x!=s) {
      path.add (0, x);
      x = pred[x];
    }
    path.add (0, s);
    return path;
  }
  
  // Código para dibujar el grafo en GraphViz
  // Recomiendo www.webgraphviz.com/
  public static <V, C> void dibujarGrafo(Digraph<V, C> g)
  {
    System.out.println("digraph Grafo {");
    System.out.println("node [color=cyan, style=filled];");
    int nv = g.size();
    for ( V source: g.vertexes.keySet() )
    {
      ArrayList<V> lista = g.getSuccessors(source);
      for ( V destination : lista ) {
        System.out.println(source + " -> " + destination + " [ Label = \"" + g.getWeight((source), destination) + "\" ];");
      }
    }
    System.out.println("}");
  }
}