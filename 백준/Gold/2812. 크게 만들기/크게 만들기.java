import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			char curr = str.charAt(i);
			while (!stack.isEmpty() && k > 0 && stack.peek() < curr) {
				stack.pop();
				k--;
			}
			stack.push(curr);
		}
		while (k-- > 0) {
			stack.pop();
		}

		StringBuilder sb = new StringBuilder();
		for (char s : stack) {
			sb.append(s);
		}

		System.out.println(sb);
		sc.close();

	}

}
