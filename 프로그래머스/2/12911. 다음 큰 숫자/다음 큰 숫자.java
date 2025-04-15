class Solution {
    public int solution(int n) {
        int nOnes = Integer.bitCount(n);
        int next = n + 1;

        while (Integer.bitCount(next) != nOnes) {
            next++;
        }

        return next;
    }
}
