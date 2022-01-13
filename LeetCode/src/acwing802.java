import java.util.*;
import java.io.BufferedInputStream;

public class Main{

    public static void main(String[] args){
        int N = 300010;
        int[] a = new int[N];
        int[] s = new int[N];
        List<Integer> axis = new ArrayList<>();
        List<Pairs> add = new ArrayList<>();
        List<Pairs> query = new ArrayList<>();
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
        int n = in.nextInt();
        for(int i = 0; i < m; i ++){
            int x = in.nextInt();
            int c = in.nextInt();
            add.add(new Pairs(x, c));
            axis.add(x);
        }

        for(int i = 0; i < n; i ++){
            int l = in.nextInt();
            int r = in.nextInt();
            query.add(new Pairs(l, r));
            axis.add(l);
            axis.add(r);
        }

        Collections.sort(axis);
        int unique = unique(axis);
        axis = axis.subList(0, unique);

        for(Pairs p : add){
            int x = find(p.getFirtst(), axis);
            a[x] += p.getSecond();
        }

        for(int i = 1; i <= axis.size(); i ++){
            s[i] = s[i - 1] + a[i];
        }

        for(Pairs p : query){
            int l = find(p.getFirtst(), axis);
            int r = find(p.getSecond(), axis);
            System.out.println(s[r] - s[l - 1]);
        }
    }

    private static int unique(List<Integer> axis){
        int j = 0;
        for(int i = 0; i < axis.size(); i ++){
            if(i == 0 || axis.get(i) != axis.get(i - 1)){
                axis.set(j ++, axis.get(i));
            }
        }
        return j;
    }

    private static int find(int x, List<Integer> axis){
        int l = 0, r = axis.size() - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(axis.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return r + 1;
    }

}
class Pairs implements Comparable<Pairs>{
    private int first;
    private int second;

    public int getFirtst(){
        return first;
    }
    public int getSecond(){
        return second;
    }

    public Pairs(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pairs o){
        return Integer.compare(first, o.first);
    }
}