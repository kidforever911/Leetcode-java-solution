class Solution {
    public String originalDigits(String s) {
        if(s.length() == 0) return s;
        List<Integer> result = new ArrayList<>();
        String[] name = {
                "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"
        };
        int[] order = {0, 8, 3, 2, 6, 4, 5, 1, 7, 9};
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c - 'a'] ++;
        for(int x : order) {
            boolean flag = true;
            while(flag) {
                for(char c : name[x].toCharArray()) {
                    if(count[c - 'a'] <= 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    result.add(x);
                    for(char c : name[x].toCharArray()) count[c - 'a'] --;
                }
            }
        }
        Collections.sort(result);
        StringBuilder ans = new StringBuilder();
        for(int i : result) {
            ans.append((char)('0' + i));
        }
        return ans.toString();
    }
}