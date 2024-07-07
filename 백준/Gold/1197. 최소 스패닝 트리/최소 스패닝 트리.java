import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}

	}

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				return e1[2] - e2[2];
			}
		});

		p = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			p[i] = i;
		}

		int ans = 0;
		int pick = 0;

		for (int i = 0; i < E; i++) {
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			if (pick == (V - 1))
				break;

		}

		System.out.println(ans);
	}

	static void union(int x, int y) {
		p[y] = x;
	}

	static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}
