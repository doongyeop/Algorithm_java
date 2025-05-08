class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        
        for (int x = 1; x <= r2; x++) {
            int maxY = (int)Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            int minY = 0;
            if ((long)r1 * r1 - (long)x * x > 0) {
                minY = (int)Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
            }

            count += (maxY - minY + 1);
        }

        return count * 4;
    }
}
