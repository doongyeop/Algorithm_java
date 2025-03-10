class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean comparingInt = true;
        
        if (ineq.equals("<")) {
            if (eq.equals("=")) {
                comparingInt = (n <= m);
            } else {
                comparingInt = (n < m);
            }
        } else {
            if (eq.equals("=")) {
                comparingInt = (n >= m);
            } else {
                comparingInt = (n > m);
            }
        }
        
        return comparingInt ? 1 : 0;
    }
}