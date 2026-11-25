import java.io.*;
import java.util.*;

public class Main11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N - 1; i > -1; i--) {
            if (arr[i] <= K) {
                count += K / arr[i];
                K = K % arr[i];
            }
        }

        System.out.print(count);
    }
}
