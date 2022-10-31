class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        if(queries.length == 0 || dictionary.length == 0) return result;
        for(String s : queries) {
            if(check(s, dictionary)) {
                result.add(s);
            }
        }
        return result;
    }

    private boolean check(String s, String[] dictionary) {
        for(String d : dictionary) {
            boolean record = true;
            int count = 0;

            for(int i = 0; i < d.length(); i ++) {
                if(s.charAt(i) != d.charAt(i)) {
                    count ++;
                }
                if(count > 2) {
                    record = false;
                    break;
                }
            }
            if(record) return true;
        }

        return false;
    }
}