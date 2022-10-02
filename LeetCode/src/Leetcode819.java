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

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.toLowerCase();
        HashMap<String, Integer> record = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(String temp : banned) {
            set.add(temp);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : paragraph.toCharArray()) {
            char lower = Character.toLowerCase(c);
            if(lower >= 'a' && lower <= 'z') {
                sb.append(lower);
            } else {
                if(sb.length() > 0) {
                    record.put(sb.toString(), record.getOrDefault(sb.toString(), 0) + 1);
                    sb = new StringBuilder();
                }
            }
        }
        if(sb.length() > 0) record.put(sb.toString(), record.getOrDefault(sb.toString(), 0) + 1);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (record.get(b) - record.get(a)));
        for(String temp : record.keySet()) {
            pq.add(temp);
        }
        String result = "";
        while(!pq.isEmpty()) {
            String temp = pq.poll();
            if(!set.contains(temp)) {
                result = temp;
                break;
            }
        }
        return result;
    }
}