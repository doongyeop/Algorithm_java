import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        String[] add = {"1", "7", "4", "2", "0", "8"};
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                if (dp[i - j] == Long.MAX_VALUE) continue;
                String str = String.valueOf(dp[i - j]) + add[j - 2];
                long num = Long.parseLong(str);
                dp[i] = Math.min(dp[i], num);
            }
        }

        while (t-- > 0) {
            int n = sc.nextInt();

            String smallest = String.valueOf(dp[n]);
            StringBuilder biggest = new StringBuilder();
            if (n % 2 == 1) {
                biggest.append("7");
                n -= 3;
            }
            while (n > 0) {
                biggest.append("1");
                n -= 2;
            }

            sb.append(smallest).append(" ").append(biggest).append("\n");
        }
        sc.close();
        System.out.println(sb);
    }
}
