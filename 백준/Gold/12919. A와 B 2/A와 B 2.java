import java.io.*;

public class Main {
    static String s, t;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        br.close();

        dfs(t);
        System.out.println(ans);
    }

    static void dfs(String str) {
        if (str.length() == s.length()) {
            if (str.equals(s)) ans = 1;
            return;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            dfs(sb.substring(0, sb.length() - 1));
        }
    }
}
