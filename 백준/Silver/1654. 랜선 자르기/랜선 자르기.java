import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[k];
        long right = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextLong();
            right = Math.max(right, arr[i]);
        }
        sc.close();

        long left = 1;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long temp = 0;
            for (long a : arr) temp += a / mid;

            if (temp >= n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
