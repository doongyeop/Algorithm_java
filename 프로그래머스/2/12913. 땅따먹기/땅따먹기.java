class Solution {
    int solution(int[][] land) {
        int r = land.length;
        int c = 4; 

        int[][] dp = new int[r][c];

        for (int j = 0; j < c; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int max = 0;
                for (int k = 0; k < c; k++) {
                    if (k != j) {
                        max = Math.max(max, dp[i - 1][k]);
                    }
                }
                dp[i][j] = land[i][j] + max;
            }
        }

        int answer = -1;
        for (int j = 0; j < c; j++) {
            answer = Math.max(answer, dp[r - 1][j]);
        }

        return answer;
    }
}
