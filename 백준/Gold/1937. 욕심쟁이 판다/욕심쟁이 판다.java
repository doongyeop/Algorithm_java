
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map, mapCnt;    
    static boolean[][] visited;     
    static int N, answer = 0;       
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        visited[x][y] = true;       

        for(int d=0; d<4; d++) {   
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(map[nx][ny] <= map[x][y]) continue;    

            if(visited[nx][ny]) {                        
                mapCnt[x][y] = Math.max(mapCnt[x][y], mapCnt[nx][ny] + 1); 
                answer = answer < mapCnt[x][y] ? mapCnt[x][y] : answer;
                continue;
            }

            dfs(nx, ny);     
            mapCnt[x][y] = Math.max(mapCnt[x][y], mapCnt[nx][ny] + 1);
            answer = answer < mapCnt[x][y] ? mapCnt[x][y] : answer;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        map = new int[N][N];
        mapCnt = new int[N][N];
        answer = 1;                                          
        for(int i=0; i<N; i++) Arrays.fill(mapCnt[i], 1);     
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;          
                dfs(i, j);                          
            }
        }

        System.out.println(answer);
    }
}

