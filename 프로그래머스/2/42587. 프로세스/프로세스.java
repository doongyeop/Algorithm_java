import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int p : priorities) {
            pq.add(p);
        }
        
        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    
                    if (location == i) return answer;
                }
            }
        }
        
        return answer;
    }
}

