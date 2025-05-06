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

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int idx) {
        if (idx == M) {
            for (int r : result) sb.append(r).append(" ");
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            result[idx] = i;
            dfs(idx + 1);
        }

    }
}
