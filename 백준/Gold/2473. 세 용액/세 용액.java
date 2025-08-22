import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fluid = new int[n];
        for (int i = 0; i < n; i++) fluid[i] = sc.nextInt();
        sc.close();

        Arrays.sort(fluid);
        long sum = Long.MAX_VALUE;
        int ansL = 0;
        int ansM = 0;
        int ansR = 0;

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long temp = (long) fluid[i] + fluid[l] + fluid[r];

                if (Math.abs(temp) < sum) {
                    sum = Math.abs(temp);
                    ansL = fluid[i];
                    ansM = fluid[l];
                    ansR = fluid[r];
                }

                if (temp > 0) {
                    r--;
                } else {
                    l++;
                }
            } // while
        } // for

        System.out.println(ansL + " " + ansM + " " + ansR);

    }
}
