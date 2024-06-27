import java.util.Scanner;

public class Main {

    static int chess[], n;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        chess = new int[n];

        nQueen(0);
        System.out.println(cnt);
        
        sc.close();
    }

    public static void nQueen(int idx) {
        if (idx == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[idx] = i;
            if (isAble(idx)) {
                nQueen(idx + 1);
            }
        }

    }

    public static boolean isAble(int idx) {
        for (int i = 0; i < idx; i++) {
            // 열 조건
            if (chess[idx] == chess[i]) {
                return false;
                // 대각선 조건
            } else if (Math.abs(idx - i) == Math.abs(chess[idx] - chess[i])) {
                return false;
            }
        }
        return true;
    }
}
