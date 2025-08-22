import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] fluid = new int[n];
        for (int i = 0; i < n; i++) {
            fluid[i] = sc.nextInt();
        }
        sc.close();

        int l = 0;
        int r = n - 1;
        int ansL = fluid[l];
        int ansR = fluid[r];
        long min = Math.abs((long)ansL + ansR);

        while (l < r) {
            long sum = (long) fluid[l] + fluid[r];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansL = fluid[l];
                ansR = fluid[r];
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(ansL + " " + ansR);
    }
}
