import java.util.Scanner;

public class Main {

	static int R, C;
	static char[][] alp;
	static boolean[] visited = new boolean[26];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		alp = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				alp[i][j] = str.charAt(j);
			}
		}

		visited[alp[0][0] - 'A'] = true;

		System.out.println(pathFinder(0, 0));

	}

	static int pathFinder(int x, int y) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				int idx = alp[nx][ny] - 'A';

				if (!visited[idx]) {
					visited[idx] = true;
					int next = pathFinder(nx, ny);
					visited[idx] = false;
					cnt = Math.max(cnt, next);
				}
			}
		}

		return cnt + 1;
	}
}
