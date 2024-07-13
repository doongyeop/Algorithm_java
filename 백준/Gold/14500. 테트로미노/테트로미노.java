import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, paper[][], max;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 1, paper[i][j]);
                ohOoh(i, j);
            }
        }

        System.out.println(max);
        br.close();
    }

    static void dfs(int x, int y, int idx, int sum) {
        if (idx == 4) {
            max = Math.max(max, sum);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                dfs(nx, ny, idx + 1, sum + paper[nx][ny]);
            }
        }

        visited[x][y] = false;
    }

    static void ohOoh(int x, int y) {
        if (x + 2 < n && y + 1 < m) { // ㅏ
            int temp1 = paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y + 1];
            max = Math.max(max, temp1);
        }

        if (x + 2 < n && y - 1 >= 0) { // ㅓ
            int temp2 = paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y - 1];
            max = Math.max(max, temp2);
        }

        if (x - 1 >= 0 && y + 2 < m) { // ㅗ
            int temp3 = paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x - 1][y + 1];
            max = Math.max(max, temp3);
        }

        if (x + 1 < n && y + 2 < m) { // ㅜ
            int temp4 = paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 1];
            max = Math.max(max, temp4);
        }
    }
}
