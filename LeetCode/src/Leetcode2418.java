class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Integer> record = new PriorityQueue<>((a, b) -> (heights[b] - heights[a]));
        for(int i = 0; i < heights.length; i ++) {
            record.add(i);
        }
        String[] result = new String[names.length];
        int index = 0;
        while(!record.isEmpty()) {
            result[index ++] = names[record.poll()];
        }
        return result;
    }
}