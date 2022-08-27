class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> record = new Stack<>();
        for(int i = 0; i < asteroids.length; i ++) {
            if(asteroids[i] > 0) {
                record.add(asteroids[i]);
            } else {
                while(record.size() > 0 && record.peek() > 0 && record.peek() < -asteroids[i]) {
                    record.pop();
                }
                if(record.size() > 0 && record.peek() > 0 && record.peek() == -asteroids[i]) {
                    record.pop();
                } else if(record.size() > 0 && record.peek() > -asteroids[i]) {

                } else {
                    record.add(asteroids[i]);
                }
            }
        }
        int[] result = new int[record.size()];
        for(int i = result.length - 1; i >= 0; i --) {
            result[i] = record.pop();
        }
        return result;
    }
}