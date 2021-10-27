import javafx.util.Pair;

import java.util.LinkedList;
//time complextiy o(n)
public class Leetcode279 {
    class Solution {
        public int numSquares(int n) {
            if(n < 0) return -1;
            LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            visited[n] = true;
            queue.addLast(new Pair<>(n, 0));

            while(!queue.isEmpty()){
                Pair<Integer, Integer> front = queue.removeFirst();
                int num = front.getKey();
                int step = front.getValue();

                if(num == 0)
                    return step;
                for(int i = 0; num - i * i >= 0; i++){
                    int a = num - i * i;
                    if(!visited[a]){
                        if(a == 0)
                            return step + 1;
                        queue.addLast(new Pair(a, step + 1));
                        visited[a] = true;
                    }

                }
            }
            throw new IllegalStateException("No Solution.");
        }

    }
}
