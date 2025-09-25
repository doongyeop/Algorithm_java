import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(nums[i], max);
        }
        long m = sc.nextLong();
        sc.close();

        long left = 0, right = max;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int num : nums) {
                sum += Math.min(num, mid);
            }

            if (sum <= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
