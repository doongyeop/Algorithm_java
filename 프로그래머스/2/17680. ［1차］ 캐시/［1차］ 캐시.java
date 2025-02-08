import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int time = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (set.contains(city)) { 
                queue.remove(city);
                time += 1;
            } else { 
                if (queue.size() >= cacheSize) { 
                    String str = queue.poll(); 
                    set.remove(str);
                }
                time += 5;
            }
            queue.add(city);
            set.add(city);
        }
        return time;
    }
}
