import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        int[] arr = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            arr[i] = elements[i % n];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += arr[j + k];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
