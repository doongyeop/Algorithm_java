import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		String[] sep = str.split("-");

		int result = calc(sep[0]);
		for (int i = 1; i < sep.length; i++) {
			result -= calc(sep[i]);
		}

		System.out.println(result);
		sc.close();
	}

	private static int calc(String str) {
		String[] temp = str.split("\\+");
		int sum = 0;
		for (String t : temp) {
			sum += Integer.parseInt(t);
		}
		return sum;
	}
}
