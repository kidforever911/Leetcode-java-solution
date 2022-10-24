import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            if (p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        if (k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            if (freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if (k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new PairComparator());
        for (Integer num : freq.keySet()) {
            int numFreq = freq.get(num);
            if (pq.size() == k) {
                if (numFreq > pq.peek().getKey()) {
                    pq.poll();
                    pq.add(new Pair(numFreq, num));
                }
            } else
                pq.add(new Pair(numFreq, num));
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().getValue();
        }

        return res;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> record.get(n1) - record.get(n2));
        for (int i : record.keySet()) {
            pq.add(i);
            if (pq.size() > k)
                pq.remove();
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.remove();
        }
        return result;
    }
}

