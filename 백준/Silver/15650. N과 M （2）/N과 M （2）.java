import java.util.*;

public class Main {
    static int N, M, result[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        result = new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }

    private static void dfs(int start, int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
                result[idx] = i;
                dfs(i + 1, idx + 1);
        }
    }
}
