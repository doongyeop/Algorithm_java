import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> list = new ArrayList<>();
        int[] comb = new int[5];
        comb(1, 0, n, comb, list);
             
        int answer = 0;
        for (int[] l : list) {
            if (isValid(l, q, ans)) answer++;
        }
        
        
        return answer;
    }
    
    private void comb(int start, int idx, int n, int[] comb, List<int[]> list) {
        if (idx == 5) {
            list.add(Arrays.copyOf(comb, 5));
            return;
        }
        
        for (int i = start; i <= n - 4 + idx; i++) {
            comb[idx] = i;
            comb(i + 1, idx + 1, n, comb, list);
        }
        
    }
    
    private boolean isValid(int[] code, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>();
        for (int c : code) {
            set.add(c);
        }
        
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int num : q[i]) {
                if (set.contains(num)) cnt++;
            }
            if (cnt != ans[i]) return false;
        }
        return true;
    }
    
}