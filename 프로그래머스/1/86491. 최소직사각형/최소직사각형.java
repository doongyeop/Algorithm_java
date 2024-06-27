class Solution {
    public int solution(int[][] sizes) {
        
        int widthMax = Integer.MIN_VALUE;
        int heightMax = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < sizes.length ; i++) {
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            
            widthMax = Math.max(widthMax, a);
            heightMax = Math.max(heightMax, b);
        }
        
        int answer = widthMax * heightMax;
        return answer;
    }
}