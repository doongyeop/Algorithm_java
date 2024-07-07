import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = sc.nextInt(); // 지원자 수

			List<int[]> applicants = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				applicants.add(new int[] { a, b });
			}

			Collections.sort(applicants, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});

			int cnt = 0;
			int min = Integer.MAX_VALUE;
			for (int[] a : applicants) {
				if (a[1] < min) {
					min = a[1];
					cnt++; 
				}
			}

			sb.append(cnt + "\n");
		}

		System.out.println(sb);
		sc.close();
	}
}
