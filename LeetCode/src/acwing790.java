import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        double n = in.nextDouble();
        //如果保留6位小数，则这里是1e-8
        double eps = 1e-8;
        double left = -10000, right = 10000;
        while(right - left > eps){
            double mid = (left + right) / 2;
            if(mid * mid * mid >= n) right = mid;
            else left = mid;
        }
        System.out.printf("%.6f", left);
    }
}