import java.util.*;

class Solution {
    
    char[][] maze;
    final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    int r, c;
    int[] start, end, lever;
        
    public int solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        maze = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            String str = maps[i];
            for (int j = 0; j < c; j++) {
                char ch = str.charAt(j);
                maze[i][j] = ch;
                if (ch == 'S') {
                    start = new int[] {i, j};
                } else if (ch == 'E') {
                    end = new int[] {i, j};
                } else if (ch == 'L') {
                    lever = new int[] {i, j};
                }
            }
        }
        
        int leverCnt = bfs(start, lever);
        if (leverCnt == -1) return -1; 
        
        int exitCnt = bfs(lever, end);
        if (exitCnt == -1) return -1; 
        
        return leverCnt + exitCnt;
    }
    
    public int bfs(int[] from, int[] to) {
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {from[0], from[1], 0});
        visited[from[0]][from[1]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            if (x == to[0] && y == to[1]) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (!isIn(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (maze[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, dist + 1});
            }
        }
        
        return -1; 
    }
    
    public boolean isIn(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}
