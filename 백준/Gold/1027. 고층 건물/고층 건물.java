import java.util.Scanner;

class Main { 
    static int building[], n, answer;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = 0;
        building = new int[n];
        for (int i = 0; i < n; i++) building[i] = sc.nextInt();
        sc.close();

        for (int i = 0; i < n; i++) visible(i);

        System.out.println(answer);
    }

    static void visible(int idx) {
        int cnt = 0;
        double leftBefore = Integer.MAX_VALUE;
        double rightBefore = Integer.MIN_VALUE;

        // 왼쪽: 기울기 감소
        for (int i = idx - 1; i >= 0; i--) {
            double incline = (double) (building[idx] - building[i]) / (idx - i);
            if (incline < leftBefore) {
                cnt++;
                leftBefore = incline;
            }
        }

        // 오른쪽: 기울기 증가
        for (int i = idx + 1; i < n; i++) {
            double incline = (double) (building[idx] - building[i]) / (idx - i);
            if (incline > rightBefore) {
                cnt++;
                rightBefore = incline;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
