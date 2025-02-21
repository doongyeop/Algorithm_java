import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int now = toDate(today);
        Map<String, Integer> termMap = new HashMap<>();
        
        // 약관 정보를 Map에 저장
        for (String t : terms) {
            String[] parts = t.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int infoDate = toDate(privacy[0]);
            int expirationDate = infoDate + termMap.get(privacy[1]) * 28;
            
            if (expirationDate <= now) {
                answer.add(i + 1);
            }
        }
        
        return answer;
    }
    
    private int toDate(String str) {
        String[] dateParts = str.split("\\."); 
        return Integer.parseInt(dateParts[0]) * 12 * 28 
             + (Integer.parseInt(dateParts[1]) - 1) * 28 
             + Integer.parseInt(dateParts[2]);
    }
}
