class BrowserHistory {
    private LinkedList<String> record;
    private int idx;

    public BrowserHistory(String homepage) {
        record = new LinkedList<>();
        record.add(homepage);
    }

    public void visit(String url) {
        record.subList(idx + 1, record.size()).clear();
        record.addLast(url);
        idx ++;
    }

    public String back(int steps) {
        idx = steps >= idx ? 0 : idx - steps;
        return record.get(idx);
    }

    public String forward(int steps) {
        idx = idx + steps >= record.size() ? record.size() - 1 : idx + steps;
        return record.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */