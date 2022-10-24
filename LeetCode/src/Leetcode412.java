class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) return result;
        int index = 1;
        while(index <= n) {
            if(index % 3 == 0 && index % 5 == 0) {
                result.add("FizzBuzz");
            } else if(index % 3 == 0) {
                result.add("Fizz");
            } else if(index % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(index));
            }
            index ++;
        }
        return result;
    }
}