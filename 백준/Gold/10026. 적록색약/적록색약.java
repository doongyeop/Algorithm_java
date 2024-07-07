import java.util.Scanner;

public class Main {

	static int N;
	static String eye[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean visited[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		eye = new String[N][N];

		int cnt = 0;
		int cntRG = 0;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			eye[i] = str.split("");
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String curr = eye[i][j];
				if (!visited[i][j] && eye[i][j].equals(curr)) {
					cnt++;
					dfs(i, j);
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (eye[i][j].equals("G")) {
					eye[i][j] = "R";
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cntRG++;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt + " " + cntRG);

		sc.close();
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		String curr = eye[x][y];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (!visited[nx][ny] && eye[nx][ny].equals(curr))
					dfs(nx, ny);
			}

		}
	}

}