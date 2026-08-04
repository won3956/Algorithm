
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int result; //정답, 손해 없는 최대 집의 개수
	
	static class House{
		int x;
		int y;
		House(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());	// M: 한집당 비용
			ArrayList<House> houses = new ArrayList<>();
			result = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if(st.nextToken().equals("1")) {
						houses.add(new House(i, j));
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int K = 1; K <= 2*N; K++) {
						int count = 0;
						
						for(House house : houses) {
							if(isIn(i, j, house.x, house.y, K) == true) {
								count++;
							}
						}
						if(K*K+(K-1)*(K-1)<=count*M) {
							if(count > result) {
								result = count;
							}
						}
						
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static boolean isIn(int x, int y, int x2, int y2, int K) {
		if(Math.abs(x2 - x)+Math.abs(y2 - y)<K) {
			return true;
		}else {
			return false;
		}
		
	}
}
