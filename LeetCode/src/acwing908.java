import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr, (a, b) -> (a.right - b.right));
        int result = 0, end = Integer.MIN_VALUE;
        for(Pair temp : arr) {
            if(temp.left > end) {
                result ++;
                end = temp.right;
            }
        }
        System.out.println(result);
    }

    static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}

