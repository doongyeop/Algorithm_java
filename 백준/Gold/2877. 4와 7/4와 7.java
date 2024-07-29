import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        String str = Integer.toBinaryString(K + 1).substring(1);

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0') {
                sb.append("4");
            } else {
                sb.append("7");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
