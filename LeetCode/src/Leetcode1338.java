class Solution {
    public int minSetSize(int[] arr) {
        if(arr.length == 0) return 0;
        int result = 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (record.get(b) - record.get(a)));
        int half = arr.length / 2;
        for(int i = 0; i < arr.length; i ++){
            record.put(arr[i], record.getOrDefault(arr[i], 0) + 1);
        }
        for(int i : record.keySet()){
            q.add(i);
        }
        int temp = 0;
        while(q.size() > 0) {
            temp += record.get(q.poll());
            result += 1;
            if(temp >= half) {
                break;
            }
        }
        return result;
    }
}