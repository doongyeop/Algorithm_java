import java.util.*;

class Solution {
    
    int r, c, startX, startY;
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    boolean[][] visited;
    String[] board;
    
    public int solution(String[] board) {
        this.board = board;
        r = board.length;
        c = board[0].length();
        out:
        for (int i = 0; i < r; i++) {
            String str = board[i];
            for (int j = 0; j < c; j++) {
                if (str.charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                    break out;
                }
            }
        }
        visited = new boolean[r][c];
        
        int answer = bfs();
        return answer;
    }
    
    private int bfs() {
        Queue<Robot> q = new LinkedList<>();
        q.offer(new Robot(startX, startY, 0));
        visited[startX][startY] = true;
        
        while(!q.isEmpty()) {
            Robot cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int cnt = cur.cnt;
            
            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                
                while (isIn(nx + dx[d], ny + dy[d]) && point(nx + dx[d], ny + dy[d]) != 'D') {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                if (visited[nx][ny]) continue;
                
                if (point(nx, ny) == 'G') return cnt + 1;
                
                visited[nx][ny] = true;
                q.offer(new Robot(nx, ny, cnt + 1));
            }
            
        }
        
        return -1;
    }
    
    private char point(int x, int y) {
        return board[x].charAt(y);
    }
    
    private boolean isIn(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
    
    class Robot {
        int x, y, cnt;
        Robot(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
}