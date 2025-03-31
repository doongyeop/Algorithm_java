import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 1 <= n <= 40_000
        int[] port = new int[n];
        for (int i = 0; i < n; i++) {
            port[i] = sc.nextInt();
        }
        sc.close();
        /*
         조합으론 안될 것 같음,,
         전깃줄 생각나는ㄷㅔ
         l1 < l2 -> r1 < r2 만족하는 최대 길이 구하기
         최장 증가 수열 구하기
         dp로 하면 시간 터질 것 같음
         이분탐색
        */
        List<Integer> list = new ArrayList<>();
        for (int p : port) {
            int i = Collections.binarySearch(list, p);
            // System.out.println(i);
            if (i < 0) i = (i + 1) * (-1);
            // System.out.println(" " + i);
            if (i == list.size()) {
                list.add(p);
            } else {
                list.set(i, p);
            }
            // System.out.println(list);
        }
        
        System.out.println(list.size());
        
    }
}