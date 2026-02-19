import java.io.*;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        List<String> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>(N+M);
        for (int i = 0; i < N; i++) {
            String tempname = br.readLine();
            map.put(tempname, 1);
        }
        for (int i = 0; i < M; i++) {
            String tempname = br.readLine();
            map.put(tempname, map.getOrDefault(tempname, 0) + 1);
            if (map.get(tempname) > 1) {
                count++;
                list.add(tempname);
            }
        }
        Collections.sort(list);
        for (String name : list) {
            sb.append(name).append('\n');
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
