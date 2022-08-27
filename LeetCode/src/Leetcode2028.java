import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = m + n;
        int score = total * mean;
        int need = 0;
        for(int i = 0; i < rolls.length; i ++){
            score -= rolls[i];
        }

        if(score < n || score > n * 6) return new int[0];
        int[] result = new int[n];
        int index = 0;
        Arrays.fill(result, score / n);
        if(score / n * n < score){
            int d = score - (score / n * n);
            while(d -- > 0) result[index ++] ++;
        }
        return result;
    }
}

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int m = rolls.length;
        int total = (m + n) * mean;
        for(int i = 0; i < rolls.length; i ++) {
            total -= rolls[i];
        }
        int t = total / n;
        int left = total % n;
        if((t >= 6 && left > 0) || t <= 0 || t > 6) return new int[0];
        for(int i = 0; i < result.length; i ++) {
            result[i] = t;
        }
        int index = 0;
        while(left > 0) {
            result[index ++] ++;
            left --;
        }
        return result;
    }
}