import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M, picture[][], cnt;
	static boolean visited[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		picture = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				picture[i][j] = sc.nextInt();
			}
		}
		cnt = 0;
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (picture[i][j] == 1 && !visited[i][j]) {
					findPicture(i, j);
					ans.add(cnt);
					cnt = 0;
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		if (ans.size() == 0) {
			System.out.println(0);
		} else {
			System.out.println(ans.get(ans.size() - 1));
		}

		sc.close();
	}

	static void findPicture(int x, int y) {
		visited[x][y] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (picture[nx][ny] == 1 && !visited[nx][ny]) {
					findPicture(nx, ny);
				}
			}

		}

	}
}