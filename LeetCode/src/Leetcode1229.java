class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for(int i = 0, j = 0; i < slots1.length && j < slots2.length; ) {
            int time = Math.min(slots2[j][1], slots1[i][1]) - Math.max(slots2[j][0], slots1[i][0]);
            if(time >= duration) {
                result.add(Math.max(slots2[j][0], slots1[i][0]));
                result.add(Math.max(slots2[j][0], slots1[i][0]) + duration);
                break;
            }
            if(slots1[i][1] > slots2[j][1]) j ++;
            else i ++;
        }
        return result;
    }
}