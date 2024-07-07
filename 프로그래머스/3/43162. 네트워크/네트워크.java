import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) continue;
            
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            visited[i] = true;
            
            while(!q.isEmpty()) {
                int curr = q.poll();
                for (int j = 0; j < computers.length; j++) {
                    if (curr == j || computers[curr][j] == 0 || visited[j]) continue;
                    q.add(j);
                    visited[j] = true;
                }
            }
            answer++;
        }
     
        return answer;
    }
}