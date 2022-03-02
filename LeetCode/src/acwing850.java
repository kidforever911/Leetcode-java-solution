import java.util.*;
import java.io.*;

public class Main{
    private static int N = 150010, M = 2 * N, max = Integer.MAX_VALUE;
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] w = new int[M];
    private static int[] ne = new int[M];
    private static int n, m, idx;
    private static boolean[] visited = new boolean[N];
    private static int[] dist = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);

        }
        int result = dijkstra();
        System.out.println(result);
        return;
    }

    private static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    private static int dijkstra(){
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> (o1.getDistance() - o2.getDistance()));
        Arrays.fill(dist, max);
        dist[1] = 0;
        queue.add(new Pair(0, 1));
        while(queue.size() > 0){
            Pair cur = queue.poll();
            int distance = cur.getDistance();
            int point = cur.getPoint();
            if(visited[point]) continue;
            visited[point] = true;

            for(int i = h[point]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    queue.add(new Pair(dist[j], j));
                }
            }
        }
        if(dist[n] == max) return -1;
        return dist[n];
    }
}

//
class Pair{
    int distance;
    int point;
    public int getDistance(){
        return distance;
    }
    public int getPoint(){
        return point;
    }
    public Pair(){}
    public Pair(int distance, int point){
        this.distance = distance;
        this.point = point;
    }
}