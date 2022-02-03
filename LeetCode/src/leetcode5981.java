import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int score = 0, temp = 0, maxScore = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 1){
                temp += 1;
                score += 1;
            }
        }
        for(int i = 0; i <= nums.length; i ++){
            maxScore = Math.max(maxScore, temp);
            if(i < nums.length && nums[i] == 0){
                temp += 1;
            }
            if(i < nums.length && nums[i] == 1){
                temp -= 1;
            }

        }
        for(int i = 0; i <= nums.length; i ++){
            if(score == maxScore){
                result.add(i);
            }
            if(i < nums.length && nums[i] == 0){
                score += 1;
            }
            if(i < nums.length && nums[i] == 1){
                score -= 1;
            }

        }
        return result;
    }
}