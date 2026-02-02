import java.io.*;
import java.util.*;

public class Main2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, n, m);
        System.out.println(result);
    }

    static int search(int[] arr, int n, int m) {
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum > result && sum <= m) {
                        result = sum;
                        if (result == m) {
                            return result;
                        }
                    }
                }

            }
        }
        return result;
    }
}
