import java.util.*;

public class Main {

    static int n, max;
    static Egg[] eggs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(); 
            int w = sc.nextInt(); 
            eggs[i] = new Egg(s, w);
        }
        sc.close();

        max = 0;
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int idx) {
        if (idx == n) {
            int cnt = 0;
            for (Egg e : eggs) {
                if (e.s <= 0) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        if (eggs[idx].s <= 0) {
            dfs(idx + 1); 
            return;
        }

        boolean isHit = false;
        for (int i = 0; i < n; i++) {
            if (i == idx || eggs[i].s <= 0) continue;

            isHit = true;

            eggs[idx].s -= eggs[i].w;
            eggs[i].s -= eggs[idx].w;

            dfs(idx + 1); 

            eggs[idx].s += eggs[i].w;
            eggs[i].s += eggs[idx].w;
        }

        if (!isHit) {
            dfs(idx + 1);
        }
    }

    static class Egg {
        int s, w;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
