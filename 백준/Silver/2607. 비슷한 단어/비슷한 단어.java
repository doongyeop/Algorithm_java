import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String base = sc.next();
        int[] baseFreq = getCharFreq(base);

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            String word = sc.next();
            int[] wordFreq = getCharFreq(word);

            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(baseFreq[j] - wordFreq[j]);
            }

            if (diff == 0 || diff == 1 || (diff == 2 && base.length() == word.length())) {
                cnt++;
            }
        }

        System.out.println(cnt);
        sc.close();
    }

    private static int[] getCharFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'A']++;
        }
        return freq;
    }
}
