class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> record = new ArrayList<>();
        int[] d = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            record.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            int b = p[0], a = p[1];
            record.get(a).add(b);
            d[b] ++;
        }
        for(int i = 0; i < numCourses; i ++){
            if(d[i] == 0)
                q.add(i);
        }
        int count = 0;
        while(q.size() > 0){
            int temp = q.peek();
            q.poll();
            count ++;
            for(int i : record.get(temp)){
                if(-- d[i] == 0){
                    q.add(i);
                }
            }
        }
        return count == numCourses;

    }
}