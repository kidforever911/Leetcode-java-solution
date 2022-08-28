class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> record = new PriorityQueue<>(
                (a, b) -> (Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x))
        );
        for(int i = 0; i < arr.length; i ++) {
            record.add(arr[i]);
        }
        int index = 0;
        while(index < k && !record.isEmpty()) {
            result.add(record.poll());
            index ++;
        }
        Collections.sort(result);
        return result;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = left + right >> 1;
            if(arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        if(right > 0) {
            int a = arr[right - 1], b = arr[right];
            if(check(a, b, x)) right --;
        }
        int i = right, j = right;
        for(int u = 0; u < k - 1; u ++) {
            if(i - 1 < 0) j ++;
            else if(j + 1 >= arr.length) i --;
            else {
                int m = arr[i - 1], n = arr[j + 1];
                if(check(m, n, x)) i --;
                else j ++;
            }
        }
        for(int u = i; u <= j; u ++) {
            result.add(arr[u]);
        }
        return result;
    }

    private boolean check(int a, int b, int x) {
        if(Math.abs(a - x) < Math.abs(b - x) || (a < b && Math.abs(a - x) == Math.abs(b - x))) {
            return true;
        } else {
            return false;
        }
    }
}