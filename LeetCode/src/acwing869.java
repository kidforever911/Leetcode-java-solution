import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while(n -- > 0){
            int x = in.nextInt();
            List<Integer> result = getDivisors(x);
            Collections.sort(result);
            for(int i = 0; i < result.size(); i ++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> getDivisors(int x){
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= x / i; i ++){
            if(x % i == 0){
                result.add(i);
                if(x / i != i) result.add(x / i);
            }
        }
        return result;
    }
}