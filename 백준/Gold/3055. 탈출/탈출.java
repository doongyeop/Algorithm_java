import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int R, C, ans;
	static char[][] map;
	static Queue<where> water, sonic;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class where {
		int x, y, time;

		public where(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		water = new LinkedList<>();
		sonic = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					sonic.add(new where(i, j, 0));
				} else if (map[i][j] == '*') {
					water.add(new where(i, j, 0));
				}
			}
		}

		ans = saveSonic();
		System.out.println(ans == -1 ? "KAKTUS" : ans);

		sc.close();
	}

	static int saveSonic() {
		while (!sonic.isEmpty()) {
			int waterIdx = water.size();
			for (int i = 0; i < waterIdx; i++) {
				where w = water.poll();
				for (int j = 0; j < 4; j++) {
					int nx = w.x + dx[j];
					int ny = w.y + dy[j];
					if (0 <= nx && nx < R && 0 <= ny && ny < C && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						map[nx][ny] = '*';
						water.add(new where(nx, ny, 0));
					}
				}
			}

			int sonicIdx = sonic.size();
			for (int i = 0; i < sonicIdx; i++) {

				where s = sonic.poll();
				for (int j = 0; j < 4; j++) {
					int nx = s.x + dx[j];
					int ny = s.y + dy[j];

					if (0 <= nx && nx < R && 0 <= ny && ny < C) {
						if (map[nx][ny] == 'D') {
							return s.time + 1;
						} else if (map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							sonic.add(new where(nx, ny, s.time + 1));
						}
					}
				}
			}
		}
		return -1;
	}
}
