//time complextiy o(n)

class Solution {
    public int numSquares(int n) {
        if (n < 0) return -1;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        queue.addLast(new Pair<>(n, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0)
                return step;
            for (int i = 0; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0)
                        return step + 1;
                    queue.addLast(new Pair(a, step + 1));
                    visited[a] = true;
                }

            }
        }
        throw new IllegalStateException("No Solution.");
    }

}
//time complexity o(sqrt(n))
class Solution {
    public int numSquares(int n) {
        if(check(n)) return 1;
        for(int i = 1; i < n / i; i ++){
            if(check(n - i * i))
                return 2;
        }
        while(n % 4 == 0) n /= 4;
        if(n %8 != 7) return 3;
        return 4;
    }
    private boolean check(int x) {
        int r = (int)Math.sqrt(x);
        return r * r == x;
    }
}

