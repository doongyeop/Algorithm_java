class Solution {
    public int solution(String[][] book_time) {
        
        int[] using = new int[1450];
        
        for (String[] b : book_time) {
            String in = b[0];
            String out = b[1];
            
            int inTime = Integer.parseInt(in.split(":")[0]) * 60 + Integer.parseInt(in.split(":")[1]);
            int outTime = Integer.parseInt(out.split(":")[0]) * 60 + Integer.parseInt(out.split(":")[1]);
            
            for (int i = inTime; i < outTime + 10; i++) {
                using[i]++;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < using.length; i++) {
            answer = Math.max(answer, using[i]);
        }
        
        return answer;
    }
}