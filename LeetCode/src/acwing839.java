import java.util.*;
import java.io.*;

public class Main{
    private static int N = 100010;
    // h[N]存储堆中的值, h[1]是堆顶，x的左儿子是2x, 右儿子是2x + 1
    // ph[k]存储第k个插入的点在堆中的位置
    // hp[k]存储堆中下标是k的点是第几个插入的
    private static int[] h = new int[N];
    private static int[] ph = new int[N];
    private static int[] hp = new int[N];
    private static int size, index;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        size = 0;
        index = 0;
        while(n -- > 0){
            String operation = in.next();
            if(operation.equals("I")){
                int x = in.nextInt();
                size ++;
                index ++;
                ph[index] = size;
                hp[size] = index;
                h[size] = x;
                up(size);
            }else if(operation.equals("PM")){
                System.out.println(h[1]);
            }else if(operation.equals("DM")){
                heapSwap(1, size);
                size --;
                down(1);
            }else if(operation.equals("D")){
                int k = in.nextInt();
                k = ph[k];
                heapSwap(k, size);
                size --;
                down(k);
                up(k);
            }else{
                int k = in.nextInt();
                int x = in.nextInt();
                k = ph[k];
                h[k] = x;
                down(k);
                up(k);
            }
        }
    }

    private static void heapSwap(int a, int b){
        swap(h, a, b);
        swap(ph, hp[a], hp[b]);
        swap(hp, a, b);
    }

    private static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void down(int u){
        int t = u;
        int left = 2 * t;
        int right = 2 * t + 1;
        if(left <= size && h[left] < h[t]) t = left;
        if(right <= size && h[right] < h[t]) t = right;
        if(t != u){
            heapSwap(t, u);
            down(t);
        }
    }

    private static void up(int u){
        while(u / 2 > 0 && h[u / 2] > h[u]){
            heapSwap(u / 2, u);
            u /= 2;
        }
    }


}