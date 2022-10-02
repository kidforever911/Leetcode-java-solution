class Solution {
    public int minimizeXor(int num1, int num2) {
        int result = 0;
        int temp1 = num1;
        int countNumberOne = 0;
        while(num2 != 0) {
            if((num2 & 1) == 1) {
                countNumberOne ++;
            }
            num2 >>= 1;
        }
        HashSet<Integer> record = new HashSet<>();
        int index = 0;
        while(num1 != 0) {
            if((num1 & 1) == 1) {
                record.add(index);
            }
            index ++;
            num1 >>= 1;
        }
        int count = countNumberOne - record.size();
        if(count == 0) result = temp1;
        else if(count > 0) {
            int idx = 0;
            while(count != 0){
                if(!record.contains(idx)) {
                    record.add(idx);
                    count --;
                }
                idx ++;
            }
            for(int x : record) {
                result |= (1 << x);
            }
        } else {
            count = Math.abs(count);
            int idx = 0;
            while(count != 0){
                if(record.contains(idx)) {
                    record.remove(idx);
                    count --;
                }
                idx ++;
            }
            for(int x : record) {
                result |= (1 << x);
            }
        }

        return result;
    }
}

class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = 0;
        while(num2 != 0) {
            count += num2 & 1;
            num2 >>= 1;
        }
        int cnt = 0, ans = 0;
        for(int i = 29; i >= 0; i --) {
            if (((num1 >> i) & 1) == 1) {
                if (cnt < count) {
                    cnt++;
                    ans |= 1 << i;
                }
            } else {
                if (cnt + i < count)
                    ans |= 1 << i;
            }
        }

        return ans;
    }
}