class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[0];
        int n = arr.length;
        int[] result = new int[n];
        int rank = 1;
        TreeSet<Integer> record = new TreeSet<>();
        HashMap<Integer, Integer> recordRank = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            record.add(arr[i]);
        }
        for(int i : record) {
            recordRank.put(i, rank ++);
        }
        for(int i = 0; i < n; i ++) {
            result[i] = recordRank.get(arr[i]);
        }
        return result;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[0];
        int[] temp = arr.clone();
        int[] result = new int[arr.length];
        Arrays.sort(temp);
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < temp.length; i ++) {
            record.putIfAbsent(temp[i], record.size() + 1);
        }
        for(int i = 0; i < result.length; i ++) {
            result[i] = record.get(arr[i]);
        }
        return result;
    }
}