import java.util.LinkedList;
import java.util.Scanner;

public class Queens {

    private int [] board;
    private int nQueens;
    private int [][] deadPoint;
    private int nSolutions = 0;
    private LinkedList<Integer> possible;

    private Queens(int nQueens, int [][] deadPoint){
        board = new int[nQueens];
        this.deadPoint = deadPoint;
        this.nQueens = nQueens;
        possible = new LinkedList<>();
        for (int i = 0, j = nQueens-1; j >= 0 && i < nQueens; i++, j--) {
            possible.add(i);
        }
    }

    private void generateBoard(int k){
        if(k == nQueens){
            if (checkBoard(k-1)) {
                nSolutions++;
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
        if (deadPoint[k][board[k]] == 1) return false;
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
        sc.nextLine();
        String row;
        int [][] deadPoint = new int[nQueens][nQueens];
        for (int i = 0; i < nQueens; i++) {
            row = sc.nextLine();
            for (int j = 0; j < nQueens; j++) {
                if (row.charAt(j) == '*')deadPoint[i][j] = 1;
            }
        }
        Queens queens = new Queens(nQueens, deadPoint);
        queens.generateBoard(0);
        System.out.println(queens.nSolutions);

    }
}

