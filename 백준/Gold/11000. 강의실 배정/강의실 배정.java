import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] meet = new int[N][2];

        for (int i = 0; i < N; i++) {
            meet[i][0] = sc.nextInt();
            meet[i][1] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(meet, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meet[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= meet[i][0]) {
                pq.poll();
            }
            pq.add(meet[i][1]);
        }

        System.out.println(pq.size());
    }
}
