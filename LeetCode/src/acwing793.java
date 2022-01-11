import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String s = in.next();
        int x = in.nextInt();
        List<Integer> A = new ArrayList<>();
        for(int i = s.length() - 1; i >= 0; i --) A.add(s.charAt(i) - '0');
        List<Integer> C = multiply(A, x);
        for(int i = C.size() - 1; i >= 0; i --) System.out.print(C.get(i) + "");
    }

    private static List<Integer> multiply(List<Integer> A, int x){
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for(int i = 0; i < A.size() | t > 0; i ++){
            if(i < A.size()) t += A.get(i) * x;
            C.add(t % 10);
            t /= 10;
        }
        while(C.size() > 1 && C.get(C.size() - 1) == 0){
            C.remove(C.size() - 1);
        }
        return C;
    }
}