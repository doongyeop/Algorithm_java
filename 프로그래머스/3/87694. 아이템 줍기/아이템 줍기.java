import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] == 1) continue;
                        map[i][j] = 2;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();    
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];
            
            if (x == itemX * 2 && y == itemY * 2) return cnt / 2;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (0 <= nx && nx < 101 && 0 <= ny && ny < 101 && !visited[nx][ny] && map[nx][ny] == 2) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}