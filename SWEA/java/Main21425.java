import java.io.*;
import java.util.*;

public class Main21425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            sb.append(solve(x,y,N)).append('\n');
        }
        System.out.print(sb);
    }

    public static int solve(int x, int y, int N){
        int count = 0;
        
        while (x <= N && y <= N) {
            if (x > y) {
                y += x;
                count++;
            } else {
                x += y;
                count++;
            }
        }
        
        return (count);
    }
}
