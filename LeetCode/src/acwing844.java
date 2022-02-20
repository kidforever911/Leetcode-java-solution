import java.io.*;
import java.util.*;

public class Main{
    private static int N = 110;
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static Pair[] q = new Pair[N * N];
    private static int[][]d = new int[N][N];
    private static int[][] board;
    private static int n;
    private static int m;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(bfs());
    }

    private static int bfs(){
        int hh = 0;
        int tt = 0;
        q[0] = new Pair(0, 0);
        for(int i = 0; i < d.length; i ++){
            for(int j = 0; j < d[0].length; j ++){
                d[i][j] = -1;
            }
        }
        d[0][0] = 0;
        while(hh <= tt){
            Pair head = q[hh ++];
            for(int i = 0; i < 4; i ++){
                int x = head.getFirst() + direction[i][0];
                int y = head.getSecond() + direction[i][1];
                if(x >= 0 && x < board.length && y >= 0 & y < board[0].length && d[x][y] == -1 && board[x][y] == 0){
                    q[++tt] = new Pair(x, y);
                    d[x][y] = d[head.getFirst()][head.getSecond()] + 1;
                }
            }
        }
        return d[n - 1][m - 1];
    }

}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    public Pair(){

    }

    public int getFirst(){
        return first;
    }
    public int getSecond(){
        return second;
    }
}