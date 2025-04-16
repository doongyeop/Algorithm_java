import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] school = new int[n][m];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                school[i][j] = sc.nextInt();
            }
            Arrays.sort(school[i]);
        }
        sc.close();
        int minDiff = Integer.MAX_VALUE;
        while (true) {
            int tempMin = school[0][index[0]], tempMax = school[0][index[0]];
            int minIdx = 0;

            for (int i = 1; i < n; i++) {
                if (tempMin > school[i][index[i]]) {
                    tempMin = school[i][index[i]];
                    minIdx = i;
                }
                if (tempMax < school[i][index[i]]) {
                    tempMax = school[i][index[i]];
                }
            }
            if ((tempMax - tempMin) < minDiff) minDiff = tempMax - tempMin;

            if (++index[minIdx] == m) break;
        }

        System.out.println(minDiff);
    }
}
