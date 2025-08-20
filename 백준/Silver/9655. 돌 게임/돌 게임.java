import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        while (true) {
            // 상근
            if (N / 3 >= 1) {
                N -= 3;
            } else if (N > 0) {
                N-= 1;
            }
            if (N == 0) {
                System.out.println("SK");
                break;
            }

            // 창영
            if (N / 3 >= 1) {
                N -= 3;
            } else if (N > 0) {
                N-= 1;
            }
            if (N == 0) {
                System.out.println("CY");
                break;
            }


        }


    }

}
