import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        while (m-- > 0) {
            long temp = pq.poll() + pq.poll();
            pq.add(temp);
            pq.add(temp);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
        sc.close();
    }
}
