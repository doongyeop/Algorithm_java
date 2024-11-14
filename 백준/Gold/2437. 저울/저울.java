import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(weights);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (weights[i] > sum + 1) break;
            sum += weights[i];
        }
        System.out.println(sum + 1);
    }
}
