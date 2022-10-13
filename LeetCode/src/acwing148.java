import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        PriorityQueue<Integer> record = new PriorityQueue<>();
        while(n -- > 0) {
            record.add(in.nextInt());
        }
        int result = 0;
        while(record.size() > 1) {
            int a = record.poll();
            int b = record.poll();
            result += a + b;
            record.add(a + b);
        }
        System.out.println(result);
    }
}