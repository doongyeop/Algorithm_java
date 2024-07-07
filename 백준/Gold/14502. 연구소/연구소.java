import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, max, lab[][], copiedlab[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<virus> queue = new LinkedList<virus>();

	static class virus {
		int x, y;

		public virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		max = Integer.MIN_VALUE;

		lab = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lab[i][j] = sc.nextInt();
			}
		}

		makeWall(0);
		System.out.println(max);

		sc.close();
	}

	static void makeWall(int cnt) {
		if (cnt == 3) {
			spread();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					makeWall(cnt + 1);
					lab[i][j] = 0;
				}
			}
		}

	} // make wall

	static void spread() {

		copiedlab = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copiedlab[i][j] = lab[i][j];
			}
		} // 배열 복사

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copiedlab[i][j] == 2) {
					queue.add(new virus(i, j));
				}
			}
		} // 바이러스 찾기

		while (!queue.isEmpty()) {
			virus v = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M && copiedlab[nx][ny] == 0) {
					copiedlab[nx][ny] = 2;
					queue.add(new virus(nx, ny));
				}

			}
		} // queue while

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copiedlab[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(cnt, max);
	} // spread

}