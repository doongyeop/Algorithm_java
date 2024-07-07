import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		maze = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str[] = sc.next().trim().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		} // 미로 생성

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == 1 && !visited[i][j]) {
					escape(i, j);
				}
			}
		}

		visited[0][0] = true;
		escape(0, 0);
		System.out.println(maze[N - 1][M - 1]);
	}

	public static void escape(int x, int y) {
		Queue<where> queue = new LinkedList<>();

		queue.add(new where(x, y));

		while (!queue.isEmpty()) {
			where w = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = w.x + dx[i];
				int ny = w.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (visited[nx][ny] || maze[nx][ny] == 0) {
					continue;
				}
				queue.add(new where(nx, ny));
				maze[nx][ny] = maze[w.x][w.y] + 1;
				visited[nx][ny] = true;
			}
		}
	}

	static class where {
		int x, y;

		where(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}