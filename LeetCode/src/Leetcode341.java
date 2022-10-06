/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> record;
    int k = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        record = new ArrayList<>();
        for(NestedInteger n : nestedList) {
            dfs(n);
        }
    }

    private void dfs(NestedInteger t) {
        if(t.isInteger()) {
            record.add(t.getInteger());
        } else {
            for(NestedInteger n : t.getList()) {
                dfs(n);
            }
        }
    }

    @Override
    public Integer next() {
        return record.get(k ++);
    }

    @Override
    public boolean hasNext() {
        return k < record.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */