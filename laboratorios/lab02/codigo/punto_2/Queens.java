import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Scanner;

public class Queens {

    int [] board;
    int nQueens;
    int [] deadPoint;
    LinkedList<Integer> possible;

    public Queens(int nQueens){
        board = new int[nQueens];
        this.nQueens = nQueens;
        possible = new LinkedList<>();
        for (int i = 0; i < nQueens; i++) {
            possible.add(i);
            deadPoint[i] = -1;
        }
    }

    public void generateBoard(int k){
        if(k == nQueens){

        }
        for (int i = 0; i < nQueens; i++){
            board[k] = possible.pop();
            if(checkBoard(k)) generateBoard(k+1);
            possible.add(board[k]);
            board[k] = possible.removeFirst();
        }

    }

    public boolean checkBoard(int k){
        if ((board[k] == deadPoint[k]) || (deadPoint[k] == -1))
        for (int i = 0; i < k; i++) {
            if (Math.abs(board[i]-board[k]) == Math.abs(i-k)) return false;
        }
        return true;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int nQueens = sc.nextInt();
        String row = sc.nextLine();
        String [] column = row.split(".");
//        for (int i = 0; i < nQueens; i++) {
//            row = sc.nextLine();
//            column = row.split(".");
//        }
        for (String s: column) {
            System.out.println(s);
        }

    }
}

