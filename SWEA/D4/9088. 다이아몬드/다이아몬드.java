
import java.io.*;
import java.util.*;

public class Solution {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int left = 0;
            int answer = 0;

            for (int right = 0; right < N; right++) {

                while (arr[right] - arr[left] > K) {
                    left++;
                }

                answer = Math.max(answer, right - left + 1);
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
