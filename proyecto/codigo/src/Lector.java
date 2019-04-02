/**
 * Esta clase debe de contener la solucion al problema planteado en el punto 1
 * del laboratorio#1 del curso de estructura de datos y algoritmos II
 * @author Daniel Mesa, Mauricio Toro
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Lector
{
    /**
     * El metodo debe de leer el archivo y construir la estrcutura de datos con el mapa
     *
     */
    public void readFile(Map map) {
        final String fileName = "medellin_colombia-grande.txt";
        String startVertex = "Vertices.";
        String startCaminos = "Costo de Caminos Cortos.";
        String line;
        BufferedReader bufferedReader;
        Scanner sc = new Scanner(System.in);
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            sc = new Scanner(bufferedReader);
        } catch ( Exception e ) {
            System.out.println(e);
            System.exit(-1);
        }
        while (sc.hasNextLine()){
            line = sc.nextLine();
            if (line.equals(startVertex)){
                sc.nextLine();
                readCoordinates(map, sc);
            }
            if (line.equals(startCaminos)){
                sc.nextLine();
                readRoads(map, sc);
            }
        }
    }

    private void readCoordinates(Map map, Scanner sc){
        String line;
        long id;
        double coordinateX;
        double coordinateY;
        do {
            line = sc.nextLine();
            String[] str = line.split(" ");
            id = Long.parseLong(str[0]);
            coordinateX = Double.parseDouble(str[1]);
            coordinateY = Double.parseDouble(str[2]);
            map.addVertex(id, coordinateX, coordinateY);
        }while( line.length() > 0 );
    }

    private void readRoads(Map map, Scanner sc){
        String line;
        long id1;
        long id2;
        double cost;
        do {
            line = sc.nextLine();
            String[] str = line.split(" ");
            id1 = Long.parseLong(str[0]);
            id2 = Long.parseLong(str[1]);
            cost = Double.parseDouble(str[2]);
            map.addRoad(id1, id2, cost);
        }while( line.length() > 0 );
    }

    /**
     * Metodo principal del programa
     * @param args un array de argumentos
     */
    public static void main(String[] args)
    {
        Lector sp = new Lector();
        Map gragh = new Map();
        sp.readFile(gragh);
        LinkedList<PairStar> path = MapAlgorithms.aStar(gragh, 4, 1);
        for (PairStar pair: path) {
            System.out.print(pair.id + " ");
        }
    }
}
