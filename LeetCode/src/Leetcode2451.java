class Solution {
    public String oddString(String[] words) {
        if(words.length == 0 || words[0].length() == 0) return "";
        HashMap<String, String> record = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for(String s : words) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < s.length() - 1; i ++) {
                temp.append(s.charAt(i + 1) - s.charAt(i));
                count.put(temp.toString(), count.getOrDefault(temp.toString(), 0) + 1);
                record.put(temp.toString(), s);
            }
        }

        for(String s : count.keySet()) {
            if(count.get(s) == 1) {
                return record.get(s);
            }
        }

        return "";
    }
}