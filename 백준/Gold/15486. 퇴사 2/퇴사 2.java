import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] counsel = new int[N + 1];
		int[] fee = new int[N + 1];
		int[] DP = new int[N + 1];

		for (int i = 0; i < N; i++) {
			counsel[i] = sc.nextInt();
			fee[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if (i + counsel[i] <= N) {
				DP[i + counsel[i]] = Math.max(DP[i + counsel[i]], DP[i] + fee[i]);
			}
			DP[i + 1] = Math.max(DP[i + 1], DP[i]);
		}

		System.out.println(DP[N]);

		sc.close();
	}
}