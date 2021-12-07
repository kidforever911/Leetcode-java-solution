class Solution {
    private boolean[][] visited;
    private int direction[][] = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    private static class Node{
        int first;
        int second;

        public Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows < 1 || cols < 1) return 0;
        visited = new boolean[rows][cols];
        visited[0][0] = true;
        Queue<Node> record = new LinkedList<>();
        record.add(new Node(0, 0));
        int result = 0;
        while(!record.isEmpty()){
            Node tempNode = record.poll();
            result ++;

            for(int i = 0; i < 4; i ++){
                int newx = tempNode.first + direction[i][0];
                int newy = tempNode.second + direction[i][1];
                if(newx >=0 && newx < rows && newy >= 0 && newy < cols && getSum(newx, newy) <= threshold && !visited[newx][newy]){
                    record.add(new Node(newx, newy));
                    visited[newx][newy] = true;
                }
            }
        }
        return result;
    }

    private int getSingle(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    private int getSum(int x, int y){
        return getSingle(x) + getSingle(y);
    }

}