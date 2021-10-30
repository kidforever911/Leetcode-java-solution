//merge
import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        ArrayList<int[]> record = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            int[] a = new int[2];
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            record.add(a);
        }

        System.out.print(merge(record));
    }

    private static int merge(ArrayList<int[]> record){
        ArrayList<int[]> result = new ArrayList<>();
        record.sort(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return a1[0] - a2[0];
            }
        });
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for(int[] a : record){
            if(a[0] > end){
                if(start != Integer.MIN_VALUE){
                    result.add(new int[]{start, end});
                }
                start = a[0];
                end = a[1];
            }else{
                end = Math.max(end, a[1]);
            }
        }
        if(start != Integer.MIN_VALUE){
            result.add(new int[]{start, end});
        }
        return result.size();

    }
}