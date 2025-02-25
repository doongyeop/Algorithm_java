import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportedCount = new HashMap<>();
        
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            reportedCount.put(id, 0);
        }
        
        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reportee = parts[1];
            
            if (!reportMap.get(reporter).contains(reportee)) {
                reportMap.get(reporter).add(reportee);
                reportedCount.put(reportee, reportedCount.get(reportee) + 1);
            }
        }
        
        Set<String> bannedUsers = new HashSet<>();
        for (String id : id_list) {
            if (reportedCount.get(id) >= k) {
                bannedUsers.add(id);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            Set<String> reportedByUser = reportMap.get(user);
            int mailCount = 0;
            
            for (String banned : bannedUsers) {
                if (reportedByUser.contains(banned)) {
                    mailCount++;
                }
            }
            answer[i] = mailCount;
        }
        
        return answer;
    }
}
