import java.util.Scanner;

public class Main {

    static int weights[], n, k, cnt = 0;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[n];
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        sc.close();

        underArmor(0, 500);
        System.out.println(cnt);
    }

    static void underArmor(int day, int weight) {
        if (day == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (weight + weights[i] - k < 500) continue;

            visited[i] = true;
            underArmor(day + 1, weight + weights[i] - k);
            visited[i] = false;
        }
    }
}
