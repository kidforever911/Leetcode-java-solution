

class Solution {
    private List<String> record;

    public List<Integer> diffWaysToCompute(String expression) {
        record = new ArrayList<>();
        if (expression.length() == 0) return new ArrayList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int j = i, x = 0;
                while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                    x = x * 10 + (expression.charAt(j++) - '0');
                }
                i = j - 1;
                record.add(Integer.toString(x));
            } else {
                record.add(expression.substring(i, i + 1));
            }
        }
        return dfs(0, record.size() - 1);
    }

    private List<Integer> dfs(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left == right) result.add(Integer.parseInt(record.get(left)));
        else {
            for (int i = left + 1; i < right; i += 2) {
                List<Integer> l = dfs(left, i - 1);
                List<Integer> r = dfs(i + 1, right);
                for (int x : l)
                    for (int y : r) {
                        int z = 0;
                        if (record.get(i).equals("+")) z = x + y;
                        else if (record.get(i).equals("-")) z = x - y;
                        else z = x * y;
                        result.add(z);
                    }
            }
        }
        return result;
    }
}