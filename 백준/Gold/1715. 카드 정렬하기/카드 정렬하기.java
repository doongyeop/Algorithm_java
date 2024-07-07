import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while (N-- > 0) {
			pq.offer(sc.nextInt());
		}
		int sum = 0;
		while (pq.size() != 1) {
			int a = pq.poll() + pq.poll();
			sum += a;
			pq.offer(a);
//			System.out.println(pq);
		}

		System.out.println(sum);
		sc.close();
	}
}
