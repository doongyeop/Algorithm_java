import java.util.*;

public class Main {
    static int N, M, nums[], result[];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(nums);
        result = new int[M];
        visited = new boolean[N];
        
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int idx) {
        if (idx == M) {
            for (int r : result) sb.append(r).append(" ");
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = nums[i];
                dfs(idx + 1);
                visited[i] = false;
            }
        }

    }
}
