import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m, cheese[][];
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cheese = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cheese[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int time = 0;
        while (true) {
            checkOuter();
            if (!meltCheese()) break;
            time++;
        }

        System.out.println(time);
    }

    static void checkOuter() {
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        cheese[0][0] = 2;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isIn(nx, ny)) continue;
                if (visited[nx][ny]) continue;

                if (cheese[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                cheese[nx][ny] = 2;
                q.add(new int[]{nx, ny});
            }
        }
    }

    private static boolean meltCheese() {
        boolean melted = false;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheese[i][j] == 1 && checkMelt(i, j)) {
                    q.add(new int[]{i, j});
                    melted = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cheese[cur[0]][cur[1]] = 2;
        }

        return melted;
    }

    private static boolean checkMelt(int x, int y) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (isIn(nx, ny) && cheese[nx][ny] == 2) count++;
        }
        return count >= 2;
    }

    private static boolean isIn(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
