import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] homes = new int[n];
        for (int i = 0; i < n; i++) homes[i] = sc.nextInt();
        sc.close();
        Arrays.sort(homes);

        int l = 1;
        int r = homes[n - 1] - homes[0];
        int ans = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            if (canInstall(homes, c, m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }

        }

        System.out.println(ans);

    }

    static boolean canInstall(int[] arr, int c, int dist) {
        int cnt = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                cnt++;
                last = arr[i];
            }
        }

        return cnt >= c;
    }

}
