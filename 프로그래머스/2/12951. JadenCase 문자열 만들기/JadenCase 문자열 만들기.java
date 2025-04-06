class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (isStart) {
                sb.append(Character.isLetter(c) ? Character.toUpperCase(c) : c);
                if (!Character.isWhitespace(c)) {
                    isStart = false;
                }
            } else {
                sb.append(Character.isLetter(c) ? Character.toLowerCase(c) : c);
                if (Character.isWhitespace(c)) {
                    isStart = true;
                }
            }
        }

        return sb.toString();
    }
}
