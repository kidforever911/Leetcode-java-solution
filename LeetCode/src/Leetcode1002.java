class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if(words.length == 0) return result;
        int[] hash = new int[26];

        for(int i = 0; i < words[0].length(); i ++){
            hash[words[0].charAt(i) - 'a'] += 1;
        }
        for(int i = 1; i < words.length; i ++){
            String cur = words[i];
            int[] minHash = new int[26];
            for(int j = 0; j < cur.length(); j ++){
                minHash[cur.charAt(j) - 'a'] += 1;
            }

            for(int k = 0; k < 26; k ++){
                hash[k] = Math.min(hash[k], minHash[k]);
            }
        }
        for(int i = 0; i < 26; i ++){
            while(hash[i] != 0){
                result.add(String.valueOf((char)(i + 'a')));
                hash[i] --;
            }
        }
        return result;
    }
}