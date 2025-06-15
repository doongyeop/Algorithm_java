import java.util.*;

public class Main {

    static int r, c;
    static char[][] cave;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        cave = new char[r][c];
        for (int i = 0; i < r; i++) {
            cave[i] = sc.next().toCharArray();
        }
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = r - sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            throwStick(heights[i], i % 2 == 0);
            fall();
        }

        StringBuilder sb = new StringBuilder();
        for (char[] c : cave) {
            sb.append(c).append("\n");
        }
        System.out.println(sb);
    }

    static void throwStick(int h, boolean isLeft) {
        if (isLeft) {
            for (int j = 0; j < c; j++) {
                if (cave[h][j] == 'x') {
                    cave[h][j] = '.';
                    break;
                }
            }
        } else {
            for (int j = c - 1; j >= 0; j--) {
                if (cave[h][j] == 'x') {
                    cave[h][j] = '.';
                    break;
                }
            }
        }
    }

    static void fall() {
        visited = new boolean[r][c];

        for (int j = 0; j < c; j++) {
            if (cave[r - 1][j] == 'x' && !visited[r - 1][j]) {
                bfs(r - 1, j);
            }
        }

        List<int[]> clusters = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cave[i][j] == 'x' && !visited[i][j]) {
                    clusters.add(new int[]{i, j});
                }
            }
        }

        if (clusters.isEmpty()) return;

        for (int[] c : clusters) {
            cave[c[0]][c[1]] = '.';
        }

        int min = r;
        for (int[] c : clusters) {
            int x = c[0], y = c[1], fall = 0;
            while (true) {
                if (x + fall + 1 >= r || (cave[x + fall + 1][y] == 'x' && visited[x + fall + 1][y])) break;
                fall++;
            }
            min = Math.min(min, fall);
        }

        for (int[] c : clusters) {
            cave[c[0] + min][c[1]] = 'x';
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (!isIn(nx, ny) || visited[nx][ny]) continue;
                if (cave[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }

}
