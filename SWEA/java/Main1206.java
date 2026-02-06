import java.io.*;
import java.util.*;

public class Main1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pn = 1;

        for (int i = 0; i < 10; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            for (int l = 2; l < N - 2; l++) {
                int tempmax = Math.max(arr[l - 2], Math.max(arr[l - 1], Math.max(arr[l + 1], arr[l + 2])));
                if (arr[l] > tempmax) {
                    count += arr[l] - tempmax;
                }
            }
            sb.append('#').append(pn++).append(' ').append(count).append('\n');
            System.out.print(sb);
        }
    }
}
