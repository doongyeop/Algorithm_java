import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        for (int q : queue1) {
            q1.add(q);
            sum1 += q;
        }
        
        long sum2 = 0;
        for (int q : queue2) {
            q2.add(q);    
            sum2 += q;
        }
        
        if (sum1 + sum2 % 2 == 1) {
            return -1;
        }

        int cnt = 0;
        int limit = 4 * queue1.length;
        
        while (cnt <= limit) {
            if (sum1 > sum2) {
                int temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            } else if (sum1 < sum2) {
                int temp = q2.poll();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
            } else {
                return cnt;
            }
            cnt++;
        }
        return -1;
    }
}