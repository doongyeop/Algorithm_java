import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int w, h;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<int[]> fire;
	static Queue<int[]> pos;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();

		while (t-- > 0) {
			w = sc.nextInt();
			h = sc.nextInt();

			map = new char[h][w];
			visited = new boolean[h][w];
			fire = new ArrayDeque<>();
			pos = new ArrayDeque<>();

			for (int i = 0; i < h; i++) {
				String str = sc.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*')
						fire.offer(new int[] { i, j });
					else if (map[i][j] == '@')
						pos.offer(new int[] { i, j, 0 });
				}
			}

			int ans = escape();
			sb.append(ans == -1 ? "IMPOSSIBLE" : ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

	static int escape() {
		while (!pos.isEmpty()) {
			int sizeF = fire.size();
			for (int i = 0; i < sizeF; i++) {
				int[] p = fire.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p[0] + dx[j];
					int ny = p[1] + dy[j];
					if (isValid(nx, ny) && map[nx][ny] != '#' && map[nx][ny] != '*') {
						map[nx][ny] = '*';
						fire.offer(new int[] { nx, ny });
					}
				}
			}

			int sizeP = pos.size();
			for (int i = 0; i < sizeP; i++) {
				int[] g = pos.poll();
				for (int j = 0; j < 4; j++) {
					int nx = g[0] + dx[j];
					int ny = g[1] + dy[j];
					if (!isValid(nx, ny)) {
						return g[2] + 1;
					}
					if (map[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = '@';
						pos.offer(new int[] { nx, ny, g[2] + 1 });
					}
				}
			}
		}
		return -1;
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}
}
