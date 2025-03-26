import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] electronics = new int[k];
        for (int i = 0; i < k; i++) {
            electronics[i] = sc.nextInt();
        }
        sc.close();

        Set<Integer> set = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            // 지금 꽂을 기기
            int electronic = electronics[i];
            // 이미 꽂혀 있으면
            if (set.contains(electronic)) continue;
            // 빈자리가 있을 때
            if (set.size() < n) {
                set.add(electronic);
                continue;
            }

            int toUnplug = -1;
            int farthest = -1;

            for (int s : set) {
                // 꽂혀있는 기기가 다음에 사용할 순서
                int next = k;
                // 안꽂히면 k
                for (int j = i + 1; j < k; j++) {
                    if (s == electronics[j]) {
                        next = j;
                        break;
                    }
                } // for j
                /*
                2 3 2 3, 1 2 7
                set : { 2, 3 }
                2일 때 next: 5, farthest: 5, toUnplug = 2
                7일 때 next: 7, farthest: 7, toUnplug = 3
                 */
                if (next > farthest) {
                    farthest = next;
                    toUnplug = s;
                }
            } // for set
            set.remove(toUnplug);
            set.add(electronic);
            cnt++;
        } // for i

        System.out.println(cnt);
    }
}
