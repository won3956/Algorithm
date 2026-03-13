import java.io.*;
import java.util.*;

public class Main1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(1);
            list1.add(0);
            list2.add(0);
            list2.add(1);
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append('1').append(' ').append('0').append('\n');
            }
            else if (N == 1) {
                sb.append('0').append(' ').append('1').append('\n');
            }
            else {
                for (int k = 2; k <= N; k++) {
                    list1.add(list1.get(k - 1) + list1.get(k - 2));
                    list2.add(list2.get(k - 1) + list2.get(k - 2));
                }
                sb.append(list1.get(list1.size()-1)).append(' ').append(list2.get(list2.size()-1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
