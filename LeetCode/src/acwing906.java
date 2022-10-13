import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] begin = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i ++) {
            begin[i] = in.nextInt();
            end[i] = in.nextInt();
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int result = 0;
        int endIndex = 0;
        for(int i = 0; i < n; i ++) {
            result ++;
            if(end[endIndex] < begin[i]) {
                result --;
                endIndex ++;
            }
        }
        System.out.println(result);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr, (a, b) -> (a.left - b.left));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i ++) {
            if(pq.isEmpty() || pq.peek() >= arr[i].left) pq.add(arr[i].right);
            else {
                pq.poll();
                pq.add(arr[i].right);
            }
        }
        System.out.println(pq.size());
    }

    static class Pair{
        int left, right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}