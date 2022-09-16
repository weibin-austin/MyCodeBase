package LeetcodeSolutions.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze490 {
    public static void main(String[] args) {
        int[][] maze = new int[][] {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] destination = new int[]{4,4};
        System.out.println(hasPath(maze, start, destination));
    }
/*
      思路： BFS模版 + for dir：dirs + while(x += dir[0]; y += dir[1]) while 循环持续走同一个方向，直到走出边界
       while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0)
      跳出while循环后，需要向后退一步，才能得到满足条件的边界值 x -= dir[0]; y -= dir[1]
 */
    public static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for(int[] dir: dirs) {
                int x = cur[0], y = cur[1];
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];

                if(!visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
