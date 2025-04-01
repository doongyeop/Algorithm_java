import java.util.*;

public class Main {

    static int n, m;
    static char[][] map;
    static boolean[][][] visited;
    static final int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};

    static class Move {
        int x, y, dist, wall;

        Move(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        sc.close();

        System.out.println(bfs());
    }

    private static boolean isIn(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    private static int bfs() {
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Move cur = q.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!isIn(nx, ny)) continue;

                if (map[nx][ny] == '1' && cur.wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.add(new Move(nx, ny, cur.dist + 1, 1));
                } else if (map[nx][ny] == '0' && !visited[nx][ny][cur.wall]) {
                    visited[nx][ny][cur.wall] = true;
                    q.add(new Move(nx, ny, cur.dist + 1, cur.wall));
                }
            }
        }

        return -1;
    }
}
