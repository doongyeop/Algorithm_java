class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            StringBuilder one = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    one.append("1");
                } else {
                    answer[1]++;
                }
            }
            s = Integer.toBinaryString(one.length());
            answer[0]++;
        }
        
        return answer;
    }
}