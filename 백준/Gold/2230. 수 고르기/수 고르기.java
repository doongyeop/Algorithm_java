import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sc.close();

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;

        while (r < n) {
            int gap = arr[r] - arr[l];

            if (gap >= m) {
                ans = Math.min(ans, gap);
                l++;
                if (l > r) r = l;
            } else {
                r++;
            }
        }

        System.out.println(ans);
    }
}
