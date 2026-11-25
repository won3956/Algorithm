import java.io.*;
import java.util.*;
// 웜 바이러스에 걸린 컴퓨터 수 구하기 > dfs
public class Main2606 {
    public static int[][] node;
    public static boolean[] visited;
    public static int N;
    public static int M;
    public static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        node = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }

        dfs(1);
        System.out.print(result - 1);
    }

    public static void dfs(int target) {

        visited[target] = true;
        result++;

        for (int i = 1; i < N + 1; i++) {
            if (node[target][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
