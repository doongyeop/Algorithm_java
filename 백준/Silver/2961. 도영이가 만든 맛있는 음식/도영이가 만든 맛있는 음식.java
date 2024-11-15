import java.util.Scanner;

public class Main {
    static int n, sour[], bitter[];
    static int min = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sour = new int[n];
        bitter = new int[n];

        for (int i = 0; i < n; i++) {
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }
        sc.close();

        findMin(0, 1, 0, 0);
        System.out.println(min);
    }

    static void findMin(int idx, int sourSum, int bitterSum, int cnt) {
        if (idx == n) {
            if (cnt > 0) {
                int diff = Math.abs(sourSum - bitterSum);
                min = Math.min(min, diff);
            }
            return;
        }

        findMin(idx + 1, sourSum * sour[idx], bitterSum + bitter[idx], cnt + 1);
        findMin(idx + 1, sourSum, bitterSum, cnt);
    }
}
