class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] d = new int[n];
        for(int i = 0; i < n; i ++) {
            if(leftChild[i] != -1) {
                d[leftChild[i]] ++;
            }
            if(rightChild[i] != -1) {
                d[rightChild[i]] ++;
            }
        }
        int root = 0;
        while(root < n && d[root] > 0) root ++;
        if(root == n) return false;
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        q.add(root);
        isVisited[root] = true;
        while(q.size() > 0) {
            int cur = q.poll();
            int[] sons = new int[]{leftChild[cur], rightChild[cur]};
            for(int son : sons) {
                if(son != -1) {
                    if(isVisited[son]) return false;
                    isVisited[son] = true;
                    q.add(son);
                }
            }
        }
        for(boolean state : isVisited) {
            if(!state) return false;
        }
        return true;
    }
}