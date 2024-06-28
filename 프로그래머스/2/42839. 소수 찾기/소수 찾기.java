import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        visited = new boolean[nums.length];
        
        makePrime(nums, "");
        
        return set.size();
    }
    
    public void makePrime(char[] nums, String str) {
        if (!str.equals("")) {
            int temp = Integer.parseInt(str);
            if (isPrime(temp)) set.add(temp);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makePrime(nums, str + nums[i]);
                visited[i] = false;
            }
        }
        
        
    }
    
    public boolean isPrime(int a) {
        if (a <= 1) return false;
        if (a == 2) return true;
        
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        
        return true;
    }
    
}