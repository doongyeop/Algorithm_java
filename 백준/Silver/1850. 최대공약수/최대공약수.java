import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		long A = sc.nextLong();
		long B = sc.nextLong();
		long temp = gcd(A, B);

		while (temp-- > 0) {
			sb.append("1");
		}
		System.out.println(sb);
		sc.close();
	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
