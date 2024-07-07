import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}

		dp[0][0] = triangle[0][0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int d : dp[n - 1]) {
			max = Math.max(max, d);
		}

		System.out.println(max);
	}
}
