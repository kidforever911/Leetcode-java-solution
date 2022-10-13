import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int start = in.nextInt(), end = in.nextInt();
        int n = in.nextInt();
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr, (a, b) -> (a.left - b.left));
        int result = 0;
        boolean success = false;
        for(int i = 0; i < n; i ++) {
            int j = i, right = Integer.MIN_VALUE;
            while(j < n && arr[j].left <= start) {
                right = Math.max(right, arr[j].right);
                j ++;
            }
            if(right < start) {
                result = -1;
                break;
            }
            result ++;
            if(right >= end) {
                success = true;
                break;
            }
            start = right;
            i = j - 1;
        }
        if(!success) result = -1;
        System.out.println(result);
    }

    static class Pair{
        int left, right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}