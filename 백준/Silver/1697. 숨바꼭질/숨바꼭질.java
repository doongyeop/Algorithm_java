import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] move = { 1, -1, 2 };
	static boolean[] visited = new boolean[100001];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N);
		sc.close();
	}

	static void bfs(int start) {
		q.offer(start);
		visited[start] = true;

		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int temp = q.poll();

				if (temp == K) {
					System.out.println(cnt);
					return;
				}

				for (int j = 0; j < 3; j++) {
					int where = temp + move[j];
					if (j == 2) {
						where = temp * move[j];
					}

					if (0 <= where && where < 100001 && !visited[where]) {
						q.offer(where);
						visited[where] = true;
					}
				}
			}
			cnt++;
		}
	}
}
