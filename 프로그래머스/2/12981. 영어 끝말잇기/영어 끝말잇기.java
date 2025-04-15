import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> str = new HashSet<>();
        String first = words[0];
        str.add(first);
        char last = first.charAt(first.length() - 1);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (str.contains(word) || word.charAt(0) != last) {   
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            str.add(word);
            last = word.charAt(word.length() - 1);
        }

        return new int[]{0, 0};
    }
}
