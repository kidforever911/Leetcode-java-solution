import java.io.*;
import java.util.*;

//数组模拟queue的写法
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

//调用queue的写法
public class Main{
    private static int n;
    private static int m;
    private static int N = 110;
    private static int[][] d = new int[N][N];
    private static int[][] board;
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
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
        for(int i = 0; i < d.length; i ++){
            for(int j = 0; j < d[0].length; j ++){
                d[i][j] = -1;
            }
        }
        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        d[0][0] = 0;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] head = q.poll();
            for(int i = 0; i < 4; i ++){
                int x = head[0] + direction[i][0];
                int y = head[1] + direction[i][1];
                if(x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 0 && d[x][y] == -1){
                    d[x][y] = d[head[0]][head[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        return d[n - 1][m - 1];
    }
}

//dfs做法，会超时
public class Main{
    private static int n;
    private static int m;
    private static int[][] board;
    private static int result;
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int N = 110;
    private static boolean[][] visited = new boolean[N][N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                board[i][j] = in.nextInt();
            }
        }
        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int startx, int starty, int d){
        if(startx == n - 1 && starty == m - 1){
            if(result > d){
                result = d;
            }else{
                return;
            }
        }
        if(d > result) return;
        visited[startx][starty] = true;
        for(int i = 0; i < 4; i ++){
            int newx = startx + direction[i][0];
            int newy = starty + direction[i][1];
            if(newx >= 0 && newx < n && newy >= 0 && newy < m && board[newx][newy] == 0 && !visited[newx][newy]){
                visited[newx][newy] = true;
                dfs(newx, newy, d + 1);
                visited[newx][newy] = false;
            }
        }
        return;
    }
}