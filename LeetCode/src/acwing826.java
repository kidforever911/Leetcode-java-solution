import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static int N = 100010;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int head;
    public static int idx;

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        init();
        for(int i = 0; i < n; i ++){
            String s = in.next();
            if(s.equals("H")){
                int x = in.nextInt();
                insertHead(x);
            }else if(s.equals("I")){
                int k = in.nextInt();
                int x = in.nextInt();
                insert(k - 1, x);
            }else if(s.equals("D")){
                int k = in.nextInt();
                if(k == 0) removeHead();
                else remove(k - 1);
            }
        }
        int i = head;
        while(i != -1){
            System.out.print(e[i] + " ");
            i = ne[i];
        }
    }

    //初始化链表
    private static void init(){
        head = -1;
        idx = 0;
    }

    //将x插入头节点
    private static void insertHead(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    //在第k个节点后面插入x
    private static void insert(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }

    //删除头节点
    private static void removeHead(){
        head = ne[head];
    }

    //删除第k个节点后面的点
    private static void remove(int k){
        ne[k] = ne[ne[k]];
    }
}

