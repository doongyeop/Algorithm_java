class Solution {
    public int solution(String[][] book_time) {
        
        int[] using = new int[1450];
        
        for (String[] b : book_time) {
            int inTime = Integer.parseInt(b[0].substring(0, 2)) * 60 + Integer.parseInt(b[0].substring(3, 5));
            int outTime = Integer.parseInt(b[1].substring(0, 2)) * 60 + Integer.parseInt(b[1].substring(3, 5));
            
            using[inTime] += 1;
            using[outTime + 10] -= 1;
        }
        
        int answer = 0;
        for (int i = 1; i < 1450; i++) {
            using[i] += using[i - 1];
            answer = Math.max(using[i], answer);
        }
        
        return answer;
    }
}