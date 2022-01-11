import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    private static int N = 1010;
    private static int[][] arr, S;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int row = in.nextInt();
        int col = in.nextInt();
        int m = in.nextInt();
        arr = new int[N][N];
        S = new int[N][N];
        for(int i = 1; i <= row; i ++){
            for(int j = 1; j <= col; j ++){
                arr[i][j] = in.nextInt();
            }
        }
        for(int i = 1; i <= row; i ++){
            for(int j = 1; j <= col; j ++){
                insert(i, j, i, j, arr[i][j]);
            }
        }

        while(m -- > 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int c = in.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for(int i = 1; i <= row; i ++){
            for(int j = 1; j <= col; j ++){
                S[i][j] += S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1];
                System.out.print(S[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void insert(int x1, int y1, int x2, int y2, int c){
        S[x1][y1] += c;
        S[x1][y2 + 1] -= c;
        S[x2 + 1][y1] -= c;
        S[x2 + 1][y2 + 1] += c;
    }
}