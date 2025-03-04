import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0; 
        int n = order.length;

        for (int i = 1; i <= n; i++) { 
            if (order[idx] == i) { 
                answer++;
                idx++;
            } else {
                stack.push(i);
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}
