class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 0) return false;
        boolean result = false;
        for(int i = 0; i < bits.length; ){
            if(bits[i] == 0){
                i += 1;
                result = true;
            }else{
                i += 2;
                result = false;
            }
        }
        return result;
    }
}