import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] num = new int[N][3];
		int[][] dpmin = new int[N][3];
		int[][] dpMAX = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				num[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 3; i++) {
			dpmin[0][i] = num[0][i];
			dpMAX[0][i] = num[0][i];
		}

		for (int i = 1; i < N; i++) {
			dpmin[i][0] = Math.min(dpmin[i - 1][0], dpmin[i - 1][1]) + num[i][0];
			dpmin[i][1] = Math.min(Math.min(dpmin[i - 1][0], dpmin[i - 1][1]),
					Math.min(dpmin[i - 1][1], dpmin[i - 1][2])) + num[i][1];
			dpmin[i][2] = Math.min(dpmin[i - 1][1], dpmin[i - 1][2]) + num[i][2];

			dpMAX[i][0] = Math.max(dpMAX[i - 1][0], dpMAX[i - 1][1]) + num[i][0];
			dpMAX[i][1] = Math.max(Math.max(dpMAX[i - 1][0], dpMAX[i - 1][1]),
					Math.max(dpMAX[i - 1][1], dpMAX[i - 1][2])) + num[i][1];
			dpMAX[i][2] = Math.max(dpMAX[i - 1][1], dpMAX[i - 1][2]) + num[i][2];
		}
		int min = Math.min(Math.min(dpmin[N - 1][0], dpmin[N - 1][1]), Math.min(dpmin[N - 1][1], dpmin[N - 1][2]));
		int MAX = Math.max(Math.max(dpMAX[N - 1][0], dpMAX[N - 1][1]), Math.max(dpMAX[N - 1][1], dpMAX[N - 1][2]));

		System.out.println(MAX + " " + min);
	}
}