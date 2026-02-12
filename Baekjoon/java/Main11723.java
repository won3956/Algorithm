import java.io.*;
import java.util.*;

// 비트마스크
public class Main11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int S = 0;
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("all")) {
                S = (1 << 20) - 1;
            }
            else if (str.equals("empty")) {
                S = 0;
            }
            else {
                if (str.equals("add")) {
                    int n = Integer.parseInt(st.nextToken());
                    S |= (1 << (n - 1));
                }
                else if (str.equals("remove")) {
                    int n = Integer.parseInt(st.nextToken());
                    S &= ~(1 << (n - 1));
                }
                else if (str.equals("check")) {
                    int n = Integer.parseInt(st.nextToken());
                    sb.append((S & (1<<(n-1))) == 0 ? 0 : 1).append('\n');
                }
                else if (str.equals("toggle")) {
                    int n = Integer.parseInt(st.nextToken());
                    S ^= (1 << (n - 1));
                }
            }
        }
        System.out.print(sb);
    }
}
