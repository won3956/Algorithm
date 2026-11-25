import java.io.*;
import java.util.*;
// 누적 합 문제
public class Main11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];
        int[] sl = new int[N + 1];
        sl[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int l = 1; l <= N; l++) {
            list[l] = Integer.parseInt(st.nextToken());
            sl[l] = sl[l - 1] + list[l];
        }
        for (int l = 0; l < M; l++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(sl[j] - sl[i - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
