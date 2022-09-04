class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> record = new ArrayList<>();
        for(int i = 1; i <= 9; i ++) {
            dfs(1, i, n, k, record);
        }
        int[] result = new int[record.size()];
        for(int i = 0; i < record.size(); i ++) {
            result[i] = record.get(i);
        }

        return result;
    }

    private void dfs(int index, int number, int n, int k, List<Integer> record) {
        if(index == n) {
            record.add(number);
        } else {
            if(number % 10 - k >= 0) {
                dfs(index + 1, number * 10 + number % 10 - k, n, k, record);
            }
            if (k != 0 && (number % 10 + k < 10)) {
                dfs(index + 1, number * 10 + number % 10 + k, n, k, record);
            }
        }
        return;
    }
}