import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Main{
  
  public static void main(String [] args){
    int nG = 0;
    int nA = 0;
    int v1 = 0;
    int v2 = 0;
    HashMap<Integer, LinkedList<Integer>> matrix = new HashMap<>();
    HashMap<Integer, Integer> colors = new HashMap<>();
    Scanner sc =  new Scanner(System.in);
    nG = 1;
    while((nG = sc.nextInt())!= 0){
      nA = sc.nextInt();
      for(int i = 0; i < nA; i++){
        v1 = sc.nextInt();
        v2 = sc.nextInt();
        if ( !matrix.containsKey(v1) ) matrix.put(v1, new LinkedList<>());
        matrix.get(v1).add(v2);
        colors.put(v1, 0);
        if ( !matrix.containsKey(v2) ) matrix.put(v2, new LinkedList<>());
        matrix.get(v2).add(v1);
        colors.put(v2, 0);
      }
      colors.put(0, 1);
      if ( colors(matrix, colors, 0) ){System.out.println("BICOLOREABLE");}
      else {System.out.println("NOT BICOLOREABLE");}
      matrix.clear();
      colors.clear();
    }
  }
  
  public static boolean colors(HashMap<Integer, LinkedList<Integer>>matrix, HashMap<Integer, Integer> colors, int index){
    if(index < colors.size()){
      boolean bicoloreable = true;
      for ( int adyasente: matrix.get(index)){
        if(colors.get(index) == 1){
          if(colors.get(adyasente) == 0){
            colors.put(adyasente, 2);
            bicoloreable = colors(matrix, colors, adyasente);
          }
          if (colors.get(adyasente) == 1 ) return false;
        }else{
          if(colors.get(adyasente) == 0){
            colors.put(adyasente, 1);
            bicoloreable =  colors(matrix, colors, adyasente);
          }
          if ( colors.get(adyasente) == 2 ) return false;
        }
      }
      return bicoloreable;
    }
    return true;
  }
}