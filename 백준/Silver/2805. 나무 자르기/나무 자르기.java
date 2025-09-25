import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] trees = new long[n];
        for (int i = 0; i < n; i++) trees[i] = sc.nextLong();
        sc.close();

        long left = 0;
        long right = 2_000_000_000;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (long tree : trees) {
                long temp = tree - mid;
                if (temp > 0) {
                    sum += temp;
                }
            }
            if (sum >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(ans);
    }
}
