import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] x = new long[n];
        long[] y = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        System.out.printf("%.1f", calculate(x, y, n));
        sc.close();
    }

    private static double calculate(long[] x, long[] y, int n) {
        long area = 0;

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += (x[i] * y[j]) - (y[i] * x[j]);
        }
        return Math.abs(area) / 2.0;
    }
}
