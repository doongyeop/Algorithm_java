class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int hope = calc(schedules[i]) + 10; 
            
            boolean notLate = true;
            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7 + 1; 
                
                if (day >= 6) continue; 
                
                if (calc(timelogs[i][j]) > hope) {
                    notLate = false;
                    break;
                }
            }
            
            if (notLate) answer++;
        }
        
        return answer;
    }
    
    private int calc(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}
