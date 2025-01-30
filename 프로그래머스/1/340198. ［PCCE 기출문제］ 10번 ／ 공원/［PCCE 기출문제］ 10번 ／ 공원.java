import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats); 
        int x = park.length;
        int y = park[0].length;
        
        for (int i = mats.length - 1; i >= 0; i--) { 
            int size = mats[i];
            if (park(size, park, x, y)) {
                return size;
            }
        }
        return -1; 
    }
    
    boolean park(int size, String[][] park, int rows, int cols) {
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (tryMat(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean tryMat(int x, int y, int size, String[][] park) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
