class Solution {
    public int[] findArray(int[] pref) {
        if(pref.length == 1) return pref;
        int[] arr = new int[pref.length];
        for(int i = 0; i < pref.length; i ++) {
            arr[i] = i == 0 ? pref[i] : pref[i] ^ pref[i - 1];
        }
        return arr;
    }
}