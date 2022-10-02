class LUPrefix {
    private boolean[] record;
    private int idx = 1;

    public LUPrefix(int n) {
        record = new boolean[n + 1];
    }

    public void upload(int video) {
        record[video] = true;
    }

    public int longest() {
        while(idx < record.length && record[idx]) idx ++;
        return idx - 1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */