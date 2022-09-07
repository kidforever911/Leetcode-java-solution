class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> record = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i --) {
            while(!record.isEmpty() && temperatures[i] >= temperatures[record.peek()]) record.pop();
            if(record.isEmpty()) result[i] = 0;
            else result[i] = record.peek() - i;
            record.add(i);
        }
        return result;
    }
}

class Solution {
    private int[] record;
    private int hh = 0;
    private int tt = -1;
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        record = new int[n];
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i --) {
            while(tt >= hh && temperatures[i] >= temperatures[record[tt]]) tt --;
            if(tt < hh) result[i] = 0;
            else result[i] = record[tt] - i;
            record[++ tt] = i;
        }
        return result;
    }
}