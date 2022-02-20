//拉链法

import java.io.*;
import java.util.*;

public class Main {
    private static int N = (int) 100003;
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Arrays.fill(h, -1);
        while (n-- > 0) {
            String operation = in.next();
            int x = in.nextInt();
            if (operation.equals("I")) {
                insert(x);
            } else {
                if (find(x)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx;
        idx++;
    }

    private static boolean find(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }
}

//开放寻址法


public class Main {
    private static int N = (int) 100003;
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Arrays.fill(h, -1);
        while (n-- > 0) {
            String operation = in.next();
            int x = in.nextInt();
            if (operation.equals("I")) {
                insert(x);
            } else {
                if (find(x)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx;
        idx++;
    }

    private static boolean find(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }
}
