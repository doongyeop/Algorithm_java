import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1); 
            }
        });

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        
        for (String a : arr) {
            answer.append(a);
        }

        return answer.toString();
    }
}
