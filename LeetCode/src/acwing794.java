import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String s = in.next();
        int x = in.nextInt();
        List<Integer> A = new ArrayList<>();
        for(int i = 0; i < s.length(); i ++) A.add(s.charAt(i) - '0');
        List<Integer> C = div(A, x);
    }

    private static List<Integer> div(List<Integer> A, int x){
        List<Integer> C = new ArrayList<>();
        int r = 0;
        for(int i = 0; i < A.size(); i ++){
            r = 10 * r + A.get(i);
            C.add(r / x);
            r %= x;
        }
        while(C.size() > 1 && C.get(0) == 0){
            C.remove(0);
        }
        for(int i = 0; i < C.size(); i ++){
            System.out.print(C.get(i) + "");
        }
        System.out.printf("\n" + r);
        return C;
    }
}