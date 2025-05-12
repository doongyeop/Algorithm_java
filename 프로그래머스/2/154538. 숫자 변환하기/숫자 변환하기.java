import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        q.offer(new int[]{x, 0}); 
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int value = cur[0];
            int cnt = cur[1];
            
            if (value == y) {
                return cnt;
            }
            
            if (value + n <= y && !visited[value + n]) {
                visited[value + n] = true;
                q.offer(new int[]{value + n, cnt + 1});
            }
            
            if (value * 2 <= y && !visited[value * 2]) {
                visited[value * 2] = true;
                q.offer(new int[]{value * 2, cnt + 1});
            }
            
            if (value * 3 <= y && !visited[value * 3]) {
                visited[value * 3] = true;
                q.offer(new int[]{value * 3, cnt + 1});
            }
        }
        
        return -1;
    }
}
