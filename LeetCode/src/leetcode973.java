class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        if(points.length == 0 || points[0].length == 0) return result;
        quickSelect(points, 0, points.length - 1, k);
        for(int i = 0; i < k; i ++){
            result[i] = points[i];
        }
        return result;
    }

    private void quickSelect(int[][] arr, int left, int right, int k){
        if(left >= right) return;
        int i = left - 1, j = right + 1;
        int[] x = arr[left + right >> 1];
        while(i < j){
            do i ++; while(getDist(arr[i]) < getDist(x));
            do j --; while(getDist(arr[j]) > getDist(x));
            if(i < j){
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int sl = j - left + 1;
        if (k <= sl) quickSelect(arr, left, j, k);
        else quickSelect(arr, j + 1, right, k - sl);
    }

    private int getDist(int[] x){
        int a = x[0];
        int b = x[1];
        return a * a + b * b;
    }
}