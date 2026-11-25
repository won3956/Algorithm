import java.io.*;
import java.util.*;
// 옷 중복해서 입지 않기
public class Main9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Map<String, String> map = new HashMap<>();
            Map<String, Integer> cm = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }
            for (String s : map.values()) {
                cm.put(s, cm.getOrDefault(s, 0) + 1);
            }
            int sum = 1;
            for (int j : cm.values()) {
                sum *= (j + 1);
            }
            sb.append(--sum).append('\n');
        
        }
        System.out.print(sb);
    }
}
