class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> record = new HashMap<>();
        for(int i = 0; i < reservedSeats.length; i ++) {
            if(record.containsKey(reservedSeats[i][0])) {
                record.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
            } else{
                HashSet<Integer> temp = new HashSet<>();
                temp.add(reservedSeats[i][1]);
                record.put(reservedSeats[i][0], temp);
            }
        }
        int result = (n - record.size()) * 2;
        for(HashSet<Integer> temp : record.values()) {
            boolean flag = false;
            if(!temp.contains(2) && !temp.contains(3) && !temp.contains(4) && !temp.contains(5)) {
                flag = true;
                result ++;
            }
            if(!temp.contains(6) && !temp.contains(7) && !temp.contains(8) && !temp.contains(9)) {
                flag = true;
                result ++;
            }
            if(!flag) {
                if(!temp.contains(4) && !temp.contains(5) && !temp.contains(6) && !temp.contains(7)) {
                    result ++;
                }
            }
        }
        return result;
    }
}