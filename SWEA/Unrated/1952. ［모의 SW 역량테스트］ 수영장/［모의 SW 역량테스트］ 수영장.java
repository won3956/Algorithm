import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int[] plan;
	static int[] price;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			plan = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			result = price[3]; // 초기값은 1년 회원권
			
			dfs(1, 0); //1월 0원으로 시작
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static void dfs(int month, int cost) {
		if(month>12) {
			result = Math.min(result, cost);
			return;
		}
		if(month == 12) {
			result = Math.min(result, Math.min(cost + price[1], Math.min(cost +plan[month]*price[0], cost +price[2])));
			return;
		}
		
		// 이번 달을 1일권으로 
		dfs(month + 1, cost + plan[month]*price[0]);
		
		// 이번 달을 1달권으로 
		dfs(month + 1, cost + price[1]);

		// 이번 달을 3달권으로 
		dfs(month + 3, cost + price[2]);
	}

}
