class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] aliceArrive = calculate(arriveAlice);
        int[] aliceLeave = calculate(leaveAlice);
        int[] bobArrive = calculate(arriveBob);
        int[] bobLeave = calculate(leaveBob);
        int result = 0;
        int bob = 0;
        int alice = 0;
        if(aliceArrive[0] > bobArrive[0] || (bobArrive[0] == aliceArrive[0] && bobArrive[1] < aliceArrive[1])) {
            return countDaysTogether(arriveBob, leaveBob, arriveAlice, leaveAlice);
        }
        if(bobArrive[0] > aliceLeave[0] || (bobArrive[0] == aliceLeave[0] && bobArrive[1] > aliceLeave[1])) {
            return 0;
        } else {
            if(bobLeave[0] > aliceLeave[0] || (bobLeave[0] == aliceLeave[0] && bobLeave[1] > aliceLeave[1])) {
                alice += aliceLeave[1];
                for(int i = 0; i < aliceLeave[0] - 1; i ++) {
                    alice += months[i];
                }
                bob += bobArrive[1];
                for(int i = 0; i < bobArrive[0] - 1; i ++) {
                    bob += months[i];
                }
                result = alice - bob + 1;
            } else {
                int temp = 0;
                temp += bobLeave[1];
                for(int i = 0; i < bobLeave[0] - 1; i ++) {
                    temp += months[i];
                }
                bob += bobArrive[1];
                for(int i = 0; i < bobArrive[0] - 1; i ++) {
                    bob += months[i];
                }
                result = temp - bob + 1;
            }
        }
        return result;

    }
    private int[] calculate(String s) {
        int[] arr = new int[2];
        String[] str = s.split("-");
        arr[0] = Integer.parseInt(str[0]);
        arr[1] = Integer.parseInt(str[1]);
        return arr;
    }
}