import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> vill = new ArrayList<>();
        long pop = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            vill.add(new int[]{x, a});
            pop += a;
        }
        sc.close();

        vill.sort(Comparator.comparingInt(o -> o[0]));

        long mid = 0;
        for (int[] village : vill) {
            mid += village[1];
            if (mid >= (pop + 1) / 2) {
                System.out.println(village[0]);
                break;
            }
        }
    }
}
