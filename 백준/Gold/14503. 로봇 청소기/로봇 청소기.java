import java.util.Scanner;

public class Main {

	static int N, M, starta, startb, cnt, room[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		starta = sc.nextInt();
		startb = sc.nextInt();
		int d = sc.nextInt(); // 0 북, 1 동, 2 남, 3 서
		room = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				room[i][j] = sc.nextInt();
			}
		}

		cnt = 1;
		robot(starta, startb, d);
		System.out.println(cnt);

		sc.close();
	}

	// 1 벽 0 청소 X
	static void robot(int x, int y, int direction) {
		room[x][y] = -1; // (청소 끝)

		// 0 북, 1 동, 2 남, 3 서
		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (room[nx][ny] == 0) {
					cnt++;
					robot(nx, ny, direction);
					return;
				}

			}
		}

		// 후진
		int back = (direction + 2) % 4;
		int gx = x + dx[back];
		int gy = y + dy[back];
		if (0 <= gx && gx < N && 0 <= gy && gy <= M && room[gx][gy] < 1) {
			robot(gx, gy, direction);
		}

	}

}