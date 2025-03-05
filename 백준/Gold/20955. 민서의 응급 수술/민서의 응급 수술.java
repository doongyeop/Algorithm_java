import java.util.*;
import java.io.*;

class Main {

    static int n, m, p[], cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            union(u, v);
        }
        br.close();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(find(i));
        }

        System.out.println(set.size() - 1 + cnt);
    }

    private static int find(int a) {
        if (p[a] != a) p[a] = find(p[a]);
        return p[a];
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA > pB) {
            p[pA] = pB;
        } else if (pA < pB) {
            p[pB] = pA;
        } else {
            cnt++;
        }
    }
}