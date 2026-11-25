import java.io.*;
import java.util.*;

/*
 * 2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000
 */

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int H = Integer.parseInt(st.nextToken());
    	
    	int min = N + 1;
    	int same = 0;
    	// 종유석도 뒤집어서 높이로 생각
    	int[] bottom = new int[H + 1];
        int[] top = new int[H + 1];

        for (int i = 0; i < N; i += 2) {
            int bottomLength = Integer.parseInt(br.readLine());
            int topLength = Integer.parseInt(br.readLine());
            bottom[bottomLength]++;
            top[topLength]++;
        }
        
        // 누적합으로 계산
        for (int h = H - 1; h >= 1; h--) {
			bottom[h] += bottom[h + 1];
			top[h] += top[h + 1];
		}
        
        for (int h = 1; h <= H; h++) {
			int cnt = bottom[h] + top[H - h + 1];
			if(cnt < min) {
				min = cnt;
				same = 1;
			}else if(cnt == min) {
				same++;
			}
		}
        
        System.out.println(min + " " + same);
    }
}