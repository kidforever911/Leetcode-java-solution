import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String a = in.next();
        String b = in.next();
        List<Integer> A = new ArrayList<>(a.length());
        List<Integer> B = new ArrayList<>(b.length());
        for(int i = a.length() - 1; i >= 0; i --) A.add(a.charAt(i) - '0');
        for(int i = b.length() - 1; i >= 0; i --) B.add(b.charAt(i) - '0');
        List<Integer> C = add(A, B);
        for(int i = C.size() - 1; i >= 0; i --) System.out.print(C.get(i) + "");
    }

    private static List<Integer> add(List<Integer> A, List<Integer> B){
        int t = 0;
        List<Integer> C = new ArrayList<>(Math.max(A.size(), B.size()) + 1);
        for(int i = 0; i < A.size() || i < B.size(); i ++){
            if(i < A.size()) t += A.get(i);
            if(i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        if(t > 0) C.add(t);
        return C;
    }
}