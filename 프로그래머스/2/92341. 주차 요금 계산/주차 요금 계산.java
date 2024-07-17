import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int baseTime = fees[0]; // 기본시간
        int baseFee = fees[1]; // 기본 요금
        int perTime = fees[2]; // 단위 시간
        int perFee = fees[3]; // 단위 요금
                
        Map<String, Integer> car = new HashMap<>();
        Map<String, Integer> parked = new TreeMap<>();    
        
        for (String r : records) {
            String[] str = r.split(" ");
            String time = str[0];
            String carNumber = str[1];
            String status = str[2];
            
            int minutes = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
            
            if (status.equals("IN")) {
                car.put(carNumber, minutes);
            } else {
                int enter = car.remove(carNumber);
                int duration = minutes - enter;
                      
                parked.put(carNumber, parked.getOrDefault(carNumber, 0) + duration);    
            }
        }
        
        for (Map.Entry<String, Integer> c : car.entrySet()) {
            int duration = 1439 - c.getValue();
            String carNumber = c.getKey();
            
            parked.put(carNumber, parked.getOrDefault(carNumber, 0) + duration); 
        }
        
        for (Map.Entry<String, Integer> p : parked.entrySet()) {
            int fee = 0;
            int duration = p.getValue();
            
            if (duration <= baseTime) {
                fee = baseFee;
            } else {
                fee = baseFee + (int) Math.ceil((double) (duration - baseTime) / perTime) * perFee;
            }
            
            answer.add(fee);
        }
        
        return answer;
    }
    
    public int calculate(int baseTime, int baseFee, int perTime, int perFee, int duration) {
        if (duration <= baseTime) {
            return baseFee;
        }
        return baseFee + (int) Math.ceil((double) (duration - baseTime) / perTime) * perFee;
    }
    
}

