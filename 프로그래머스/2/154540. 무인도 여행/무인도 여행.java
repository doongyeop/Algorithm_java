import java.util.*;

class Solution {
    
    char[][] map;
    boolean[][] visited;
    int r, c;
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 'X') continue;
                answer.add(dfs(i, j));
            }
        }
        
        if (answer.isEmpty()) {
            answer.add(-1);
        };
        
        Collections.sort(answer);

        return answer;
    }
    
    private int dfs(int x, int y) {
        visited[x][y] = true;
        int sum = map[x][y] - '0';
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (!isIn(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 'X') continue;
            
            sum += dfs(nx, ny);
        }
        
        return sum;
    }
    
    private boolean isIn(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
    
}