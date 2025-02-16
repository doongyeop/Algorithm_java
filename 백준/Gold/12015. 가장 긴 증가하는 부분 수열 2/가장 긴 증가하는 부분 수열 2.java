import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
         (1 <= N <= 1,000,000)
         dp : N^2 = 1,000,000,000,000 이므로 X
         */
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            int idx = Collections.binarySearch(list, a);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx == list.size()) {
                list.add(a);
            } else {
                list.set(idx, a);
            }
//            System.out.println(list);
        }
        System.out.println(list.size());
    }
}
