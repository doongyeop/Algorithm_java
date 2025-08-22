import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] highway = new int[n + 2];
        highway[n + 1] = l;
        for (int i = 1; i <= n; i++) highway[i] = sc.nextInt();
        sc.close();
        Arrays.sort(highway);

        int left = 1;
        int right = l;
        int ans = 0;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (canBuild(highway, mid, m)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean canBuild(int[] arr, int max, int m) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            int dist = arr[i] - arr[i - 1];
            if (dist > max) cnt += (dist - 1) / max;
        }

        return cnt <= m;
    }

}
