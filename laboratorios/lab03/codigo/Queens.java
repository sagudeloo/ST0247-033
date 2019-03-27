import java.util.LinkedList;
import java.util.Scanner;

public class Queens {

    private int [] board;
    private int nQueens;
    private LinkedList<Integer> possible;

    Queens(int nQueens){
        board = new int[nQueens];
        this.nQueens = nQueens;
        possible = new LinkedList<>();
        for (int i = 0, j = nQueens-1; j >= 0 && i < nQueens; i++, j--) {
            possible.add(i);
        }
    }

    void generateBoard(int k){
        if(k == nQueens){
            if (checkBoard(k-1)) {
                printBoard();
                System.exit(0);
            }
        }else {
            for (int i = 0; i < possible.size(); i++) {
                board[k] = possible.pop();
                if (checkBoard(k)) {
                    generateBoard(k + 1);
                }
                possible.add(board[k]);
            }
        }
    }

    private boolean checkBoard(int k){
        for (int i = 0; i < k; i++) {
            if (board[i] == board[k] || Math.abs(board[i]-board[k]) == Math.abs(i-k)) return false;
        }
        return true;
    }

    private void printBoard() {
        int n = board.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((board[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int nQueens = sc.nextInt();
        Queens queens = new Queens(nQueens);
        queens.generateBoard(0);
    }
}
