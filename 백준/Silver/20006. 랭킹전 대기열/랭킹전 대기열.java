import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt(); // 플레이어의 수
        int m = sc.nextInt(); // 방의 정원

        List<List<Player>> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            int l = sc.nextInt();
            String n = sc.next();
            Player next = new Player(l, n);

            boolean isIn = false;
            for (List<Player> room : rooms) {
                if (room.size() < m && room.get(0).level - 10 <= l && l <= room.get(0).level + 10) {
                    room.add(next);
                    isIn = true;
                    break;
                }
            }
            if (!isIn) {
                List<Player> room = new ArrayList<>();
                room.add(next);
                rooms.add(room);
            }
        }
        sc.close();

        StringBuilder sb = new StringBuilder();
        for (List<Player> room : rooms) {
            Collections.sort(room);

            if (room.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            for (Player player : room) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.println(sb);
    }


}

class Player implements Comparable<Player> {
    int level;
    String name;

    Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player other) {
        return this.name.compareTo(other.name);
    }

}