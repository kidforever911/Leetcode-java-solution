import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int row = in.nextInt();
        int col = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[row + 1][col + 1];
        int[][] S = new int[row + 1][col + 1];
        for(int i = 1; i <= row; i ++){
            for(int j = 1; j <= col; j ++){
                arr[i][j] = in.nextInt();
            }
        }
        for(int i = 1; i <= row; i ++){
            for(int j = 1; j <= col; j ++){
                S[i][j] = arr[i][j] + S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1];
            }
        }
        while(m -- > 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            System.out.println(S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1]);
        }

    }
}