class Solution {
    public int longestPalindrome(String[] words) {
        if(words.length == 0) return 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(String s : words) {
            int temp = (s.charAt(1) - 'a') * 26 + (s.charAt(0) - 'a');
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }
        int result = 0;
        boolean mid = false;
        for(int x = 0; x < 26; x ++) {
            if(record.containsKey(x * 26 + x)) {
                int count = record.get(x * 26 + x);
                if(count % 2 == 0) {
                    result += count * 2;
                } else {
                    if(mid) result += (count - 1) * 2;
                    else result += count * 2;
                    mid = true;
                }
            }

            for(int y = x + 1; y < 26; y ++) {
                result += Math.min(record.getOrDefault(26 * x + y, 0), record.getOrDefault(26 * y + x, 0)) * 4;
            }
        }

        return result;
    }
}