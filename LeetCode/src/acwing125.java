import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Cow[] arr = new Cow[n];
        for(int i = 0; i < n; i ++) {
            int w = in.nextInt();
            int s = in.nextInt();
            arr[i] = new Cow(w + s, w);
        }
        Arrays.sort(arr, (a, b) -> (a.total - b.total));
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i ++) {
            int w = arr[i].w;
            int total = arr[i].total;
            int s = total - w;
            result = Math.max(result, sum - s);
            sum += w;
        }
        System.out.println(result);
    }

    static class Cow {
        int total;
        int w;
        public Cow(int total, int w) {
            this.total = total;
            this.w = w;
        }
    }
}