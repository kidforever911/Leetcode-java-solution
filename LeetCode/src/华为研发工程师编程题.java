import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            String s = in.next();
            int result = change(s);
            System.out.println(result);
        }
    }
    private static int change(String s){
        char[] letters = s.toCharArray();
        int r = 0;
        int a = 0;
        int result = 0;
        for(int i = letters.length - 1; i >= 2; i --){
            if(letters[i] == 'A')
                r = 10;
            else if(letters[i] == 'B')
                r = 11;
            else if(letters[i] == 'C')
                r = 12;
            else if(letters[i] == 'D')
                r = 13;
            else if(letters[i] == 'E')
                r = 14;
            else if(letters[i] == 'F')
                r = 15;
            else
                r = Integer.valueOf(letters[i]) - 48;
            //System.out.println("---" + r);
            result += r * Math.pow(16, a ++);
        }
        return result;
    }
}



import java.util.*;
        import java.io.*;

public class Main{
    public static void main(String[] args){
        int[] arr = new int[4];
        arr[2] = arr[3] = 1;
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(true){
            int t = in.nextInt();
            if(t == 0){
                break;
            }
            int result = 0;
            while(t > 3){
                int remain = t % 3;
                int cola = t / 3;
                t = cola + remain;
                result += cola;
            }
            result += arr[t];
            System.out.println(result);
        }
    }
}


import java.util.*;
        import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            int m = in.nextInt();
            HashSet<Integer> record = new HashSet<>();
            while(m -- > 0){
                int temp = in.nextInt();
                record.add(temp);
            }
            int[] arr = new int[record.size()];
            int index = 0;
            for(int i : record){
                arr[index ++] = i;
            }
            quickSort(arr, 0, record.size() - 1);
            for(int i = 0; i < record.size(); i ++)
                System.out.println(arr[i]);
        }


    }
    private static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int i = left - 1, j = right + 1, x = arr[left + right >> 1];
        while(i < j){
            do{
                i ++;
            }while(arr[i] < x);
            do{
                j --;
            }while(arr[j] > x);
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }
}