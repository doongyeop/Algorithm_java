import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    static int bfs(int N, int K) {
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int x = dq.poll();
            if (x == K) return dist[x];

            if (2 * x <= MAX && dist[2 * x] == -1) {
                dist[2 * x] = dist[x];
                dq.addFirst(2 * x);
            }

            if (x - 1 >= 0 && dist[x - 1] == -1) {
                dist[x - 1] = dist[x] + 1;
                dq.addLast(x - 1);
            }

            if (x + 1 <= MAX && dist[x + 1] == -1) {
                dist[x + 1] = dist[x] + 1;
                dq.addLast(x + 1);
            }
        }
        return -1;
    }
}