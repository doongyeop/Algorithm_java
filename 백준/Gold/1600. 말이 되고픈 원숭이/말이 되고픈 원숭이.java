import java.util.*;

public class Main {

    private static int horseX[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int horseY[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int monkeyX[] = {0, 0, 1, -1};
    private static int monkeyY[] = {1, -1, 0, 0};
    private static int map[][], K, W, H;
    private static boolean visited[][][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int horse = cur[3];

            if (x == H - 1 && y == W - 1) return cnt;
            
            // 원숭이 이동
            for (int d = 0; d < 4; d++) {
                int nx = x + monkeyX[d];
                int ny = y + monkeyY[d];

                if (isIn(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny][horse]) {
                    visited[nx][ny][horse] = true;
                    q.add(new int[]{nx, ny, cnt + 1, horse});
                }
            }

            // 말 이동
            if (horse < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = x + horseX[d];
                    int ny = y + horseY[d];

                    if (isIn(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny][horse + 1]) {
                        visited[nx][ny][horse + 1] = true;
                        q.add(new int[]{nx, ny, cnt + 1, horse + 1});
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isIn(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }
}
