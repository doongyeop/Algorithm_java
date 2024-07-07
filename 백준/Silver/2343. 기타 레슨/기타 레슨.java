import java.util.Scanner;

public class Main {

	static int N, M, arr[], left, right;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			right += arr[i];
			left = Math.max(left, arr[i]);
		}
		System.out.println(binarySearch(left, right));

		sc.close();
	}

	static int binarySearch(int left, int right) {
		while (left <= right) {
			int sum = 0;
			int mid = (left + right) / 2;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				sum += arr[i];
				if (sum > mid) {
					sum = arr[i];
					cnt++;
				}
			}
			if (cnt <= M)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}

}