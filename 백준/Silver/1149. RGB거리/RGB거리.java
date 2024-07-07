import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 3; i++) {
			dp[0][i] = cost[0][i];
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];
		}
		int ans = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), Math.min(dp[N - 1][2], dp[N - 1][1]));
		System.out.println(ans);
		sc.close();
	}

}