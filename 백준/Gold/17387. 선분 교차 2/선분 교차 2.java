import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();

        long x3 = sc.nextLong();
        long y3 = sc.nextLong();
        long x4 = sc.nextLong();
        long y4 = sc.nextLong();

        System.out.println(isCross(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
        sc.close();
    }

    public static int crossProduct(long x1, long y1, long x2, long y2, long x3, long y3) {
        long value = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (value > 0) { // 값이 양수면 반시계
            return 1;
        } else if (value < 0) { // 값이 음수면 시계
            return -1;
        }
        return 0; // 평행
    }

    public static boolean isCross(long x1, long y1, long x2, long y2,
                                  long x3, long y3, long x4, long y4) {
        int ab = crossProduct(x1, y1, x2, y2, x3, y3) * crossProduct(x1, y1, x2, y2, x4, y4);
        int cd = crossProduct(x3, y3, x4, y4, x1, y1) * crossProduct(x3, y3, x4, y4, x2, y2);

        if (ab == 0 && cd == 0) {
            if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                    && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
                return true;
            } else {
                return false;
            }
        }
        return ab <= 0 && cd <= 0;
    }
}
