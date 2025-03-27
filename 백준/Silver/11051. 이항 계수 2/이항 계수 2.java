import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        final int MOD = 10_007;

        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        int numerator = factorial[n];
        int denominator = (factorial[k] * factorial[n - k]) % MOD;

        for (int i = 1; i < MOD; i++) {
            if ((denominator * i) % MOD == 1) {
                System.out.println((numerator * i) % MOD);
                break;
            }
        }
    }
}