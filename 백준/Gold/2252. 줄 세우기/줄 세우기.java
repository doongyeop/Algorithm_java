import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수 = 정점 수
		int M = sc.nextInt(); // 키 비교 횟수 = 간선 수

		List<Integer>[] adj = new ArrayList[N + 1];
		int[] degree = new int[N + 1]; // 진입 차수
		int[] student = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			student[i] = i;
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A].add(B);
			degree[B]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(student[curr] + " ");

			for (int a : adj[curr]) {
				degree[a]--;
				if (degree[a] == 0)
					queue.offer(a);
			}

		}

		System.out.println(sb);
	}
}