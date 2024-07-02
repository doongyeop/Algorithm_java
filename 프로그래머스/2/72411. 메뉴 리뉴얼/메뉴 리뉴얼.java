import java.util.*;

// LCS 알고리즘이 아니었다 ㅠ
class Solution {
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String o : orders) {
            char[] ch = o.toCharArray();
            Arrays.sort(ch);
            
            for (int c : course) {
                if (c > ch.length) continue;
                boolean[] sel = new boolean[ch.length];
                comb(map, ch, sel, 0, ch.length, c);
            }
        }
        
        for (int c : course) {
            List<String> temp = new ArrayList<>();
            int max = 0;
            
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getKey().length() == c) {
                    if (e.getValue() >= 2) {
                        if (e.getValue() > max) {
                            temp.clear();
                            temp.add(e.getKey());
                            max = e.getValue();
                        } else if (e.getValue() == max) {
                            temp.add(e.getKey());
                        }
                    }
                }
            }
            answer.addAll(temp);
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    public void comb(Map<String, Integer> map, char[] ch, boolean[] sel, int idx, int n, int r ) {
        if (r == 0) {
            String str = "";
            for (int i = 0; i < n; i++) {
                if (sel[i]) {
                    str += ch[i];
                }
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
    
    for (int k = idx; k < n; k++) {
        sel[k] = true;
        comb(map, ch, sel, k + 1, n, r - 1);
        sel[k] = false;
    }
    }
}