import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] fileA = split(a);
            String[] fileB = split(b);

            int headCompare = fileA[0].compareToIgnoreCase(fileB[0]);
            if (headCompare != 0) return headCompare;

            int numA = Integer.parseInt(fileA[1]);
            int numB = Integer.parseInt(fileB[1]);
            return Integer.compare(numA, numB);
        });
        return files;
    }

    private String[] split(String file) {
        String head = "", number = "", tail = "";

        int i = 0;
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i++);
        }

        while (i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i++);
            if (number.length() == 5) break;
        }

        if (i < file.length()) {
            tail = file.substring(i);
        }

        return new String[]{head, number, tail};
    }
}
