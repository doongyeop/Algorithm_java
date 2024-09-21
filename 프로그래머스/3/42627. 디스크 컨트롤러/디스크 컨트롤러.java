import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int now = 0;
        int end = 0;
        int idx = 0;
        int fin = 0;
        
        while (fin < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= now) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] temp = pq.poll();
                now += temp[1];
                end += now - temp[0];
                fin++;
            } else {
                now = jobs[idx][0];
            }
            
        }
        
        return end / jobs.length;
    }
}