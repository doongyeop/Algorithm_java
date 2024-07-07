import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		String bomb = sc.next();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
				sb.setLength(sb.length() - bomb.length());
			}
		}

		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
}
