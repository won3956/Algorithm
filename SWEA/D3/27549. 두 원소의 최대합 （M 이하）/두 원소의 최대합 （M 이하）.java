import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = 0;
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int l = 0, r = N-1;
			while(l<r) {
				int sum = arr[l] + arr[r];
				if(sum>M) {
					r--;
				}else if(sum<M){
					max = Math.max(max, sum);
					l++;
				}else {
					max = sum;
					break;
				}
				if(l==r) break;
			}
			max = (max==0)?-1:max;
			System.out.println("#"+tc+" "+max);
		}
	}
}
