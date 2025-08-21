import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String str = sc.next();
            int k = sc.nextInt();

            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (char c : map.keySet()) {
                List<Integer> list = map.get(c);
                if (list.size() < k) continue;

                for (int i = 0; i <= list.size() - k; i++) {
                    int start = list.get(i);
                    int end = list.get(i + k - 1);
                    int len = end - start + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        sc.close();
        System.out.print(sb);
    }
}
