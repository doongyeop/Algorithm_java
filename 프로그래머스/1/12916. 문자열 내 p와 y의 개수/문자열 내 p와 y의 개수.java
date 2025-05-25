class Solution {
    boolean solution(String s) {
        
        String str = s.toLowerCase();

        int ps = 0;
        int ys = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'p') {
                ps++;
            } else if (str.charAt(i) == 'y') {
                ys++;
            }
        }

        return ps == ys ? true : false;
    }
}