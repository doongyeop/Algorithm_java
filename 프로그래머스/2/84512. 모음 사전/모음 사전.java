import java.util.*;

class Solution {
    
    TreeSet<String> set;
    private final String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        set = new TreeSet<>();
        fillSet("", 0);
        List<String> list = new ArrayList<>(set);
        
        return list.indexOf(word); 
    }
    
    private void fillSet(String cur, int idx) {
        if (idx > 5) return; 
        
        if (!cur.equals(null)) {
            set.add(cur);
        }
        
        for (String v : vowels) {
            fillSet(cur + v, idx + 1);
        }
    }
}
