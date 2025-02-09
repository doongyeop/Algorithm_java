import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine()); 

        long l = 1;
        long r = (long) n * n;  

        while (l < r) {
            long m = (l + r) / 2;
            long cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(m / i, n);
            }

            if (k <= cnt) { 
                r = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(l);
    }
}
