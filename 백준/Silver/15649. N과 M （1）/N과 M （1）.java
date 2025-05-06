import java.util.*;

public class Main {
    static int N, M, result[];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        result = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = i;
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }
}
