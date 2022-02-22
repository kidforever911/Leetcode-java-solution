import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> record = new ArrayList<>();
        int[] d = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            record.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            int b = p[0], a = p[1];
            record.get(a).add(b);
            d[b] ++;
        }
        for(int i = 0; i < numCourses; i ++){
            if(d[i] == 0)
                q.add(i);
        }
        int count = 0;
        while(q.size() > 0){
            int temp = q.peek();
            q.poll();
            count ++;
            for(int i : record.get(temp)){
                if(-- d[i] == 0){
                    q.add(i);
                }
            }
        }
        return count == numCourses;

    }
}

class Solution {
    private int N = 10010, M = 2 * N, idx = 0;
    private int[] h = new int[N];
    private int[] ne = new int[M];
    private int[] e = new int[M];
    private int[] q = new int[N];
    private int[] d = new int[N];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.fill(h, -1);
        for(int[] course : prerequisites){
            int a = course[0];
            int b = course[1];
            add(b, a);
            d[a] += 1;
        }
        int[] result = new int[numCourses];
        return topSort(numCourses);
    }

    private void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private boolean topSort(int n){
        int hh = 0, tt = -1;
        for(int i = 0; i < n; i ++){
            if(d[i] == 0){
                q[++ tt] = i;
            }
        }
        while(tt >= hh){
            int head = q[hh ++];
            for(int i = h[head]; i != -1; i = ne[i]){
                int j = e[i];
                d[j] --;
                if(d[j] == 0) q[++ tt] = j;
            }
        }
        return tt == n - 1;
    }
}