import java.io.*;
public class Main10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];
        int point = 0;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                arr[point++] = n;
            } else {
                if (point != 0) {
                    arr[--point] = 0;
                }
            }

        }
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        System.out.print(sum);
    }
}
