import java.util.Arrays;


class Solution {
    private int[] record;

    public int integerBreak(int n) {
        assert (n >= 2);
        record = new int[n + 1];
        Arrays.fill(record, -1);
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) return 1;
        if (record[n] != -1) return record[n];

        int result = -1;
        for (int i = 1; i <= n - 1; i++) {
            result = Math.max(result, Math.max(i * (n - i), i * (breakInteger(n - i))));
        }
        record[n] = result;
        return result;
    }
}

class Solution {
    public int integerBreak(int n) {
        assert (n >= 2);
        int[] record = new int[n + 1];
        Arrays.fill(record, -1);

        record[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                record[i] = Math.max(record[i], Math.max(j * (i - j), j * record[i - j]));
            }
        }
        return record[n];
    }
}


class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return 1 * (n - 1);
        int result = 1;
        if(n % 3 == 1){
            result *= 4;
            n -= 4;
        }
        if(n % 3 == 2){
            result *= 2;
            n -= 2;
        }
        while(n > 0){
            result *= 3;
            n -= 3;
        }
        return result;
    }
}