import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static int N = 100010;
    public static int[] e = new int[N];
    public static int[] l = new int[N];
    public static int[] r = new int[N];
    public static int idx;

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        init();
        for(int i = 0; i < n; i ++){
            String s = in.next();
            if(s.equals("L")){
                int x = in.nextInt();
                add(0, x);
            }else if(s.equals("R")){
                int x = in.nextInt();
                add(l[1], x);
            }else if(s.equals("IL")){
                int k = in.nextInt();
                int x = in.nextInt();
                add(l[k + 1], x);
            }else if(s.equals("IR")){
                int k = in.nextInt();
                int x = in.nextInt();
                add(k + 1, x);
            }else if(s.equals("D")){
                int k = in.nextInt();
                remove(k + 1);
            }
        }
        int i = r[0];
        while(i != 1){
            System.out.print(e[i] + " ");
            i = r[i];
        }
    }

    private static void init(){
        //0是最左端点，1是最右端点，0在1左侧
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    //在第k个节点的右边插入x
    private static void add(int k, int x){
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx;
        idx ++;
    }

    //删除第k个节点
    private static void remove(int k){
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }
}



