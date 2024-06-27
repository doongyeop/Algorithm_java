class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        
        int result = 0;
        result += dfs(numbers, target, idx + 1, sum + numbers[idx]);
        result += dfs(numbers, target, idx + 1, sum - numbers[idx]);
        return result;
    }
    
    
}