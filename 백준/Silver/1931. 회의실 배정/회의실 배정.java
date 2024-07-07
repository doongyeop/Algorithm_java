import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] confRoom = new int[N][2];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			confRoom[i][0] = sc.nextInt(); // 시작 시간
			confRoom[i][1] = sc.nextInt(); // 종료 시간
		}

		Arrays.sort(confRoom, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int end = -1;
		for (int i = 0; i < N; i++) {
			if (confRoom[i][0] >= end) {
				end = confRoom[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);
		sc.close();
	}
}
