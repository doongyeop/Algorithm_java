import java.util.*;

public class Main {

    static int M, N, H; // 가로, 세로, 높이
    static int[][][] box;
    static int[][] move = {{1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static Queue<int[]> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];
        q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        q.add(new int[]{h, n, m});
                    }
                }
            }
        }

        int result = bfs();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
        sc.close();
    }

    static int bfs() {
        int days = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int h = current[0];
                int n = current[1];
                int m = current[2];

                for (int[] d : move) {
                    int nh = h + d[0];
                    int nn = n + d[1];
                    int nm = m + d[2];

                    if (isIn(nh, nn, nm) && box[nh][nn][nm] == 0) {
                        box[nh][nn][nm] = 1;
                        q.add(new int[]{nh, nn, nm});
                    }
                }
            }
        }

        return days;
    }

    static boolean isIn(int x, int y, int z) {
        return 0 <= x && x < H && 0 <= y && y < N && 0 <= z && z < M;
    }
}
