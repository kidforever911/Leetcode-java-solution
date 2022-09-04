// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static void main(String[] args) {
        int[][] lamps = {{1, 7}, {5, 11}, {7, 9}};
        int[] points = {7, 1, 5, 10, 9, 15};
        int[] result = solution(lamps, points);
        for(int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
    }
    public static int[] solution(int[][] lamps, int[] points) {
        int[] arr = points.clone();
        Arrays.sort(arr);
        int[] result = new int[points.length + 1];
        for(int[] x : lamps) {
            int leftIndex = findLeft(arr, x[0]);//找到大于等于x[0]的最小值
            int rightIndex = findRight(arr, x[1]);//找到小于等于x[1]的最大值
            result[leftIndex] ++;
            result[rightIndex + 1] --;
        }
        for(int i = 1; i < result.length; i ++) {
            result[i] += result[i - 1];
        }
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < arr.length; i ++) {
            record.put(arr[i], result[i]);
        }
        int[] finalResult = new int[points.length];
        for(int i = 0; i < points.length; i ++) {
            finalResult[i] = record.get(points[i]);
        }
        return finalResult;
    }

    private static int findLeft(int[] arr, int target) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + right >> 1;
            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private static int findRight(int[] arr, int target) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + right + 1 >> 1;
            if(arr[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}
