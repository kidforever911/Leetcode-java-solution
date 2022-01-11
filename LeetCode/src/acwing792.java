import java.util.*;
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
        if(!check(A, B)) System.out.print("-");
        List<Integer> C = sub(A, B);
        for(int i = C.size() - 1; i >= 0; i --) System.out.print(C.get(i) + "");
    }

    private static boolean check(List<Integer> A, List<Integer> B){
        if(A.size() > B.size()) return true;
        else if(A.size() < B.size()) return false;
        else{
            for(int i = A.size() - 1; i >= 0; i --){
                if(A.get(i) != B.get(i)) return A.get(i) > B.get(i);
            }
        }
        return true;
    }

    private static List<Integer> sub(List<Integer> A, List<Integer> B){
        if(!check(A, B)) return sub(B, A);
        int t = 0;
        List<Integer> C = new ArrayList<>();
        for(int i = 0; i < A.size(); i ++){
            t = A.get(i) - t;
            if(i < B.size()) t -= B.get(i);
            C.add((10 + t) % 10);
            if(t < 0) t = 1;
            else t = 0;
        }
        while(C.size() > 1 && C.get(C.size() - 1) == 0){
            C.remove(C.size() - 1);
        }
        return C;
    }
}