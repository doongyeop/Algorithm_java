import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            if (x == n - 1 && y == m - 1) {
                answer = dist;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] == 1) { 
                    q.offer(new int[] {nx, ny, dist + 1});
                    maps[nx][ny] = 0;                    
                }                
            }
        } // while
        return answer == 0 ? -1 : answer;
    } // solution
} // class