import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int time = sc.nextInt();
            graph.get(from).add(new Node(to, time));
        }

        int[][] dists = new int[N + 1][N + 1];
        for (int i = 1; i <= N ; i++) dists[i] = dijkstra(i);
        int[] back = dijkstra(X);

        int answer = -1;
        for (int i = 1; i <= N; i++) {
            int cost = back[i] + dists[i][X];
            answer = Math.max(answer, cost);
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;
            int time = cur.time;

            if (dist[now] < time) continue;

            for (Node next : graph.get(now)) {
                int nextCost = next.time + dist[now];
                if (dist[next.v] > nextCost) {
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
        return dist;
    }


    static class Node implements Comparable<Node> {
        int v;
        int time;

        public Node(int v, int time) {
            this.v = v;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

}
