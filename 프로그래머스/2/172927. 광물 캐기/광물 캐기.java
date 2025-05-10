import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int total = picks[0] + picks[1] + picks[2];
        int cnt = Math.min(total, (minerals.length + 4) / 5);

        List<int[]> mines = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = 0; j < 5 && i * 5 + j < minerals.length; j++) {
                String mineral = minerals[i * 5 + j];
                if (mineral.equals("diamond")) dia++;
                else if (mineral.equals("iron")) iron++;
                else stone++;
            }

            mines.add(new int[]{dia, iron, stone});
        }


        mines.sort((a, b) -> {
            int fatigueA = a[0] * 25 + a[1] * 5 + a[2];
            int fatigueB = b[0] * 25 + b[1] * 5 + b[2];
            return fatigueB - fatigueA;
        });

        int ans = 0;
        for (int[] m : mines) {
            if (picks[0] > 0) {
                ans += m[0] * 1 + m[1] * 1 + m[2] * 1;
                picks[0]--;
            } else if (picks[1] > 0) {
                ans += m[0] * 5 + m[1] * 1 + m[2] * 1;
                picks[1]--;
            } else if (picks[2] > 0) {
                ans += m[0] * 25 + m[1] * 5 + m[2] * 1;
                picks[2]--;
            }
        }

        return ans;
    }
}
