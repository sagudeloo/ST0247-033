import java.util.LinkedList;

/**
 * Clase en la cual se implementan los metodos del Taller 2
 * 
 * @author Mauricio Toro, Camilo Paez
 */
public class Taller2 {
	
	/**
	* Metodo público que llama al metodo combinations posteriormente
	* 
	* @param str cadena sobre el cual se haran las combinaciones (o subconjuntos)
	
	*/	
	public static void combinations(String str) {
    combinations("", str);
	}

	/**
	* Metodo para obtener las posibles combinaciones (o subconjuntos) que se pueden hacer
	* con los elementos dados
	* 
	* @param  loQueLlevo cadena de caracteres con lo que ya se tiene del subconjunto
	* @param loQueMeFalta cadena de caracteres con lo que me falta por calcular del subconjunto
	* @param list lista de cadenas para almacenar las combinaciones (o subconjuntos)
	* 
	*/	
	private static void combinations(String respuesta, String pregunta, LinkedList<String>) {
		if (pregunta.length() == 0)
      System.out.println(respuesta);
    else {
      combinations(respuesta, pregunta.substring(1));
      combinations(respuesta+pregunta.substring(0,1), pregunta.substring(1));
    }
	}

	/**
	* Metodo auxiliar que llama al metodo permutations posterios
	* 
	* @param  s la cadena a la cual se le haran las permutaciones
	* @return un ArrayList que contiene las permutaciones
	*/	
	public static void permutations(String s) {
		permutations("",s)
	}

	/**
	* Metodo para obtener las posibles permutaciones que se pueden hacer
	* con los caracteres de una cadena dada, recuerde que las letras no se 
	* repiten en este ejercicio
	* 
	* @param  loQueLlevo parte de la cadena que hace parte de la permutacion
	* @param loQueMeFalta parte de cadena que falta por calcular en una permutacion
	* @param list el conjunto que tiene todas las permutaciones
	* 
	*/	
	private static void permutations(String respuesta, String pregunta) {
    if (pregunta.length() == 0) 
            System.out.println(respuesta);
    else {
        for (int i = 0; i < pregunta.length(); i++)
          permutations(respuesta+pregunta.charAt(i), pregunta.substring(0,i)+pregunta.substring(i+1));
    }
	}

	/**
	* Metodo que imprime en pantalla como esta el tablero dado
	* 
	* @param  tablero es un arreglo con las posiciones de un tablero
	* de ajedrez
	* no se modifica.
	*/	
	public static void imprimirTablero(int[] tablero) {
		int n = tablero.length;
		System.out.print("    ");
		for (int i = 0; i < n; ++i)
			System.out.print(i + " ");
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(i + "   ");
			for (int j = 0; j < n; ++j)
				System.out.print((tablero[i] == j ? "Q" : "#") + " ");
			System.out.println();
		}
		System.out.println();
	}

	/**
	* Metodo auxiliar verifica si el tablero implementado es correcto
	* es decir rodas las reinas se posicionan de foma correcta
	* 
	* @param  tablero un arreglo con las posiciones de un tablero de ajedrez
	* @return true si es verdaderos, false de lo contrario
	*/	
	public static boolean esValido(int[] tablero) {
		for (int i = 0; i < tablero.length; i++)
      for (int j = i+1; j < tablero.length - 1; j++)
        if ( Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j ))                 
          return false;
    return true;
	}

	/**
	* Metodo que muestra el numero de posibles soluciones al problema
	* 
	* 
	* @param  n numero de reinas
	* @return numero de soluciones
	*/	
	public static int queens(int n) {
	    return queens(n, 0, new int[n]);
	}

	/**
	* Metodo que muestra el numero de posibles soluciones al problema
	* 
	* 
	* @param  n numero de reinas
	* @param  columna indice de la columna que sera revisada
	* @param  tablero aqui se almacena una solucion de las n reinas
	* @return numero de soluciones
	*/
	private static int queens(int n, int columna, int[] tablero) {
		if (algo) 
      pare;
    else
      queens();
	}

}
