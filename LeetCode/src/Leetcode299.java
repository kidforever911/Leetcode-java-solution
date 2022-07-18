class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char c : secret.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        int total = 0;
        for(char c : guess.toCharArray()) {
            if(hash.containsKey(c) && hash.get(c) != 0) {
                total ++;
                hash.put(c, hash.get(c) - 1);
            }
        }
        int bulls = 0;
        for(int i = 0; i < secret.length(); i ++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls ++;
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(total - bulls) + "B";
    }
}