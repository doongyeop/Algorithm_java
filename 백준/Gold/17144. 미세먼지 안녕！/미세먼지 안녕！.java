import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, cnt, room[][], roomcopy[][];
	static int circulatorIdx1, circulatorIdx2;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 시간초

		room = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1 && circulatorIdx1 == 0) {
					circulatorIdx1 = i;
				}
			}
		}
		circulatorIdx2 = circulatorIdx1 + 1;

		while (T-- > 0) {
			roomcopy = new int[R][C];
			process1();
			process2();
		} // while

		sumAll();

		System.out.println(cnt);

		br.close();
	} // main

	static void sumAll() {
		cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] != -1) {
					cnt += room[i][j];
				}
			}
		}
	}

	static void process2() {
		circulateup();
		circulatedown();
	} // process2

	static void process1() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) {
					spread(i, j);
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				room[i][j] += roomcopy[i][j];
			}
		}
	} // process1

	// 확산
	static void spread(int x, int y) {
		cnt = 0;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (0 <= nx && nx < R && 0 <= ny && ny < C && room[nx][ny] != -1) {
				roomcopy[nx][ny] += room[x][y] / 5;
				cnt++;
			}
		}
		roomcopy[x][y] -= (room[x][y] / 5) * cnt;
	}

	// 위순환
	static void circulateup() {
		// 좌변
		for (int i = circulatorIdx1 - 1; i > 0; i--) {
			room[i][0] = room[i - 1][0];
		}
		// 윗변
		for (int i = 0; i < C - 1; i++) {
			room[0][i] = room[0][i + 1];
		}
		// 우변
		for (int i = 0; i < circulatorIdx1; i++) {
			room[i][C - 1] = room[i + 1][C - 1];
		}
		// 밑변
		for (int i = C - 1; i > 1; i--) {
			room[circulatorIdx1][i] = room[circulatorIdx1][i - 1];
		}
		room[circulatorIdx1][1] = 0;
	}

	// 밑 순환
	static void circulatedown() {
		// 좌변
		for (int i = circulatorIdx2 + 1; i < R - 1; i++) {
			room[i][0] = room[i + 1][0];
		}
		// 밑변
		for (int i = 0; i < C - 1; i++) {
			room[R - 1][i] = room[R - 1][i + 1];
		}
		// 우변
		for (int i = R - 1; i > circulatorIdx2; i--) {
			room[i][C - 1] = room[i - 1][C - 1];
		}
		// 윗변
		for (int i = C - 1; i > 1; i--) {
			room[circulatorIdx2][i] = room[circulatorIdx2][i - 1];
		}
		room[circulatorIdx2][1] = 0;
	}
}
