import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        
        Arrays.sort(plans, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        
        List<String> answer = new ArrayList<>();
        Stack<String[]> stop = new Stack<>();
        int now = 0;
        
        for (int i = 0; i < plans.length - 1; i++) {
            String[] before = plans[i][1].split(":");
            String[] after = plans[i + 1][1].split(":");
            
            int beforeStart = Integer.parseInt(before[0]) * 60 + Integer.parseInt(before[1]);
            int afterStart = Integer.parseInt(after[0]) * 60 + Integer.parseInt(after[1]);
            int time = Integer.parseInt(plans[i][2]);
            int end = beforeStart + time;
            
            if (end <= afterStart) {
                answer.add(plans[i][0]);
                now = end;
                
                while (!stop.isEmpty() && now < afterStart) {
                    String[] resume = stop.pop();
                    int temp = afterStart - now;
                    if (Integer.parseInt(resume[2]) <= temp) {
                        answer.add(resume[0]);
                        now += Integer.parseInt(resume[2]);
                    } else {
                        resume[2] = String.valueOf(Integer.parseInt(resume[2]) - temp);
                        stop.push(resume);
                        now = afterStart;
                    }
                }
            } else {
                plans[i][2] = String.valueOf(end - afterStart);
                stop.push(plans[i]);
                now = afterStart;
            }        
        } // for
        
        String[] last = plans[plans.length - 1];
        answer.add(last[0]);
        int end = Integer.parseInt(last[1].split(":")[0]) * 60 + Integer.parseInt(last[1].split(":")[1]) + Integer.parseInt(last[2]);
        
        while (!stop.isEmpty()) {
            String[] resume = stop.pop();
            answer.add(resume[0]);
        }
        
        return answer;
    }
}