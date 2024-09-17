import java.util.Scanner;

public class Main {

    static int N, min, stats[][];
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        min = 987654321;
        visited = new boolean[N];
        stats = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stats[i][j] = sc.nextInt();
            }
        }
        simulate(0, 0);

        System.out.println(min);
        sc.close();
    }

    static void simulate(int idx, int cnt) {
        if (cnt == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                simulate(i + 1, cnt + 1);
                visited[i] = false;
            }
        }

    }

    static void calculateDiff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += stats[i][j];
                } else if (!visited[i] && !visited[j]) {
                    link += stats[i][j];
                }
            }
        }

        int diff = Math.abs(start - link);
        min = Math.min(diff, min);
    }

}
