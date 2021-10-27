import java.util.Arrays;

public class Leetcode70 {
    class Solution {
        private int[] record;
        public int climbStairs(int n) {
            record = new int[n + 1];
            Arrays.fill(record, -1);
            return calculateWay(n);
        }

        private int calculateWay(int n){
            if(n == 0 || n == 1){
                return 1;
            }
            if(record[n] == -1){
                record[n] = calculateWay(n - 1) + calculateWay(n - 2);
            }
            return record[n];
        }
    }

    class Solution {
        public int climbStairs(int n) {
            int[] record = new int[n + 1];
            record[0] = 1;
            record[1] = 1;
            for(int i = 2; i <= n; i++){
                record[i] = record[i - 1] + record[i - 2];
            }
            return record[n];
        }
    }
}
