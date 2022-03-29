class Solution {
    int N = 1010;
    public int calPoints(String[] ops) {
        if(ops.length == 0) return 0;
        int index = -1;
        int[] arr = new int[N];
        for(int i = 0; i < ops.length; i ++){
            if(ops[i].equals("+")){
                int a = arr[index];
                int b = arr[index - 1];
                arr[++ index] = a + b;
            }else if(ops[i].equals("D")){
                int x = arr[index] * 2;
                arr[++ index] = x;
            }else if(ops[i].equals("C")){
                index -= 1;
            }else{
                arr[++ index] = Integer.parseInt(ops[i]);
            }
        }
        int result = 0;
        for(int i = 0; i <= index; i ++){
            result += arr[i];
        }
        return result;
    }
}