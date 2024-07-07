import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N == 1) {
			System.out.println(2);
			System.exit(0);
		}
		for (int i = N;; i++) {
			if (isPrime(i) && isPalin(String.valueOf(i))) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}

	static boolean isPrime(int a) {
		if (a == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isPalin(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
