import java.util.*;

public class Main {

    static int L, C;
    static char alp[], crypto[];
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        alp = new char[C];
        for (int i = 0; i < C; i++) {
            alp[i] = sc.next().charAt(0);
        }
        Arrays.sort(alp);

        sb = new StringBuilder();
        crypto = new char[L];
        visited = new boolean[C];

        dkagh(0, 0);
        System.out.print(sb.toString());
    }

    static void dkagh(int length, int start) {
        if (length == L) {
            if (whrjs()) {
                sb.append(crypto).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            crypto[length] = alp[i];
            dkagh(length + 1, i + 1);
        }
    }

    static boolean whrjs() {
        int ahdma = 0;
        int wkdma = 0;

        for (char c : crypto) {
            if (isahdma(c)) {
                ahdma++;
            } else {
                wkdma++;
            }
        }

        return ahdma >= 1 && wkdma >= 2;
    }

    static boolean isahdma(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
