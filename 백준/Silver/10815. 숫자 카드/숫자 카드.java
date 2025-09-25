import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(sc.nextInt());

        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = sc.nextInt();
        sc.close();

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            if (set.contains(arr[i])) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb.toString());
    }
}
