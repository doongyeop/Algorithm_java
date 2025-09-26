import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] meet = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            meet[i][0] = sc.nextInt();
            meet[i][1] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(meet, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        
        int end = -1;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (meet[i][0] >= end) {
                end = meet[i][1];
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}