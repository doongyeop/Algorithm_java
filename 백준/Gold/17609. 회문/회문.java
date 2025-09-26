import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = sc.next();

            if (isPalindrome(str, 0, str.length() - 1)) {
                sb.append("0").append("\n");
            } else if (isSemiPalindrome(str)) {
                sb.append("1").append("\n");
            } else {
                sb.append("2").append("\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isSemiPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return isPalindrome(str, left + 1, right) ||
                        isPalindrome(str, left, right - 1);
            }
            left++;
            right--;
        }
        return false;
    }

    static boolean isPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
