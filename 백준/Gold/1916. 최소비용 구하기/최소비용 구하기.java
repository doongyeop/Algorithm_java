import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int n, m, dist[];
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(from).add(new Node(to, cost));
        }

        int start = sc.nextInt();
        int goal = sc.nextInt();
        sc.close();

        dijkstra(start);
        System.out.println(dist[goal]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;
            int cost = cur.cost;

            if (dist[now] < cost) continue;

            for (Node next : graph.get(now)) {
                int nextCost = dist[now] + next.cost;
                if (nextCost < dist[next.v]) {
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cont) {
            this.v = v;
            this.cost = cont;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
