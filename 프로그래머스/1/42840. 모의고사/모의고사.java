import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        
        int[] giveUp1 = {1, 2, 3, 4, 5}; // 5
        int[] giveUp2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] giveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        int Cnt1 = 0, Cnt2 = 0, Cnt3 = 0;
        
        for (int i = 0 ; i < answers.length ; i++) {
            if (answers[i] == giveUp1[i % 5]) Cnt1++;
            if (answers[i] == giveUp2[i % 8]) Cnt2++;
            if (answers[i] == giveUp3[i % 10]) Cnt3++;                
        }
        
        int max = Math.max(Cnt1, Math.max(Cnt2, Cnt3));
        List<Integer> answer = new ArrayList<>();
        
        if (Cnt1 == max) answer.add(1);
        if (Cnt2 == max) answer.add(2);
        if (Cnt3 == max) answer.add(3);
        
        return answer;
    }
}