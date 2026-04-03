import java.io.*;
import java.util.*;
// dfs,bfs 결과 출력
public class Main1260 {
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue;
    static int[][] graph;
    static boolean[] visited;

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        queue = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(V);
        sb.append('\n');
        visited = new boolean[N + 1];
        bfs(V);
        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(' ');

        for (int i = 1; i < N + 1; i++) {
            if (graph[node][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(' ');
            
            for (int i = 1; i < N + 1; i++) {
                if (graph[temp][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
