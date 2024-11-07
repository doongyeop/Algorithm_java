import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int l = sc.nextInt();

        LinkedHashSet<String> set = new LinkedHashSet<>();

        while (l-- > 0) {
            String s = sc.next();
            if (set.contains(s)) set.remove(s);
            set.add(s);
        }
        sc.close();
        List<String> list = new ArrayList<>();

        for (String s : set) {
            list.add(s);
            if (list.size() == k) break;
        }

        for (String s : list) System.out.println(s);

    }
}
