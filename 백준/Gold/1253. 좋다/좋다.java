import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        sc.close();

        Arrays.sort(nums);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            int l = 0;
            int r = n - 1;

            while (l < r) {
                if (l == i) {
                    l++;
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }
                int sum = nums[l] + nums[r];

                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

}
