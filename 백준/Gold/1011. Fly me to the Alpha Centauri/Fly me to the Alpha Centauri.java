import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int dist = y - x;
            int max = (int) Math.sqrt(dist);

            if (max == Math.sqrt(dist)) {
                sb.append(2 * max - 1).append("\n");
            } else if (dist <= max * max + max) {
                sb.append(2 * max).append("\n");
            } else {
                sb.append(2 * max + 1).append("\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}