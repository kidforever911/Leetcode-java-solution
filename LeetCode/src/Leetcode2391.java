class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int countG = 0, countP = 0, countM = 0;
        int lastG = 0, lastP = 0, lastM = 0;
        for(int i = 0; i < garbage.length; i ++) {
            String s = garbage[i];
            for(char c : s.toCharArray()) {
                if(c == 'G') {
                    countG += 1;
                    lastG = Math.max(lastG, i);
                } else if (c == 'M') {
                    countM += 1;
                    lastM = Math.max(lastM, i);
                } else {
                    countP += 1;
                    lastP = Math.max(lastP, i);
                }
            }
        }
        int result = 0;
        if(countG > 0) {
            for(int i = 0; i < lastG; i ++) {
                result += travel[i];
            }
            result += countG;
        }
        if(countM > 0) {
            for(int i = 0; i < lastM; i ++) {
                result += travel[i];
            }
            result += countM;
        }
        if(countP > 0) {
            for(int i = 0; i < lastP; i ++) {
                result += travel[i];
            }
            result += countP;
        }
        return result;
    }
}