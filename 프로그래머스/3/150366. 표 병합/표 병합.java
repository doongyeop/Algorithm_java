import java.util.*;

class Solution {
    
    class Chart {
        int r;
        int c;
        String value;

        Chart(int r, int c, String value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

    }

    String EMPTY = "EMPTY";
    Map<String, Chart> map = new HashMap<>(); // "r,c" -> Chart
    Set<List<Chart>> mergeSet = new HashSet<>();
    List<String> ans = new ArrayList<>();

    public List<String> solution(String[] commands) {
        for (String command : commands) {
            runCommand(command);
        }
        return ans;
    }

    void runCommand(String command) {
        String[] tokens = command.split(" ");
        String cmd = tokens[0];

        if (cmd.equals("UPDATE")) {
            if (tokens.length == 4) {
                int r = Integer.parseInt(tokens[1]);
                int c = Integer.parseInt(tokens[2]);
                String value = tokens[3];
                updateCell(r, c, value);
            } else {
                String v1 = tokens[1];
                String v2 = tokens[2];
                updateAll(v1, v2);
            }
        } else if (cmd.equals("MERGE")) {
            int r1 = Integer.parseInt(tokens[1]);
            int c1 = Integer.parseInt(tokens[2]);
            int r2 = Integer.parseInt(tokens[3]);
            int c2 = Integer.parseInt(tokens[4]);
            mergeCells(r1, c1, r2, c2);
        } else if (cmd.equals("UNMERGE")) {
            int r = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);
            unmergeCell(r, c);
        } else if (cmd.equals("PRINT")) {
            int r = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);
            printCell(r, c);
        }
    }

    void updateCell(int r, int c, String value) {
        Chart target = getOrCreateChart(r, c);
        List<Chart> group = findGroup(r, c);
        if (group == null) {
            target.value = value;
        } else {
            for (Chart ch : group) {
                ch.value = value;
            }
        }
    }

    void updateAll(String from, String to) {
        for (Chart ch : map.values()) {
            if (ch.value != null && ch.value.equals(from)) {
                ch.value = to;
            }
        }
    }

    void mergeCells(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) return;

        Chart ch1 = getOrCreateChart(r1, c1);
        Chart ch2 = getOrCreateChart(r2, c2);

        List<Chart> group1 = findGroup(r1, c1);
        List<Chart> group2 = findGroup(r2, c2);

        Set<Chart> newGroupSet = new HashSet<>();

        if (group1 != null) newGroupSet.addAll(group1);
        else newGroupSet.add(ch1);

        if (group2 != null) newGroupSet.addAll(group2);
        else newGroupSet.add(ch2);

        mergeSet.remove(group1);
        mergeSet.remove(group2);

        List<Chart> newGroup = new ArrayList<>(newGroupSet);
        String finalValue = ch1.value != null ? ch1.value : ch2.value;
        for (Chart ch : newGroup) ch.value = finalValue;

        mergeSet.add(newGroup);
    }

    void unmergeCell(int r, int c) {
        List<Chart> group = findGroup(r, c);
        if (group == null) return;

        Chart main = getOrCreateChart(r, c);
        String mainValue = main.value;

        for (Chart ch : group) {
            ch.value = null;
        }

        main.value = mainValue;
        mergeSet.remove(group);
    }

    void printCell(int r, int c) {
        Chart ch = getOrCreateChart(r, c);
        ans.add((ch.value == null || ch.value.isEmpty()) ? EMPTY : ch.value);
    }

    Chart getOrCreateChart(int r, int c) {
        String key = r + "," + c;
        if (!map.containsKey(key)) {
            map.put(key, new Chart(r, c, null));
        }
        return map.get(key);
    }

    List<Chart> findGroup(int r, int c) {
        Chart target = getOrCreateChart(r, c);
        for (List<Chart> group : mergeSet) {
            if (group.contains(target)) return group;
        }
        return null;
    }
}
