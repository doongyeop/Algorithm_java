import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] kids = new int[n];
        for (int i = 0; i < n; i++) kids[i] = sc.nextInt();
        sc.close();

        if (k == n) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            pq.add(kids[i + 1] - kids[i]);
        }

        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += pq.poll();
        }

        System.out.println(answer);

    }
}
