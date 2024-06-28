import java.util.Scanner;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int n, ops[], nums[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ops = new int[4]; // + - * /
        for (int i = 0; i < 4; i++) {
            ops[i] = sc.nextInt();
        }

        operator(nums[0], 0);

        System.out.println(max + "\n" + min);
        sc.close();
    }

    static void operator(int sum, int idx) {
        if (idx == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;

                if (i == 0) {
                    operator(sum + nums[idx + 1], idx + 1);
                } else if (i == 1) {
                    operator(sum - nums[idx + 1], idx + 1);
                } else if (i == 2) {
                    operator(sum * nums[idx + 1], idx + 1);
                } else {
                    operator(sum / nums[idx + 1], idx + 1);
                }
                ops[i]++;
            }
        }

    }
}
