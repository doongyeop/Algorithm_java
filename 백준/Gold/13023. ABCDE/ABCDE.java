import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M;
	static boolean visited[], isFriend;
	static List<Integer>[] adj;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		adj = new ArrayList[N];
		visited = new boolean[N];
		isFriend = false;

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			abcde(i, 1);
			if (isFriend)
				break;
		}

		System.out.println(isFriend ? 1 : 0);
		sc.close();
	}

	static void abcde(int idx, int cnt) {
		if (cnt == 5 || isFriend) {
			isFriend = true;
			return;
		}
		visited[idx] = true;

		for (int a : adj[idx]) {
			if (!visited[a])
				abcde(a, cnt + 1);
		}
		visited[idx] = false;
	}
}