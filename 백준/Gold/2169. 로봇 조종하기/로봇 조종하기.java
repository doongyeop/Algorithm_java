import java.util.Scanner;

public class Main {

    static int N, M, mars[][], dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        mars = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mars[i][j] = sc.nextInt();
            }
        }
        sc.close();

        marsian();
        System.out.println(dp[N - 1][M - 1]);
    }

    static void marsian() {
        dp[0][0] = mars[0][0];

        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + mars[0][j];
        }

        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];

            left[0] = dp[i - 1][0] + mars[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + mars[i][j];
            }

            right[M - 1] = dp[i - 1][M - 1] + mars[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + mars[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }
    }
}
