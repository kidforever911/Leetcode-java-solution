class OrderedStream {
    private String[] arr;
    private int count = 1;

    public OrderedStream(int n) {
        arr = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        arr[idKey] = value;
        if(idKey == count) {
            while(count < arr.length && arr[count] != null){
                result.add(arr[count]);
                count ++;
            }
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */