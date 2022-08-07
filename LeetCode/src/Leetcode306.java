class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length(); i ++) {
            for(int j = i + 1; j + 1 < num.length(); j ++) {
                int a = -1, b = i, c = j;
                while(true) {
                    String x = num.substring(a + 1, b + 1);
                    String y = num.substring(b + 1, c + 1);
                    if(x.length() > 1 && x.charAt(0) == '0') break;
                    if(y.length() > 1 && y.charAt(0) == '0') break;
                    String z = add(x, y);
                    if (c + z.length() + 1 <= num.length() && num.substring(c + 1, c + z.length() + 1).equals(z)) {
                        a = b;
                        b = c;
                        c += z.length();
                        if(c + 1 == num.length()) return true;
                    } else{
                        break;
                    }
                }
            }
        }
        return false;
    }

    private String add(String x, String y) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        for(int i = x.length() - 1; i >= 0; i --) A.add(x.charAt(i) - '0');
        for(int i = y.length() - 1; i >= 0; i --) B.add(y.charAt(i) - '0');
        for(int i = 0, t = 0; i < A.size() || i < B.size() || t > 0; i ++) {
            if(i < A.size()) t += A.get(i);
            if(i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        String result = "";
        for(int i = C.size() - 1; i >= 0; i --) {
            result += C.get(i);
        }
        return result;
    }
}