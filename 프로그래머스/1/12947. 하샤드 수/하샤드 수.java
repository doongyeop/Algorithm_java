class Solution {
    public boolean solution(int x) {
        String str = String.valueOf(x);
        int div = 0;
        for (int i = 0; i < str.length(); i++) {
            div += str.charAt(i) - '0';
        }
        return x % div == 0;
    }
}