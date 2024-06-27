import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char curr = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() < curr) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while (k-- > 0) {
            stack.pop();
        }
        
        for (char s : stack) {
            answer += s;
        }
        
        
        return answer;
    }
}