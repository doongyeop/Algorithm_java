import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        Set<Integer> temp = new HashSet<>();
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                temp.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> answer = new ArrayList<>(temp);
        Collections.sort(answer);
        
        return answer;
    }
}