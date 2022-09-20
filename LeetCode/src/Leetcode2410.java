class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int result = 0;
        int n = players.length;
        int m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        for(int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
            if(players[i] <= trainers[j]) {
                i --;
                j --;
                result ++;
            } else if(players[i] > trainers[j]) {
                i --;
            }
        }
        return result;
    }
}