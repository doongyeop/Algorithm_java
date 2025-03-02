import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int r, c;
    static char[][] maze;
    static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
    static Queue<int[]> jihoon, fire;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        maze = new char[r][c];
        visited = new boolean[r][c];

        jihoon = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'J' ) {
                    jihoon.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (maze[i][j] == 'F' ) {
                    fire.add(new int[]{i, j});
                }
            }
        }

        sc.close();
        int answer = bfs();
        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
    }

    static int bfs() {
        int time = 0;

        while (!jihoon.isEmpty()) {
            time++;

            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] cur = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int x = cur[0] + dx[d];
                    int y = cur[1] + dy[d];
                    if (!isIn(x, y) || maze[x][y] == '#' || maze[x][y] == 'F' ) continue;
                    maze[x][y] = 'F';
                    fire.add(new int[]{x, y});
                }
            }

            int jihoonSize = jihoon.size();
            for (int i = 0; i < jihoonSize; i++) {
                int[] cur = jihoon.poll();
                int cx = cur[0], cy = cur[1];

                for (int d = 0; d < 4; d++) {
                    int x = cx + dx[d];
                    int y = cy + dy[d];

                    if (!isIn(x, y)) return time;

                    if (maze[x][y] == '.' && !visited[x][y]) {
                        visited[x][y] = true;
                        jihoon.add(new int[]{x, y});
                    }
                }
            }
        }

        return -1;
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}
