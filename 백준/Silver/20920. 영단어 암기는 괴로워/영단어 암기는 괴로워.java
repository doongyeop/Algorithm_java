import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String str = sc.next();
            if (str.length() < m) continue;

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<Words> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Words(entry.getKey(), entry.getValue()));
        }
        sc.close();

        Collections.sort(list, new Comparator<Words>() {
            @Override
            public int compare(Words o1, Words o2) {
                if (o1.count == o2.count) {
                    if (o1.word.length() == o2.word.length()) {
                        return o1.word.compareTo(o2.word);
                    }
                    return o2.word.length() - o1.word.length();
                }
                return o2.count - o1.count;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Words w : list) {
            sb.append(w.word).append("\n");
        }

        System.out.println(sb);
    }

    static class Words {
        String word;
        int count;

        public Words(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
