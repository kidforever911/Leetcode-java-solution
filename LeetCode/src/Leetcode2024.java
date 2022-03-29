class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        if(answerKey.length() == 0) return 0;
        int result = Integer.MIN_VALUE;
        int countT = 0, countF = 0;
        char[] letters = answerKey.toCharArray();
        //都变成T的时候最大的T的数目
        for(int slow = 0, fast = 0; fast < letters.length; fast ++){
            if(letters[fast] == 'T'){
                countT ++;
            }else{
                countF ++;
                countT ++;
            }
            while(countF > k){
                if(letters[slow] == 'T'){
                    countT --;
                    slow ++;
                }else{
                    countF --;
                    countT --;
                    slow ++;
                }
            }
            result = Math.max(result, countT);
        }

        countF = 0;
        countT = 0;
        //都变成F的时候最大的F的数目
        for(int slow = 0, fast = 0; fast < letters.length; fast ++){
            if(letters[fast] == 'F'){
                countF ++;
            }else{
                countT ++;
                countF ++;
            }
            while(countT > k){
                if(letters[slow] == 'F'){
                    countF --;
                    slow ++;
                }else{
                    countT --;
                    countF --;
                    slow ++;
                }
            }
            result = Math.max(result, countF);
        }
        return result;
    }
}