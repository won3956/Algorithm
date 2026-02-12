import java.io.*;
import java.util.*;

public class Main5086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a != 0 && b != 0) {
                sb.append(solve(a, b)).append('\n');
            } else {
                System.out.print(sb);
                break;
            }
        }

    }
    static String solve(int a, int b){
        if (a % b == 0) {
            return "multiple";
            
        }
        else if (b % a == 0) {
            return "factor";
        }
        else {
            return "neither";
        }
    }
}


