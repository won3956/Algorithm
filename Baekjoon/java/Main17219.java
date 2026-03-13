import java.io.*;
import java.util.*;

public class Main17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String ts1 = st.nextToken();
            String ts2 = st.nextToken();
            map.put(ts1, ts2);
        }
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }
}
