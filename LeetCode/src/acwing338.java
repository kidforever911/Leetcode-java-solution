import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == 0 && b == 0) continue;
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            for(int i = 0; i < 10; i ++) {
                System.out.print(count(b, i) - count(a - 1, i) + " ");
            }
            System.out.println();
        }
    }

    private static int count(int n, int x) {
        if(n == 0) return 0;
        List<Integer> record = new ArrayList<>();
        while(n > 0) {
            record.add(n % 10);
            n /= 10;
        }
        n = record.size();
        int result = 0;
        for(int i = x == 0 ? n - 2 : n - 1; i >= 0; i --) {
            if(i < n - 1) {
                result += get(record, n - 1, i + 1) * power10(i);
                if(x == 0) result -= power10(i);
            }
            if(record.get(i) == x) result += get(record, i - 1, 0) + 1;
            else if(record.get(i) > x) result += power10(i);
        }
        return result;
    }

    private static int get(List<Integer> record, int l, int r) {
        int result = 0;
        for(int i = l; i >= r; i --) {
            result = result * 10 + record.get(i);
        }
        return result;
    }

    private static int power10(int x) {
        int result = 1;
        while(x -- > 0) result *= 10;
        return result;
    }
}