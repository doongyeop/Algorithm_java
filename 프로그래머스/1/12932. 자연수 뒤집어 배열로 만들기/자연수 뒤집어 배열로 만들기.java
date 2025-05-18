import java.util.*;

class Solution {
    public int[] solution(long n) {
        String str = new StringBuilder(String.valueOf(n)).reverse().toString();
        String[] temp = str.split("");
        int[] answer = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            answer[i] = Integer.parseInt(temp[i]);
        }
        
        return answer;
    }
}
