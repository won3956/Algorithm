import java.io.*;
import java.util.*;
// 유기농 배추 dfs로 풀이
public class Main1012 {
    static int[][] map;
    static boolean[][] visited;
    static int M, N, K;

    // 상하좌우 이동 정의
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            int count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] == 1 && visited[y][x] == false) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int x, int y) {
        visited[y][x] = true;

        for(int i = 0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (map[ny][nx] == 1 && visited[ny][nx] == false) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
