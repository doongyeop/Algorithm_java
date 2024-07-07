import java.util.*;

class Solution {
    
    boolean[] visited;
    List<String> list;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        list = new ArrayList<String>();
        String travel = "ICN ";
        
        dfs(tickets, "ICN", travel, 0);
        Collections.sort(list);
        
        
        return list.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String start, String travel, int cnt) {
        if (cnt == tickets.length) {
            list.add(travel);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], travel + tickets[i][1] + " ", cnt + 1);
                visited[i] = false;
            }
        }
        
    }
    
}