class ProductOfNumbers {
    List<Integer> record;

    public ProductOfNumbers() {
        record = new ArrayList<>();
        record.add(1);
    }

    public void add(int num) {
        if(num > 0) {
            record.add(record.get(record.size() - 1) * num);
        } else {
            record = new ArrayList<>();
            record.add(1);
        }
    }

    public int getProduct(int k) {
        int n = record.size();
        return k < n ? record.get(n - 1) / record.get(n - 1 - k) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */