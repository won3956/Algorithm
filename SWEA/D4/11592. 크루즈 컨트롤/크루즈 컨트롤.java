import java.io.*;
import java.util.*;

public class Solution {
	static int D, N;
	static double v;
	static class Horse{
		int start;
		int speed;
		public Horse(int start, int speed) {
			this.start = start;
			this.speed = speed;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			v = Double.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				Horse horse = new Horse(k, s);
				find(horse);
			}
			
			System.out.printf("#%d %.7f\n", test_case, v);
		}
	}
	public static void find(Horse horse) {
		double canV = (float) D * horse.speed / (D - horse.start);
		if(canV < v) {
			v = canV;
		}
	}
}
