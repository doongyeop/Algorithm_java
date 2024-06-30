import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int time = sc.nextInt();
        int drink = sc.nextInt();

        boolean isLunch = false;
        boolean withDrink = false;

        isLunch = 12 <= time && time <= 16 ? true : false;
        withDrink = drink == 1 ? true : false;

        if (withDrink) {
            System.out.println(280);
        } else {
            if (isLunch) {
                System.out.println(320);
            } else {
                System.out.println(280);
            }
        }
        sc.close();
    }
}
