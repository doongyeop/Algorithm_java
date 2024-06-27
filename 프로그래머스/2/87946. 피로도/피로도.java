class Solution {
    
    int max;
    boolean explored[];
    
    // 던전배열 앞 : 최소필요, 뒤 : 소모 피로도
    public int solution(int k, int[][] dungeons) {
        explored = new boolean[dungeons.length];
        max = 0;
        return explore(k, 0, dungeons);
    }
    
    
    public int explore(int k, int cnt, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!explored[i] && dungeons[i][0] <= k) {
                explored[i] = true;
                explore(k - dungeons[i][1], cnt + 1, dungeons);
                explored[i] = false;
            }
        }    
        max = Math.max(max, cnt);
        return max;
    }
}