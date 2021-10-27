public class Leetcode167 {
    //binear search
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if(numbers.length < 2 /*|| !isSorted(numbers)*/)
                throw new IllegalArgumentException("Illegal argument numbers");
            for(int i = 0; i < numbers.length; i++){
                //binary search for last part
                int targetVal = target - numbers[i];
                int left = i + 1;
                int right = numbers.length - 1;

                if(left < 0 || left > numbers.length)
                    throw new IllegalArgumentException("left is out of bound");

                if(right < 0 || right > numbers.length)
                    throw new IllegalArgumentException("right is out of bound");
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(numbers[mid] == targetVal){
                        int[] answer = {i + 1, mid + 1};
                        return answer;
                    }else if(numbers[mid] < targetVal){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
            throw new IllegalStateException("The input has no solution");
        }
    }


    //对撞指针
    //o(n)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int last = numbers.length - 1;
            while(i < last){
                int temp = numbers[i] + numbers[last];
                if(temp == target){
                    int[] answer = {i+1, last+1};
                    return answer;
                }else if(temp < target){
                    i++;
                }else{
                    last--;
                }
            }
            throw new IllegalStateException("The input has no solution");
        }
    }
}
