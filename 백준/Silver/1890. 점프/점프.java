import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 크기
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		if (isIn(map[0][0])) {
			dp[0][map[0][0]]++;
			dp[map[0][0]][0]++;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j && j == N - 1)
					break;
				if (isIn(i + map[i][j])) {
					dp[i + map[i][j]][j] += dp[i][j];
				}
				if (isIn(j + map[i][j])) {
					dp[i][j + map[i][j]] += dp[i][j];
				}

			}
		}

		System.out.println(dp[N - 1][N - 1]);

		sc.close();
	}

	static boolean isIn(int a) {
		return 0 <= a && a < N;
	}
}