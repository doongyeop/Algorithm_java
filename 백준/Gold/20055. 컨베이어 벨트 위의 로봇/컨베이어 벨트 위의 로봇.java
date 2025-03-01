import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] conveyer = new int[2 * n];
        boolean[] robots = new boolean[n];

        for (int i = 0; i < 2 * n; i++) {
            conveyer[i] = sc.nextInt();
        }
        sc.close();

        int level = 1;

        while (true) {
            int last = conveyer[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                conveyer[i] = conveyer[i - 1];
            }
            conveyer[0] = last;

            for (int i = n - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false;
            robots[n - 1] = false;

            for (int i = n - 1; i > 0; i--) {
                if (robots[i - 1] && !robots[i] && conveyer[i] > 0) {
                    robots[i] = true;
                    robots[i - 1] = false;
                    conveyer[i]--;
                }
            }
            robots[n - 1] = false;

            if (conveyer[0] > 0) {
                robots[0] = true;
                conveyer[0]--;
            }

            int cnt = 0;
            for (int c : conveyer) {
                if (c == 0) cnt++;
            }
            if (cnt >= k) break;
            level++;
        }

        System.out.println(level);
    }
}
