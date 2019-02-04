/**
 * Esta clase debe de contener la solucion al problema planteado en el punto 1
 * del laboratorio#1 del curso de estructura de datos y algoritmos II
 * @author Daniel Mesa, Mauricio Toro
 * @version 1.0
 */
import java.io.*;
import java.util.Scanner;

public class Splantilla
{
  /**
   * El metodo debe de leer el archivo y construir la estrcutura de datos con el mapa
   *
   */
  public static void makeMap()
  {
  }
  public void readFile(Digraph graph) {
    final String fileName = "C:\\Users\\saocr\\IdeaProjects\\Laboratorios\\Laboratorio01\\src\\medellin_colombia-grande.txt";
    String findLocation = "Arcos.";
    BufferedReader bufferedReader;
    Scanner sc = new Scanner(System.in);
    try {
      bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
      sc = new Scanner(bufferedReader);
    } catch ( Exception e ) {
      System.out.println(e);
      System.exit(-1);
    }
    sc.nextLine();
    String line;
    while (sc.hasNextLine()){
      line =  sc.nextLine();
      if(line.contains(findLocation)){
        while ( sc.hasNextLong() ) {
          line = sc.nextLine();
          readArcs(graph, line);
        }
        continue;
      }
      readCoordinates(graph, line);
    }
  }
  
  private void readCoordinates(Digraph graph, String line){
    if ( line.length() > 0 ) {
      long id;
      double coordinateX;
      double coordinateY;
      String[] str = line.split(" ");
      id = Long.parseLong(str[0]);
      coordinateX = Double.parseDouble(str[1]);
      coordinateY = Double.parseDouble(str[2]);
      graph.addVertex(id, coordinateX, coordinateY);
    }
  }
  
  private void readArcs(Digraph graph, String line){
    if ( line.length() > 0 ) {
      long id1;
      long id2;
      double distance;
      String[] str = line.split(" ");
      id1 = Long.parseLong(str[0]);
      id2 = Long.parseLong(str[1]);
      distance = Double.parseDouble(str[2]);
      graph.addArc(id1, id2, distance);
    }
  }
  /**
   * Metodo principal del programa
   * @param args un array de argumentos
   */
  public static void main(String[] args)
  {
    Splantilla sp = new Splantilla();
    Digraph<Long, Double> gragh = new Digraph<>();
    sp.readFile(gragh);
    DigraphAlgorithms.dibujarGrafo(gragh);
  }
}
