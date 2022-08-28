/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        HashSet<String> isVisited = new HashSet<>();
        dfs(robot, isVisited, 0, 0, 0);
    }

    private void dfs(Robot robot, HashSet<String> isVisited, int x, int y, int index) {
        robot.clean();
        isVisited.add(x + "-" + y);
        for(int i = 0; i < 4; i ++) {
            int newx = direction[index][0] + x;
            int newy = direction[index][1] + y;
            if(!isVisited.contains(newx + "-" + newy) && robot.move()) {
                dfs(robot, isVisited, newx, newy, index);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            index = (index + 1) % 4;
            robot.turnRight();
        }
    }
}