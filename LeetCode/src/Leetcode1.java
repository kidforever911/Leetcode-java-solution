import java.util.HashMap;


    //time complexity:o(n^2)
public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for(int i = 0; i < nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
            int sum = nums[i] + nums[j];
            if(sum == target){
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    return result;
}

    //time complexity:o(n)
public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        map.put(nums[i], i);
    }
    for(int j = 0; j < nums.length; j++){
        int diff = target - nums[j];
        if(map.containsKey(diff) && map.get(diff) != j){
            result[0] = j;
            result[1] = map.get(diff);
            return result;
        }
    }
    return result;
}
