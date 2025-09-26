import java.util.*;

public class Main {

    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = 1_000_000_000 / 3;
    static int N, E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        sc.close();

        int[] dist = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        int v1V2 = dist[v1] + distV1[v2] + distV2[N];
        int v2V1 = dist[v2] + distV2[v1] + distV1[N];

        int answer = Math.min(v1V2, v2V1);
        System.out.println(answer >= INF ? "-1" : answer);

    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;
            int nowCost = cur.cost;
            if (dist[now] < nowCost) continue;

            for (Node next : graph.get(now)) {
                int nextCost = dist[now] + next.cost;
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
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

}
