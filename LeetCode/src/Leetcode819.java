class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.length() == 0) return "";
        paragraph = paragraph.toLowerCase();
        HashSet<String> ban = new HashSet<>();
        for(String s : banned){
            ban.add(s.toLowerCase());
        }
        HashMap<String, Integer> record = new HashMap<>();
        String word = "";
        char[] letters = paragraph.toCharArray();
        for(int i = 0; i < letters.length; i ++){

            if(letters[i] >= 'a' && letters[i] <= 'z'){
                word += letters[i];
            }else{
                if(word.length() > 0){
                    record.put(word, record.getOrDefault(word, 0) + 1);
                    word = "";
                }
            }
        }
        if(word.length() > 0){
            record.put(word, record.getOrDefault(word, 0) + 1);
        }
        int most = 0;
        String result = "";
        for(String str : record.keySet()){
            if(!ban.contains(str) && record.get(str) > most){
                most = record.get(str);
                result = str;
            }
        }
        return result;
    }
}