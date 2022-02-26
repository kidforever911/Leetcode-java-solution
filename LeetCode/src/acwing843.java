import java.io.*;
import java.util.*;

public class Main{
    private static int N = 20;
    private static boolean[] col = new boolean[N];
    private static boolean[] dig1 = new boolean[N];
    private static boolean[] dig2 = new boolean[N];
    private static char[][] board;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        board = new char[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                board[i][j] = '.';
            }
        }
        dfs(0, n);
    }
    private static void dfs(int row, int n){
        if(row == n){
            for(int i = 0; i < board.length; i ++){
                System.out.print(board[i]);
                System.out.println();
            }
            System.out.println();
        }

        for(int i = 0; i < n; i ++){
            if(!col[i] && !dig1[i + row] && !dig2[n + i - row]){
                col[i] = dig1[i + row] = dig2[n + i - row] = true;
                board[row][i] = 'Q';
                dfs(row + 1, n);
                col[i] = dig1[i + row] = dig2[n + i - row] = false;
                board[row][i] = '.';
            }
        }
        return;
    }

}

//方法2

public class Main{
    private static int N = 20;
    private static boolean[] colUsed = new boolean[N];
    private static boolean[] rowUsed = new boolean[N];
    private static boolean[] dig1 = new boolean[N];
    private static boolean[] dig2 = new boolean[N];
    private static char[][] board;
    private static int n;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        board = new char[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                board[i][j] = '.';
            }
        }
        dfs(0, 0, 0);
    }
    //count表示当前用了多少皇后
    private static void dfs(int row, int col, int count){
        if(count > n) return;
        if(col == n){
            col = 0;
            row += 1;
        }
        if(row == n){
            if(count == n){
                for(int i = 0; i < n; i ++){
                    System.out.print(board[i]);
                    System.out.println();
                }
                System.out.println();
            }
            return;

        }
        //当前这个位置不放皇后
        dfs(row, col + 1, count);

        //当前这个位置放皇后
        if(!rowUsed[row] && !colUsed[col] && !dig1[row + col] && !dig2[n + row - col]){
            rowUsed[row] = colUsed[col] = dig1[row + col] = dig2[n + row - col] = true;
            board[row][col] = 'Q';
            dfs(row, col + 1, count + 1);
            rowUsed[row] = colUsed[col] = dig1[row + col] = dig2[n + row - col] = false;
            board[row][col] = '.';
        }
        return;
    }

}