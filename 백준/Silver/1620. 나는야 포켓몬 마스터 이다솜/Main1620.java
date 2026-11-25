import java.io.*;
import java.util.*;
// 해시맵
public class Main1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 양방향 해시맵

        HashMap<Integer, String> map = new HashMap<>(N);
        HashMap<String, Integer> map_ = new HashMap<>(N);
        int point = 0;

        while (point++ < N) {
            String tempstr = br.readLine();
            map.put(point, tempstr);
            map_.put(tempstr, point);
        }
        while (M-- > 0) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                String name = map.get(Integer.parseInt(str));
                sb.append(name).append('\n');
            }
            else {
                int num = map_.get(str);
                sb.append(String.valueOf(num)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
