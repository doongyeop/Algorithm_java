import java.util.*;

class Solution {
    
    Set<Set<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        findAbuser(new HashSet<>(), 0, user_id, banned_id);
        return answer.size();
    }

    private void findAbuser (Set<String> set, int idx, String[] user_id, String[] banned_id) {
        if (idx == banned_id.length) {
            answer.add(new HashSet<>(set));
            return;
        }

        String ban = banned_id[idx];

        for (String u : user_id) {
            if (set.contains(u)) continue;
            
            if (isAbuser(u, ban)) {
                set.add(u); 
                findAbuser(set, idx + 1, user_id, banned_id);
                set.remove(u);
            }
        }
    }

    private boolean isAbuser (String user, String ban) {
        if (user.length() != ban.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
