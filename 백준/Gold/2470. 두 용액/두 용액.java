import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] fluids = new long[n];
        for (int i = 0; i < n; i++) fluids[i] = sc.nextLong();
        sc.close();

        Arrays.sort(fluids);

        int left = 0;
        int right = n - 1;
        long minAbs = Long.MAX_VALUE;
        long[] ans = new long[2];

        while (left < right) {
            long sum = fluids[left] + fluids[right];
            long abs = Math.abs(sum);

            if (abs < minAbs) {
                minAbs = abs;
                ans[0] = fluids[left];
                ans[1] = fluids[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
