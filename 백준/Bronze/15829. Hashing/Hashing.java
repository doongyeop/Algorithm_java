import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf(1234567891);
        BigInteger base = BigInteger.valueOf(31);

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int temp = ch - 'a' + 1;
            BigInteger power = base.pow(i);
            sum = sum.add(BigInteger.valueOf(temp).multiply(power));
        }

        System.out.println(sum.mod(mod));
        sc.close();
    }
}
