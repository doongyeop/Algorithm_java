import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        for (String r : record) {
            String[] str = r.split(" ");
            String order = str[0];
            String id = str[1];
            
            if (order.equals("Enter")) {
                String name = str[2];
                map.put(id, name);
                logs.add(new String[] {id, "Enter"});
            } else if (order.equals("Leave")) {
                logs.add(new String[] {id, "Leave"});
            } else {
                String name = str[2];
                map.put(id, name);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (String[] log : logs) {
            String id = log[0];
            String order = log[1].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
            answer.add(map.get(id) + order);                
        }
        
        return answer;
    }
}