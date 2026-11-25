import java.io.*;
import java.util.*;

public class Main12789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ent = 0;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == (ent + 1)) {
                ent++;
            } else {
                stack.add(arr[i]);
            }
            while(!stack.empty() && stack.peek() == ent + 1) {
                stack.pop();
                ent++;
            }
        }
        for (int i = 0; i < N - ent; i++) {
            int temp = stack.pop();
            if (temp == (ent + 1)) {
                ent++;
            } else {
                System.out.print("Sad");
                return;
            }
        }
        System.out.print("Nice");
        return;
    }
}
