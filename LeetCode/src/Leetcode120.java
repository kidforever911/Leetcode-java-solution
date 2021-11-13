import java.util.Arrays;
import java.util.List;


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        for(int i = triangle.size() - 2; i >= 0; i --){
            for(int j = 0; j <= i; j ++){
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] record = new int[triangle.size()][triangle.size()];

        for (int[] row : record) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return calculateMinimum(triangle, 0, 0, record);
    }

    private int calculateMinimum(List<List<Integer>> triangle, int level, int col, int[][] record) {
        if (level == triangle.size())
            return 0;

        if (record[level][col] != Integer.MIN_VALUE) {
            return record[level][col];
        }

        int leftSum = calculateMinimum(triangle, level + 1, col, record);
        int rightSum = calculateMinimum(triangle, level + 1, col + 1, record);

        int currentBestSum = triangle.get(level).get(col) + Math.min(leftSum, rightSum);

        record[level][col] = currentBestSum;

        return currentBestSum;
    }
}

